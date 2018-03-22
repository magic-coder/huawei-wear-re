package com.aps;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class ay implements Closeable {
    static final Pattern f12984a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream f12985p = new be();
    final ThreadPoolExecutor f12986b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File f12987c;
    private final File f12988d;
    private final File f12989e;
    private final File f12990f;
    private final int f12991g;
    private long f12992h;
    private final int f12993i;
    private long f12994j = 0;
    private Writer f12995k;
    private final LinkedHashMap<String, bb> f12996l = new LinkedHashMap(0, 0.75f, true);
    private int f12997m;
    private long f12998n = 0;
    private final Callable<Void> f12999o = new bd(this);

    private ay(File file, int i, int i2, long j) {
        this.f12987c = file;
        this.f12991g = i;
        this.f12988d = new File(file, "journal");
        this.f12989e = new File(file, "journal.tmp");
        this.f12990f = new File(file, "journal.bkp");
        this.f12993i = i2;
        this.f12992h = j;
    }

    public static ay m17357a(File file, int i, int i2, long j) throws IOException {
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
                    m17363a(file2, file3, false);
                }
            }
            ay ayVar = new ay(file, i, i2, j);
            if (ayVar.f12988d.exists()) {
                try {
                    ayVar.m17366c();
                    ayVar.m17368d();
                    ayVar.f12995k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ayVar.f12988d, true), bt.f13069a));
                    return ayVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    ayVar.m17379a();
                }
            }
            file.mkdirs();
            ayVar = new ay(file, i, i2, j);
            ayVar.m17372e();
            return ayVar;
        }
    }

    private void m17366c() throws IOException {
        int i;
        Closeable brVar = new br(new FileInputStream(this.f12988d), bt.f13069a);
        try {
            String a = brVar.m17444a();
            String a2 = brVar.m17444a();
            String a3 = brVar.m17444a();
            String a4 = brVar.m17444a();
            String a5 = brVar.m17444a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f12991g).equals(a3) && Integer.toString(this.f12993i).equals(a4) && "".equals(a5)) {
                i = 0;
                while (true) {
                    m17370d(brVar.m17444a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f12997m = i - this.f12996l.size();
            bt.m17445a(brVar);
        } catch (Throwable th) {
            bt.m17445a(brVar);
        }
    }

    private void m17370d(String str) throws IOException {
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
                this.f12996l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        bb bbVar = (bb) this.f12996l.get(str2);
        if (bbVar == null) {
            bbVar = new bb(this, str2);
            this.f12996l.put(str2, bbVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(HwAccountConstants.BLANK);
            bbVar.f13009d = true;
            bbVar.f13010e = null;
            bbVar.m17393a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            bbVar.f13010e = new az(this, bbVar);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m17368d() throws IOException {
        m17362a(this.f12989e);
        Iterator it = this.f12996l.values().iterator();
        while (it.hasNext()) {
            bb bbVar = (bb) it.next();
            int i;
            if (bbVar.f13010e == null) {
                for (i = 0; i < this.f12993i; i++) {
                    this.f12994j += bbVar.f13008c[i];
                }
            } else {
                bbVar.f13010e = null;
                for (i = 0; i < this.f12993i; i++) {
                    m17362a(bbVar.m17400a(i));
                    m17362a(bbVar.m17402b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m17372e() throws IOException {
        if (this.f12995k != null) {
            this.f12995k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12989e), bt.f13069a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12991g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12993i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (bb bbVar : this.f12996l.values()) {
                if (bbVar.f13010e != null) {
                    bufferedWriter.write("DIRTY " + bbVar.f13007b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bbVar.f13007b + bbVar.m17401a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f12988d.exists()) {
                m17363a(this.f12988d, this.f12990f, true);
            }
            m17363a(this.f12989e, this.f12988d, false);
            this.f12990f.delete();
            this.f12995k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12988d, true), bt.f13069a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void m17362a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m17363a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m17362a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized bc m17378a(String str) throws IOException {
        bc bcVar = null;
        synchronized (this) {
            if (this.f12995k != null) {
                m17376g();
                m17373e(str);
                bb bbVar = (bb) this.f12996l.get(str);
                if (bbVar != null && bbVar.f13009d) {
                    InputStream[] inputStreamArr = new InputStream[this.f12993i];
                    int i = 0;
                    while (i < this.f12993i) {
                        try {
                            inputStreamArr[i] = new FileInputStream(bbVar.m17400a(i));
                            i++;
                        } catch (FileNotFoundException e) {
                            int i2 = 0;
                            while (i2 < this.f12993i && inputStreamArr[i2] != null) {
                                bt.m17445a(inputStreamArr[i2]);
                                i2++;
                            }
                        }
                    }
                    this.f12997m++;
                    this.f12995k.append("READ " + str + '\n');
                    if (m17375f()) {
                        this.f12986b.submit(this.f12999o);
                    }
                    bcVar = new bc(this, str, bbVar.f13011f, inputStreamArr, bbVar.f13008c);
                }
            }
        }
        return bcVar;
    }

    public az m17380b(String str) throws IOException {
        return m17358a(str, -1);
    }

    private synchronized az m17358a(String str, long j) throws IOException {
        az azVar;
        if (this.f12995k == null) {
            azVar = null;
        } else {
            m17376g();
            m17373e(str);
            bb bbVar = (bb) this.f12996l.get(str);
            if (j == -1 || (bbVar != null && bbVar.f13011f == j)) {
                bb bbVar2;
                if (bbVar == null) {
                    bbVar = new bb(this, str);
                    this.f12996l.put(str, bbVar);
                    bbVar2 = bbVar;
                } else if (bbVar.f13010e != null) {
                    azVar = null;
                } else {
                    bbVar2 = bbVar;
                }
                azVar = new az(this, bbVar2);
                bbVar2.f13010e = azVar;
                this.f12995k.write("DIRTY " + str + '\n');
                this.f12995k.flush();
            } else {
                azVar = null;
            }
        }
        return azVar;
    }

    private synchronized void m17361a(az azVar, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            bb a = azVar.f13001b;
            if (a.f13010e != azVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f13009d) {
                    int i2 = 0;
                    while (i2 < this.f12993i) {
                        if (!azVar.f13002c[i2]) {
                            azVar.m17387b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m17402b(i2).exists()) {
                            azVar.m17387b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f12993i) {
                File b = a.m17402b(i);
                if (!z) {
                    m17362a(b);
                } else if (b.exists()) {
                    File a2 = a.m17400a(i);
                    b.renameTo(a2);
                    long j = a.f13008c[i];
                    long length = a2.length();
                    a.f13008c[i] = length;
                    this.f12994j = (this.f12994j - j) + length;
                }
                i++;
            }
            this.f12997m++;
            a.f13010e = null;
            if ((a.f13009d | z) != 0) {
                a.f13009d = true;
                this.f12995k.write("CLEAN " + a.f13007b + a.m17401a() + '\n');
                if (z) {
                    long j2 = this.f12998n;
                    this.f12998n = 1 + j2;
                    a.f13011f = j2;
                }
            } else {
                this.f12996l.remove(a.f13007b);
                this.f12995k.write("REMOVE " + a.f13007b + '\n');
            }
            this.f12995k.flush();
            if (this.f12994j > this.f12992h || m17375f()) {
                this.f12986b.submit(this.f12999o);
            }
        }
    }

    private boolean m17375f() {
        return this.f12997m >= 2000 && this.f12997m >= this.f12996l.size();
    }

    public synchronized boolean m17381c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m17376g();
            m17373e(str);
            bb bbVar = (bb) this.f12996l.get(str);
            if (bbVar == null || bbVar.f13010e != null) {
                z = false;
            } else {
                while (i < this.f12993i) {
                    File a = bbVar.m17400a(i);
                    if (!a.exists() || a.delete()) {
                        this.f12994j -= bbVar.f13008c[i];
                        bbVar.f13008c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f12997m++;
                this.f12995k.append("REMOVE " + str + '\n');
                this.f12996l.remove(str);
                if (m17375f()) {
                    this.f12986b.submit(this.f12999o);
                }
                z = true;
            }
        }
        return z;
    }

    private void m17376g() {
        if (this.f12995k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f12995k != null) {
            Iterator it = new ArrayList(this.f12996l.values()).iterator();
            while (it.hasNext()) {
                bb bbVar = (bb) it.next();
                if (bbVar.f13010e != null) {
                    bbVar.f13010e.m17387b();
                }
            }
            m17377h();
            this.f12995k.close();
            this.f12995k = null;
        }
    }

    private void m17377h() throws IOException {
        while (this.f12994j > this.f12992h) {
            m17381c((String) ((Entry) this.f12996l.entrySet().iterator().next()).getKey());
        }
    }

    public void m17379a() throws IOException {
        close();
        bt.m17446a(this.f12987c);
    }

    private void m17373e(String str) {
        if (!f12984a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
