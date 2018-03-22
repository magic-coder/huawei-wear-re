package com.squareup.okhttp.internal;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final Sink NULL_SINK = new C26283();
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new C26261();
    private final File directory;
    private final Executor executor;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    class C26261 implements Runnable {
        C26261() {
        }

        public void run() {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                    return;
                }
                try {
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class C26272 implements Iterator<Snapshot> {
        final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;

        C26272() {
        }

        public boolean hasNext() {
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.isClosed()) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Snapshot snapshot = ((Entry) this.delegate.next()).snapshot();
                    if (snapshot != null) {
                        this.nextSnapshot = snapshot;
                        return true;
                    }
                }
                return false;
            }
        }

        public Snapshot next() {
            if (hasNext()) {
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                return this.removeSnapshot;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.removeSnapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.remove(this.removeSnapshot.key);
            } catch (IOException e) {
            } finally {
                this.removeSnapshot = null;
            }
        }
    }

    final class C26283 implements Sink {
        C26283() {
        }

        public void write(Buffer buffer, long j) throws IOException {
        }

        public void flush() throws IOException {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void close() throws IOException {
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        class FaultHidingSink extends ForwardingSink {
            public FaultHidingSink(Sink sink) {
                super(sink);
            }

            public void write(Buffer buffer, long j) throws IOException {
                try {
                    super.write(buffer, j);
                } catch (IOException e) {
                    synchronized (DiskLruCache.this) {
                        Editor.this.hasErrors = true;
                    }
                }
            }

            public void flush() throws IOException {
                try {
                    super.flush();
                } catch (IOException e) {
                    synchronized (DiskLruCache.this) {
                        Editor.this.hasErrors = true;
                    }
                }
            }

            public void close() throws IOException {
                try {
                    super.close();
                } catch (IOException e) {
                    synchronized (DiskLruCache.this) {
                        Editor.this.hasErrors = true;
                    }
                }
            }
        }

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public Source newSource(int i) throws IOException {
            Source source = null;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (this.entry.readable) {
                    try {
                        source = Okio.source(this.entry.cleanFiles[i]);
                    } catch (FileNotFoundException e) {
                    }
                }
            }
            return source;
        }

        public String getString(int i) throws IOException {
            Source newSource = newSource(i);
            return newSource != null ? DiskLruCache.sourceToString(newSource) : null;
        }

        public Sink newSink(int i) throws IOException {
            Sink access$2400;
            synchronized (DiskLruCache.this) {
                Sink sink;
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                try {
                    sink = Okio.sink(this.entry.dirtyFiles[i]);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.directory.mkdirs();
                    try {
                        sink = Okio.sink(r0);
                    } catch (FileNotFoundException e2) {
                        access$2400 = DiskLruCache.NULL_SINK;
                    }
                }
                access$2400 = new FaultHidingSink(sink);
            }
            return access$2400;
        }

        public void set(int i, String str) throws IOException {
            BufferedSink buffer = Okio.buffer(newSink(i));
            buffer.writeUtf8(str);
            buffer.close();
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.hasErrors) {
                    DiskLruCache.this.completeEdit(this, false);
                    DiskLruCache.this.removeEntry(this.entry);
                } else {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.committed = true;
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.completeEdit(this, false);
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.committed) {
                    try {
                        DiskLruCache.this.completeEdit(this, false);
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    final class Entry {
        private final File[] cleanFiles;
        private Editor currentEditor;
        private final File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                append.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.setLength(length);
            }
        }

        private void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw invalidLengths(strArr);
                }
            }
        }

        void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long l : this.lengths) {
                bufferedSink.writeByte(32).writeUtf8(Long.toString(l));
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        Snapshot snapshot() {
            int i = 0;
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.valueCount];
                int i2 = 0;
                while (i2 < DiskLruCache.this.valueCount) {
                    try {
                        sourceArr[i2] = Okio.source(this.cleanFiles[i2]);
                        i2++;
                    } catch (FileNotFoundException e) {
                        while (i < DiskLruCache.this.valueCount && sourceArr[i] != null) {
                            Util.closeQuietly(sourceArr[i]);
                            i++;
                        }
                        return null;
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, sourceArr, this.lengths);
            }
            throw new AssertionError();
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        private Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public String key() {
            return this.key;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.sourceToString(getSource(i));
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (Closeable closeQuietly : this.sources) {
                Util.closeQuietly(closeQuietly);
            }
        }
    }

    DiskLruCache(File file, int i, int i2, long j, Executor executor) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    void initialize() throws IOException {
        if (this.journalFileBackup.exists()) {
            if (this.journalFile.exists()) {
                this.journalFileBackup.delete();
            } else {
                renameTo(this.journalFileBackup, this.journalFile, false);
            }
        }
        if (this.journalFile.exists()) {
            try {
                readJournal();
                processJournal();
                return;
            } catch (IOException e) {
                Platform.get().logW("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing");
                delete();
            }
        }
        this.directory.mkdirs();
        rebuildJournal();
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
            diskLruCache.initialize();
            return diskLruCache;
        }
    }

    private void readJournal() throws IOException {
        Closeable buffer = Okio.buffer(Okio.source(this.journalFile));
        int i;
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (MAGIC.equals(readUtf8LineStrict) && "1".equals(readUtf8LineStrict2) && Integer.toString(this.appVersion).equals(readUtf8LineStrict3) && Integer.toString(this.valueCount).equals(readUtf8LineStrict4) && "".equals(readUtf8LineStrict5)) {
                i = 0;
                while (true) {
                    readJournalLine(buffer.readUtf8LineStrict());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
        } catch (EOFException e) {
            this.redundantOpCount = i - this.lruEntries.size();
            if (buffer.exhausted()) {
                this.journalWriter = Okio.buffer(Okio.appendingSink(this.journalFile));
            } else {
                rebuildJournal();
            }
            Util.closeQuietly(buffer);
        } catch (Throwable th) {
            Util.closeQuietly(buffer);
        }
    }

    private void readJournalLine(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        Entry entry = (Entry) this.lruEntries.get(str2);
        if (entry == null) {
            entry = new Entry(str2);
            this.lruEntries.put(str2, entry);
        }
        if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(HwAccountConstants.BLANK);
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else if (indexOf2 != -1 || indexOf != READ.length() || !str.startsWith(READ)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i;
            if (entry.currentEditor == null) {
                for (i = 0; i < this.valueCount; i++) {
                    this.size += entry.lengths[i];
                }
            } else {
                entry.currentEditor = null;
                for (i = 0; i < this.valueCount; i++) {
                    deleteIfExists(entry.cleanFiles[i]);
                    deleteIfExists(entry.dirtyFiles[i]);
                }
                it.remove();
            }
        }
    }

    private synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        BufferedSink buffer = Okio.buffer(Okio.sink(this.journalFileTmp));
        try {
            buffer.writeUtf8(MAGIC).writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeUtf8(Integer.toString(this.appVersion)).writeByte(10);
            buffer.writeUtf8(Integer.toString(this.valueCount)).writeByte(10);
            buffer.writeByte(10);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    buffer.writeUtf8(DIRTY).writeByte(32);
                    buffer.writeUtf8(entry.key);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8(CLEAN).writeByte(32);
                    buffer.writeUtf8(entry.key);
                    entry.writeLengths(buffer);
                    buffer.writeByte(10);
                }
            }
            buffer.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = Okio.buffer(Okio.appendingSink(this.journalFile));
        } catch (Throwable th) {
            buffer.close();
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        Snapshot snapshot;
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null || !entry.readable) {
            snapshot = null;
        } else {
            snapshot = entry.snapshot();
            if (snapshot == null) {
                snapshot = null;
            } else {
                this.redundantOpCount++;
                this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
                if (journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
            }
        }
        return snapshot;
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    private synchronized Editor edit(String str, long j) throws IOException {
        Editor editor;
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
            Entry entry2;
            if (entry == null) {
                entry = new Entry(str);
                this.lruEntries.put(str, entry);
                entry2 = entry;
            } else if (entry.currentEditor != null) {
                editor = null;
            } else {
                entry2 = entry;
            }
            editor = new Editor(entry2);
            entry2.currentEditor = editor;
            this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.journalWriter.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executor.execute(this.cleanupRunnable);
    }

    public synchronized long size() {
        return this.size;
    }

    private synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            Entry access$1500 = editor.entry;
            if (access$1500.currentEditor != editor) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!access$1500.readable) {
                    int i2 = 0;
                    while (i2 < this.valueCount) {
                        if (!editor.written[i2]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!access$1500.dirtyFiles[i2].exists()) {
                            editor.abort();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.valueCount) {
                File file = access$1500.dirtyFiles[i];
                if (!z) {
                    deleteIfExists(file);
                } else if (file.exists()) {
                    File file2 = access$1500.cleanFiles[i];
                    file.renameTo(file2);
                    long j = access$1500.lengths[i];
                    long length = file2.length();
                    access$1500.lengths[i] = length;
                    this.size = (this.size - j) + length;
                }
                i++;
            }
            this.redundantOpCount++;
            access$1500.currentEditor = null;
            if ((access$1500.readable | z) != 0) {
                access$1500.readable = true;
                this.journalWriter.writeUtf8(CLEAN).writeByte(32);
                this.journalWriter.writeUtf8(access$1500.key);
                access$1500.writeLengths(this.journalWriter);
                this.journalWriter.writeByte(10);
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    access$1500.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(access$1500.key);
                this.journalWriter.writeUtf8(REMOVE).writeByte(32);
                this.journalWriter.writeUtf8(access$1500.key);
                this.journalWriter.writeByte(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        boolean z;
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            z = false;
        } else {
            z = removeEntry(entry);
        }
        return z;
    }

    private boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.hasErrors = true;
        }
        for (int i = 0; i < this.valueCount; i++) {
            deleteIfExists(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry((Entry) this.lruEntries.values().iterator().next());
        }
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    public synchronized void evictAll() throws IOException {
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static String sourceToString(Source source) throws IOException {
        try {
            String readUtf8 = Okio.buffer(source).readUtf8();
            return readUtf8;
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    public synchronized Iterator<Snapshot> snapshots() {
        return new C26272();
    }
}
