package com.huawei.uploadlog.p188c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: MD5 */
public class C2512h {
    private static String f8999a = "2PaUTG6raILAA7p2jLok9+GC5ifEECF4k4dChqs9nVyVEeACIFEjv1z0K57fjag3dTI8CQQCZS+AN92QpezmgLWbIZ5rZXJsWSSnsRE869XoC384Bhx10OR0KLrDJzEjKcpnlzG2S4LsTAcMhWoyFBq3SUTs/AkBgmZhdDkmf69yVNRUJVTMLqO";

    public static String m12485a() {
        return f8999a;
    }

    public static String m12486a(File file) {
        MessageDigest instance;
        Throwable e;
        Closeable fileInputStream;
        RuntimeException e2;
        Throwable th;
        Throwable th2;
        Closeable closeable;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (Throwable e3) {
            C2511g.m12481b("LogUpload Service", "初始化失败，MessageDigest不支持MD5Util。");
            C2511g.m12482b("BetaClub Upload", "getFileMD5String error:", e3);
            instance = null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                C2517m.m12571a(fileInputStream, "LogUpload Service");
            } catch (RuntimeException e4) {
                e2 = e4;
                try {
                    throw e2;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable e5) {
                th2 = e5;
                closeable = fileInputStream;
                e3 = th2;
                try {
                    C2511g.m12482b("LogUpload Service", "MD5 Exception", e3);
                    C2517m.m12571a(closeable, "LogUpload Service");
                    if (instance != null) {
                        return C2512h.m12487a(instance.digest());
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = closeable;
                    C2517m.m12571a(fileInputStream, "LogUpload Service");
                    throw th;
                }
            }
        } catch (RuntimeException e6) {
            RuntimeException runtimeException = e6;
            fileInputStream = null;
            e2 = runtimeException;
            throw e2;
        } catch (Exception e7) {
            e3 = e7;
            closeable = null;
            C2511g.m12482b("LogUpload Service", "MD5 Exception", e3);
            C2517m.m12571a(closeable, "LogUpload Service");
            if (instance != null) {
                return null;
            }
            return C2512h.m12487a(instance.digest());
        } catch (Throwable e32) {
            th2 = e32;
            fileInputStream = null;
            th = th2;
            C2517m.m12571a(fileInputStream, "LogUpload Service");
            throw th;
        }
        if (instance != null) {
            return C2512h.m12487a(instance.digest());
        }
        return null;
    }

    private static String m12487a(byte[] bArr) {
        return C2512h.m12488a(bArr, 0, bArr.length);
    }

    private static String m12488a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            C2512h.m12489a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void m12489a(byte b, StringBuffer stringBuffer) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
