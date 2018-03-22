package com.p230a.p231b.p232b.p233a.p236a;

import android.os.SystemClock;
import com.p230a.p231b.p232b.p233a.C3088b;
import com.p230a.p231b.p232b.p233a.C3104c;
import com.p230a.p231b.p232b.p233a.C3121x;
import com.sina.weibo.sdk.component.GameManager;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C3089c implements C3088b {
    private final Map f10378a;
    private long f10379b;
    private final File f10380c;
    private final int f10381d;

    public C3089c(File file) {
        this(file, 5242880);
    }

    public C3089c(File file, int i) {
        this.f10378a = new LinkedHashMap(16, 0.75f, true);
        this.f10379b = 0;
        this.f10380c = file;
        this.f10381d = i;
    }

    static int m13806a(InputStream inputStream) {
        return (((C3089c.m13817e(inputStream) | 0) | (C3089c.m13817e(inputStream) << 8)) | (C3089c.m13817e(inputStream) << 16)) | (C3089c.m13817e(inputStream) << 24);
    }

    static void m13807a(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void m13808a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m13809a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        C3089c.m13808a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m13810a(String str, C3099m c3099m) {
        if (this.f10378a.containsKey(str)) {
            C3099m c3099m2 = (C3099m) this.f10378a.get(str);
            this.f10379b = (c3099m.f10388a - c3099m2.f10388a) + this.f10379b;
        } else {
            this.f10379b += c3099m.f10388a;
        }
        this.f10378a.put(str, c3099m);
    }

    static void m13811a(Map map, OutputStream outputStream) {
        if (map != null) {
            C3089c.m13807a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                C3089c.m13809a(outputStream, (String) entry.getKey());
                C3089c.m13809a(outputStream, (String) entry.getValue());
            }
            return;
        }
        C3089c.m13807a(outputStream, 0);
    }

    private static byte[] m13812a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m13813b(InputStream inputStream) {
        return (((((((0 | (((long) C3089c.m13817e(inputStream)) & 255)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 8)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 16)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 24)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 32)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 40)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 48)) | ((((long) C3089c.m13817e(inputStream)) & 255) << 56);
    }

    static String m13814c(InputStream inputStream) {
        return new String(C3089c.m13812a(inputStream, (int) C3089c.m13813b(inputStream)), GameManager.DEFAULT_CHARSET);
    }

    private static String m13815d(String str) {
        int length = str.length() / 2;
        return new StringBuilder(String.valueOf(String.valueOf(str.substring(0, length).hashCode()))).append(String.valueOf(str.substring(length).hashCode())).toString();
    }

    static Map m13816d(InputStream inputStream) {
        int a = C3089c.m13806a(inputStream);
        Map emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(C3089c.m13814c(inputStream).intern(), C3089c.m13814c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m13817e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public synchronized C3104c mo3652a(String str) {
        C3104c c3104c;
        C3100n c3100n;
        IOException e;
        C3100n c3100n2;
        Throwable th;
        C3099m c3099m = (C3099m) this.f10378a.get(str);
        if (c3099m == null) {
            c3104c = null;
        } else {
            File c = m13822c(str);
            try {
                c3100n = new C3100n(new FileInputStream(c));
                try {
                    C3099m.m13839a((InputStream) c3100n);
                    byte[] a = C3089c.m13812a((InputStream) c3100n, (int) (c.length() - ((long) c3100n.f10395a)));
                    C3104c c3104c2 = new C3104c();
                    c3104c2.f10410a = a;
                    c3104c2.f10411b = c3099m.f10390c;
                    c3104c2.f10412c = c3099m.f10391d;
                    c3104c2.f10413d = c3099m.f10392e;
                    c3104c2.f10414e = c3099m.f10393f;
                    c3104c2.f10415f = c3099m.f10394g;
                    try {
                        c3100n.close();
                        c3104c = c3104c2;
                    } catch (IOException e2) {
                        c3104c = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    c3100n2 = c3100n;
                    try {
                        C3121x.m13907b("%s: %s", c.getAbsolutePath(), e.toString());
                        m13821b(str);
                        if (c3100n2 != null) {
                            try {
                                c3100n2.close();
                            } catch (IOException e4) {
                                c3104c = null;
                            }
                        }
                        c3104c = null;
                        return c3104c;
                    } catch (Throwable th2) {
                        th = th2;
                        c3100n = c3100n2;
                        if (c3100n != null) {
                            try {
                                c3100n.close();
                            } catch (IOException e5) {
                                c3104c = null;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (c3100n != null) {
                        c3100n.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                c3100n2 = null;
                C3121x.m13907b("%s: %s", c.getAbsolutePath(), e.toString());
                m13821b(str);
                if (c3100n2 != null) {
                    c3100n2.close();
                }
                c3104c = null;
                return c3104c;
            } catch (Throwable th4) {
                th = th4;
                c3100n = null;
                if (c3100n != null) {
                    c3100n.close();
                }
                throw th;
            }
        }
        return c3104c;
    }

    public synchronized void mo3653a() {
        FileInputStream fileInputStream;
        Throwable th;
        if (this.f10380c.exists()) {
            File[] listFiles = this.f10380c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            C3099m a = C3099m.m13839a((InputStream) fileInputStream);
                            a.f10388a = file.length();
                            m13810a(a.f10389b, a);
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    fileInputStream2 = fileInputStream;
                                    th = th3;
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        fileInputStream = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.f10380c.mkdirs()) {
            C3121x.m13908c("Unable to create cache dir %s", this.f10380c.getAbsolutePath());
        }
        return;
        throw th;
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
    }

    public synchronized void mo3654a(String str, C3104c c3104c) {
        int i = 0;
        synchronized (this) {
            int length = c3104c.f10410a.length;
            if (this.f10379b + ((long) length) >= ((long) this.f10381d)) {
                int i2;
                if (C3121x.f10470b) {
                    C3121x.m13905a("Pruning old cache entries.", new Object[0]);
                }
                long j = this.f10379b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.f10378a.entrySet().iterator();
                while (it.hasNext()) {
                    C3099m c3099m = (C3099m) ((Entry) it.next()).getValue();
                    if (m13822c(c3099m.f10389b).delete()) {
                        this.f10379b -= c3099m.f10388a;
                    } else {
                        C3121x.m13907b("Could not delete cache entry for key=%s, filename=%s", c3099m.f10389b, C3089c.m13815d(c3099m.f10389b));
                    }
                    it.remove();
                    i2 = i + 1;
                    if (((float) (this.f10379b + ((long) length))) < ((float) this.f10381d) * 0.9f) {
                        break;
                    }
                    i = i2;
                }
                i2 = i;
                if (C3121x.f10470b) {
                    C3121x.m13905a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f10379b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File c = m13822c(str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(c);
                C3099m c3099m2 = new C3099m(str, c3104c);
                c3099m2.m13840a(fileOutputStream);
                fileOutputStream.write(c3104c.f10410a);
                fileOutputStream.close();
                m13810a(str, c3099m2);
            } catch (IOException e) {
                if (!c.delete()) {
                    C3121x.m13907b("Could not clean up file %s", c.getAbsolutePath());
                }
            }
        }
    }

    public synchronized void m13821b(String str) {
        boolean delete = m13822c(str).delete();
        C3099m c3099m = (C3099m) this.f10378a.get(str);
        if (c3099m != null) {
            this.f10379b -= c3099m.f10388a;
            this.f10378a.remove(str);
        }
        if (!delete) {
            C3121x.m13907b("Could not delete cache entry for key=%s, filename=%s", str, C3089c.m13815d(str));
        }
    }

    public File m13822c(String str) {
        return new File(this.f10380c, C3089c.m13815d(str));
    }
}
