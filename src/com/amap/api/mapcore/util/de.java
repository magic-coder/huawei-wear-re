package com.amap.api.mapcore.util;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class de implements Closeable {
    static final Pattern f11695a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream f11696q = new dg();
    final ThreadPoolExecutor f11697b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File f11698c;
    private final File f11699d;
    private final File f11700e;
    private final File f11701f;
    private final int f11702g;
    private long f11703h;
    private final int f11704i;
    private long f11705j = 0;
    private Writer f11706k;
    private final LinkedHashMap<String, C3314c> f11707l = new LinkedHashMap(0, 0.75f, true);
    private int f11708m;
    private dh f11709n;
    private long f11710o = 0;
    private final Callable<Void> f11711p = new df(this);

    /* compiled from: DiskLruCache */
    public final class C3312a {
        final /* synthetic */ de f11679a;
        private final C3314c f11680b;
        private final boolean[] f11681c;
        private boolean f11682d;
        private boolean f11683e;

        /* compiled from: DiskLruCache */
        class C3311a extends FilterOutputStream {
            final /* synthetic */ C3312a f11678a;

            private C3311a(C3312a c3312a, OutputStream outputStream) {
                this.f11678a = c3312a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f11678a.f11682d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f11678a.f11682d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f11678a.f11682d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f11678a.f11682d = true;
                }
            }
        }

        private C3312a(de deVar, C3314c c3314c) {
            this.f11679a = deVar;
            this.f11680b = c3314c;
            this.f11681c = c3314c.f11692d ? null : new boolean[deVar.f11704i];
        }

        public OutputStream m16006a(int i) throws IOException {
            if (i < 0 || i >= this.f11679a.f11704i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f11679a.f11704i);
            }
            OutputStream d;
            synchronized (this.f11679a) {
                File b;
                OutputStream fileOutputStream;
                if (this.f11680b.f11693e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f11680b.f11692d) {
                    this.f11681c[i] = true;
                }
                b = this.f11680b.m16023b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    this.f11679a.f11698c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        d = de.f11696q;
                    }
                }
                d = new C3311a(fileOutputStream);
            }
            return d;
        }

        public void m16007a() throws IOException {
            if (this.f11682d) {
                this.f11679a.m16028a(this, false);
                this.f11679a.m16052c(this.f11680b.f11690b);
            } else {
                this.f11679a.m16028a(this, true);
            }
            this.f11683e = true;
        }

        public void m16008b() throws IOException {
            this.f11679a.m16028a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class C3313b implements Closeable {
        final /* synthetic */ de f11684a;
        private final String f11685b;
        private final long f11686c;
        private final InputStream[] f11687d;
        private final long[] f11688e;

        private C3313b(de deVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f11684a = deVar;
            this.f11685b = str;
            this.f11686c = j;
            this.f11687d = inputStreamArr;
            this.f11688e = jArr;
        }

        public InputStream m16009a(int i) {
            return this.f11687d[i];
        }

        public void close() {
            for (Closeable a : this.f11687d) {
                dj.m16057a(a);
            }
        }
    }

    /* compiled from: DiskLruCache */
    final class C3314c {
        final /* synthetic */ de f11689a;
        private final String f11690b;
        private final long[] f11691c;
        private boolean f11692d;
        private C3312a f11693e;
        private long f11694f;

        private C3314c(de deVar, String str) {
            this.f11689a = deVar;
            this.f11690b = str;
            this.f11691c = new long[deVar.f11704i];
        }

        public String m16022a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f11691c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        private void m16014a(String[] strArr) throws IOException {
            if (strArr.length != this.f11689a.f11704i) {
                throw m16016b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f11691c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m16016b(strArr);
                }
            }
        }

        private IOException m16016b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File m16021a(int i) {
            return new File(this.f11689a.f11698c, this.f11690b + "." + i);
        }

        public File m16023b(int i) {
            return new File(this.f11689a.f11698c, this.f11690b + "." + i + ".tmp");
        }
    }

    public void m16047a(dh dhVar) {
        this.f11709n = dhVar;
    }

    private de(File file, int i, int i2, long j) {
        this.f11698c = file;
        this.f11702g = i;
        this.f11699d = new File(file, "journal");
        this.f11700e = new File(file, "journal.tmp");
        this.f11701f = new File(file, "journal.bkp");
        this.f11704i = i2;
        this.f11703h = j;
    }

    public static de m16026a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m16031a(file2, file3, false);
                }
            }
            de deVar = new de(file, i, i2, j);
            if (deVar.f11699d.exists()) {
                try {
                    deVar.m16038e();
                    deVar.m16041f();
                    deVar.f11706k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(deVar.f11699d, true), dj.f11719a));
                    return deVar;
                } catch (IOException e) {
                    deVar.m16051c();
                }
            }
            file.mkdirs();
            deVar = new de(file, i, i2, j);
            deVar.m16042g();
            return deVar;
        }
    }

    private void m16038e() throws IOException {
        int i;
        Closeable diVar = new di(new FileInputStream(this.f11699d), dj.f11719a);
        try {
            String a = diVar.m16056a();
            String a2 = diVar.m16056a();
            String a3 = diVar.m16056a();
            String a4 = diVar.m16056a();
            String a5 = diVar.m16056a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f11702g).equals(a3) && Integer.toString(this.f11704i).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    m16036d(diVar.m16056a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f11708m = i - this.f11707l.size();
            dj.m16057a(diVar);
        } catch (Throwable th) {
            dj.m16057a(diVar);
        }
    }

    private void m16036d(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f11707l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C3314c c3314c = (C3314c) this.f11707l.get(str2);
        if (c3314c == null) {
            c3314c = new C3314c(str2);
            this.f11707l.put(str2, c3314c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(HwAccountConstants.BLANK);
            c3314c.f11692d = true;
            c3314c.f11693e = null;
            c3314c.m16014a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c3314c.f11693e = new C3312a(c3314c);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m16041f() throws IOException {
        m16030a(this.f11700e);
        Iterator it = this.f11707l.values().iterator();
        while (it.hasNext()) {
            C3314c c3314c = (C3314c) it.next();
            int i;
            if (c3314c.f11693e == null) {
                for (i = 0; i < this.f11704i; i++) {
                    this.f11705j += c3314c.f11691c[i];
                }
            } else {
                c3314c.f11693e = null;
                for (i = 0; i < this.f11704i; i++) {
                    m16030a(c3314c.m16021a(i));
                    m16030a(c3314c.m16023b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m16042g() throws IOException {
        if (this.f11706k != null) {
            this.f11706k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f11700e), dj.f11719a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f11702g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f11704i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C3314c c3314c : this.f11707l.values()) {
                if (c3314c.f11693e != null) {
                    bufferedWriter.write("DIRTY " + c3314c.f11690b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c3314c.f11690b + c3314c.m16022a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f11699d.exists()) {
                m16031a(this.f11699d, this.f11701f, true);
            }
            m16031a(this.f11700e, this.f11699d, false);
            this.f11701f.delete();
            this.f11706k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f11699d, true), dj.f11719a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void m16030a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m16031a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m16030a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized C3313b m16046a(String str) throws IOException {
        int i;
        C3313b c3313b = null;
        synchronized (this) {
            m16044i();
            m16039e(str);
            C3314c c3314c = (C3314c) this.f11707l.get(str);
            if (c3314c != null) {
                InputStream[] inputStreamArr;
                if (c3314c.f11692d) {
                    inputStreamArr = new InputStream[this.f11704i];
                    int i2 = 0;
                    while (i2 < this.f11704i) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(c3314c.m16021a(i2));
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.f11704i && inputStreamArr[i] != null) {
                                dj.m16057a(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.f11708m++;
                    this.f11706k.append("READ " + str + '\n');
                    if (m16043h()) {
                        this.f11697b.submit(this.f11711p);
                    }
                    c3313b = new C3313b(str, c3314c.f11694f, inputStreamArr, c3314c.f11691c);
                }
            }
        }
        return c3313b;
    }

    public C3312a m16049b(String str) throws IOException {
        return m16025a(str, -1);
    }

    private synchronized C3312a m16025a(String str, long j) throws IOException {
        C3312a c3312a;
        m16044i();
        m16039e(str);
        C3314c c3314c = (C3314c) this.f11707l.get(str);
        if (j == -1 || (c3314c != null && c3314c.f11694f == j)) {
            C3314c c3314c2;
            if (c3314c == null) {
                c3314c = new C3314c(str);
                this.f11707l.put(str, c3314c);
                c3314c2 = c3314c;
            } else if (c3314c.f11693e != null) {
                c3312a = null;
            } else {
                c3314c2 = c3314c;
            }
            c3312a = new C3312a(c3314c2);
            c3314c2.f11693e = c3312a;
            this.f11706k.write("DIRTY " + str + '\n');
            this.f11706k.flush();
        } else {
            c3312a = null;
        }
        return c3312a;
    }

    private synchronized void m16028a(C3312a c3312a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C3314c a = c3312a.f11680b;
            if (a.f11693e != c3312a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f11692d) {
                    int i2 = 0;
                    while (i2 < this.f11704i) {
                        if (!c3312a.f11681c[i2]) {
                            c3312a.m16008b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m16023b(i2).exists()) {
                            c3312a.m16008b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f11704i) {
                File b = a.m16023b(i);
                if (!z) {
                    m16030a(b);
                } else if (b.exists()) {
                    File a2 = a.m16021a(i);
                    b.renameTo(a2);
                    long j = a.f11691c[i];
                    long length = a2.length();
                    a.f11691c[i] = length;
                    this.f11705j = (this.f11705j - j) + length;
                }
                i++;
            }
            this.f11708m++;
            a.f11693e = null;
            if ((a.f11692d | z) != 0) {
                a.f11692d = true;
                this.f11706k.write("CLEAN " + a.f11690b + a.m16022a() + '\n');
                if (z) {
                    long j2 = this.f11710o;
                    this.f11710o = 1 + j2;
                    a.f11694f = j2;
                }
            } else {
                this.f11707l.remove(a.f11690b);
                this.f11706k.write("REMOVE " + a.f11690b + '\n');
            }
            this.f11706k.flush();
            if (this.f11705j > this.f11703h || m16043h()) {
                this.f11697b.submit(this.f11711p);
            }
        }
    }

    private boolean m16043h() {
        return this.f11708m >= 2000 && this.f11708m >= this.f11707l.size();
    }

    public synchronized boolean m16052c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m16044i();
            m16039e(str);
            C3314c c3314c = (C3314c) this.f11707l.get(str);
            if (c3314c == null || c3314c.f11693e != null) {
                z = false;
            } else {
                while (i < this.f11704i) {
                    File a = c3314c.m16021a(i);
                    if (!a.exists() || a.delete()) {
                        this.f11705j -= c3314c.f11691c[i];
                        c3314c.f11691c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f11708m++;
                this.f11706k.append("REMOVE " + str + '\n');
                this.f11707l.remove(str);
                if (m16043h()) {
                    this.f11697b.submit(this.f11711p);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean m16048a() {
        return this.f11706k == null;
    }

    private void m16044i() {
        if (this.f11706k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void m16050b() throws IOException {
        m16044i();
        m16045j();
        this.f11706k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f11706k != null) {
            Iterator it = new ArrayList(this.f11707l.values()).iterator();
            while (it.hasNext()) {
                C3314c c3314c = (C3314c) it.next();
                if (c3314c.f11693e != null) {
                    c3314c.f11693e.m16008b();
                }
            }
            m16045j();
            this.f11706k.close();
            this.f11706k = null;
        }
    }

    private void m16045j() throws IOException {
        while (this.f11705j > this.f11703h) {
            String str = (String) ((Entry) this.f11707l.entrySet().iterator().next()).getKey();
            m16052c(str);
            if (this.f11709n != null) {
                this.f11709n.mo4023a(str);
            }
        }
    }

    public void m16051c() throws IOException {
        close();
        dj.m16058a(this.f11698c);
    }

    private void m16039e(String str) {
        if (!f11695a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
