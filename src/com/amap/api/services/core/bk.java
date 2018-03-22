package com.amap.api.services.core;

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
public final class bk implements Closeable {
    static final Pattern f12437a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream f12438q = new bm();
    final ThreadPoolExecutor f12439b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File f12440c;
    private final File f12441d;
    private final File f12442e;
    private final File f12443f;
    private final int f12444g;
    private long f12445h;
    private final int f12446i;
    private long f12447j = 0;
    private Writer f12448k;
    private final LinkedHashMap<String, C3404c> f12449l = new LinkedHashMap(0, 0.75f, true);
    private int f12450m;
    private bn f12451n;
    private long f12452o = 0;
    private final Callable<Void> f12453p = new bl(this);

    /* compiled from: DiskLruCache */
    public final class C3402a {
        final /* synthetic */ bk f12421a;
        private final C3404c f12422b;
        private final boolean[] f12423c;
        private boolean f12424d;
        private boolean f12425e;

        /* compiled from: DiskLruCache */
        class C3401a extends FilterOutputStream {
            final /* synthetic */ C3402a f12420a;

            private C3401a(C3402a c3402a, OutputStream outputStream) {
                this.f12420a = c3402a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f12420a.f12424d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f12420a.f12424d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f12420a.f12424d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f12420a.f12424d = true;
                }
            }
        }

        private C3402a(bk bkVar, C3404c c3404c) {
            this.f12421a = bkVar;
            this.f12422b = c3404c;
            this.f12423c = c3404c.f12434d ? null : new boolean[bkVar.f12446i];
        }

        public OutputStream m16794a(int i) throws IOException {
            if (i < 0 || i >= this.f12421a.f12446i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f12421a.f12446i);
            }
            OutputStream d;
            synchronized (this.f12421a) {
                File b;
                OutputStream fileOutputStream;
                if (this.f12422b.f12435e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f12422b.f12434d) {
                    this.f12423c[i] = true;
                }
                b = this.f12422b.m16811b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    this.f12421a.f12440c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        d = bk.f12438q;
                    }
                }
                d = new C3401a(fileOutputStream);
            }
            return d;
        }

        public void m16795a() throws IOException {
            if (this.f12424d) {
                this.f12421a.m16816a(this, false);
                this.f12421a.m16840c(this.f12422b.f12432b);
            } else {
                this.f12421a.m16816a(this, true);
            }
            this.f12425e = true;
        }

        public void m16796b() throws IOException {
            this.f12421a.m16816a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class C3403b implements Closeable {
        final /* synthetic */ bk f12426a;
        private final String f12427b;
        private final long f12428c;
        private final InputStream[] f12429d;
        private final long[] f12430e;

        private C3403b(bk bkVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f12426a = bkVar;
            this.f12427b = str;
            this.f12428c = j;
            this.f12429d = inputStreamArr;
            this.f12430e = jArr;
        }

        public InputStream m16797a(int i) {
            return this.f12429d[i];
        }

        public void close() {
            for (Closeable a : this.f12429d) {
                bp.m16845a(a);
            }
        }
    }

    /* compiled from: DiskLruCache */
    final class C3404c {
        final /* synthetic */ bk f12431a;
        private final String f12432b;
        private final long[] f12433c;
        private boolean f12434d;
        private C3402a f12435e;
        private long f12436f;

        private C3404c(bk bkVar, String str) {
            this.f12431a = bkVar;
            this.f12432b = str;
            this.f12433c = new long[bkVar.f12446i];
        }

        public String m16810a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f12433c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        private void m16802a(String[] strArr) throws IOException {
            if (strArr.length != this.f12431a.f12446i) {
                throw m16804b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f12433c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m16804b(strArr);
                }
            }
        }

        private IOException m16804b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File m16809a(int i) {
            return new File(this.f12431a.f12440c, this.f12432b + "." + i);
        }

        public File m16811b(int i) {
            return new File(this.f12431a.f12440c, this.f12432b + "." + i + ".tmp");
        }
    }

    public void m16835a(bn bnVar) {
        this.f12451n = bnVar;
    }

    private bk(File file, int i, int i2, long j) {
        this.f12440c = file;
        this.f12444g = i;
        this.f12441d = new File(file, "journal");
        this.f12442e = new File(file, "journal.tmp");
        this.f12443f = new File(file, "journal.bkp");
        this.f12446i = i2;
        this.f12445h = j;
    }

    public static bk m16814a(File file, int i, int i2, long j) throws IOException {
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
                    m16819a(file2, file3, false);
                }
            }
            bk bkVar = new bk(file, i, i2, j);
            if (bkVar.f12441d.exists()) {
                try {
                    bkVar.m16826e();
                    bkVar.m16829f();
                    bkVar.f12448k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bkVar.f12441d, true), bp.f12461a));
                    return bkVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    bkVar.m16839c();
                }
            }
            file.mkdirs();
            bkVar = new bk(file, i, i2, j);
            bkVar.m16830g();
            return bkVar;
        }
    }

    private void m16826e() throws IOException {
        Closeable boVar = new bo(new FileInputStream(this.f12441d), bp.f12461a);
        int i;
        try {
            String a = boVar.m16844a();
            String a2 = boVar.m16844a();
            String a3 = boVar.m16844a();
            String a4 = boVar.m16844a();
            String a5 = boVar.m16844a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f12444g).equals(a3) && Integer.toString(this.f12446i).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    m16824d(boVar.m16844a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f12450m = i - this.f12449l.size();
            bp.m16845a(boVar);
        } catch (Throwable th) {
            bp.m16845a(boVar);
        }
    }

    private void m16824d(String str) throws IOException {
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
                this.f12449l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C3404c c3404c = (C3404c) this.f12449l.get(str2);
        if (c3404c == null) {
            c3404c = new C3404c(str2);
            this.f12449l.put(str2, c3404c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(HwAccountConstants.BLANK);
            c3404c.f12434d = true;
            c3404c.f12435e = null;
            c3404c.m16802a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c3404c.f12435e = new C3402a(c3404c);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m16829f() throws IOException {
        m16818a(this.f12442e);
        Iterator it = this.f12449l.values().iterator();
        while (it.hasNext()) {
            C3404c c3404c = (C3404c) it.next();
            int i;
            if (c3404c.f12435e == null) {
                for (i = 0; i < this.f12446i; i++) {
                    this.f12447j += c3404c.f12433c[i];
                }
            } else {
                c3404c.f12435e = null;
                for (i = 0; i < this.f12446i; i++) {
                    m16818a(c3404c.m16809a(i));
                    m16818a(c3404c.m16811b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m16830g() throws IOException {
        if (this.f12448k != null) {
            this.f12448k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12442e), bp.f12461a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12444g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12446i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C3404c c3404c : this.f12449l.values()) {
                if (c3404c.f12435e != null) {
                    bufferedWriter.write("DIRTY " + c3404c.f12432b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c3404c.f12432b + c3404c.m16810a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f12441d.exists()) {
                m16819a(this.f12441d, this.f12443f, true);
            }
            m16819a(this.f12442e, this.f12441d, false);
            this.f12443f.delete();
            this.f12448k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12441d, true), bp.f12461a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void m16818a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m16819a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m16818a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized C3403b m16834a(String str) throws IOException {
        int i;
        C3403b c3403b = null;
        synchronized (this) {
            m16832i();
            m16827e(str);
            C3404c c3404c = (C3404c) this.f12449l.get(str);
            if (c3404c != null) {
                if (c3404c.f12434d) {
                    InputStream[] inputStreamArr = new InputStream[this.f12446i];
                    int i2 = 0;
                    while (i2 < this.f12446i) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(c3404c.m16809a(i2));
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.f12446i && inputStreamArr[i] != null) {
                                bp.m16845a(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.f12450m++;
                    this.f12448k.append("READ " + str + '\n');
                    if (m16831h()) {
                        this.f12439b.submit(this.f12453p);
                    }
                    c3403b = new C3403b(str, c3404c.f12436f, inputStreamArr, c3404c.f12433c);
                }
            }
        }
        return c3403b;
    }

    public C3402a m16837b(String str) throws IOException {
        return m16813a(str, -1);
    }

    private synchronized C3402a m16813a(String str, long j) throws IOException {
        C3402a c3402a;
        m16832i();
        m16827e(str);
        C3404c c3404c = (C3404c) this.f12449l.get(str);
        if (j == -1 || (c3404c != null && c3404c.f12436f == j)) {
            C3404c c3404c2;
            if (c3404c == null) {
                c3404c = new C3404c(str);
                this.f12449l.put(str, c3404c);
                c3404c2 = c3404c;
            } else if (c3404c.f12435e != null) {
                c3402a = null;
            } else {
                c3404c2 = c3404c;
            }
            c3402a = new C3402a(c3404c2);
            c3404c2.f12435e = c3402a;
            this.f12448k.write("DIRTY " + str + '\n');
            this.f12448k.flush();
        } else {
            c3402a = null;
        }
        return c3402a;
    }

    private synchronized void m16816a(C3402a c3402a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C3404c a = c3402a.f12422b;
            if (a.f12435e != c3402a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f12434d) {
                    int i2 = 0;
                    while (i2 < this.f12446i) {
                        if (!c3402a.f12423c[i2]) {
                            c3402a.m16796b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m16811b(i2).exists()) {
                            c3402a.m16796b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f12446i) {
                File b = a.m16811b(i);
                if (!z) {
                    m16818a(b);
                } else if (b.exists()) {
                    File a2 = a.m16809a(i);
                    b.renameTo(a2);
                    long j = a.f12433c[i];
                    long length = a2.length();
                    a.f12433c[i] = length;
                    this.f12447j = (this.f12447j - j) + length;
                }
                i++;
            }
            this.f12450m++;
            a.f12435e = null;
            if ((a.f12434d | z) != 0) {
                a.f12434d = true;
                this.f12448k.write("CLEAN " + a.f12432b + a.m16810a() + '\n');
                if (z) {
                    long j2 = this.f12452o;
                    this.f12452o = 1 + j2;
                    a.f12436f = j2;
                }
            } else {
                this.f12449l.remove(a.f12432b);
                this.f12448k.write("REMOVE " + a.f12432b + '\n');
            }
            this.f12448k.flush();
            if (this.f12447j > this.f12445h || m16831h()) {
                this.f12439b.submit(this.f12453p);
            }
        }
    }

    private boolean m16831h() {
        return this.f12450m >= 2000 && this.f12450m >= this.f12449l.size();
    }

    public synchronized boolean m16840c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m16832i();
            m16827e(str);
            C3404c c3404c = (C3404c) this.f12449l.get(str);
            if (c3404c == null || c3404c.f12435e != null) {
                z = false;
            } else {
                while (i < this.f12446i) {
                    File a = c3404c.m16809a(i);
                    if (!a.exists() || a.delete()) {
                        this.f12447j -= c3404c.f12433c[i];
                        c3404c.f12433c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f12450m++;
                this.f12448k.append("REMOVE " + str + '\n');
                this.f12449l.remove(str);
                if (m16831h()) {
                    this.f12439b.submit(this.f12453p);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean m16836a() {
        return this.f12448k == null;
    }

    private void m16832i() {
        if (this.f12448k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void m16838b() throws IOException {
        m16832i();
        m16833j();
        this.f12448k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f12448k != null) {
            Iterator it = new ArrayList(this.f12449l.values()).iterator();
            while (it.hasNext()) {
                C3404c c3404c = (C3404c) it.next();
                if (c3404c.f12435e != null) {
                    c3404c.f12435e.m16796b();
                }
            }
            m16833j();
            this.f12448k.close();
            this.f12448k = null;
        }
    }

    private void m16833j() throws IOException {
        while (this.f12447j > this.f12445h) {
            String str = (String) ((Entry) this.f12449l.entrySet().iterator().next()).getKey();
            m16840c(str);
            if (this.f12451n != null) {
                this.f12451n.mo4115a(str);
            }
        }
    }

    public void m16839c() throws IOException {
        close();
        bp.m16846a(this.f12440c);
    }

    private void m16827e(String str) {
        if (!f12437a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
