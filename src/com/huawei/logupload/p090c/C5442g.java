package com.huawei.logupload.p090c;

import com.huawei.logupload.c.f;
import com.huawei.logupload.c.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class C5442g {
    private static String f19275a = "+Wy0+6EFY29lMbUZks2YmyQ0hV7/hGWwABZY0ENkZvfGAhrvOjWaqDuaFGhG5S+dz5pzxhsdFBC//HEhJQ6Ik1y8wYVedNyYllONrpkglxlsEqClqtx8zQKBgQDKc3XXKgaowiISI9go3kc4fmpnvj6dERrccm+M+XQ7opsRChuTR//bYkKPTMliQJg9TfLvP37EKU1D8pEaxsCe9dywaLHA+qS";

    public static String m26095a() {
        return f19275a;
    }

    public static String m26096a(File file) {
        MessageDigest instance;
        RuntimeException e;
        Throwable th;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            f.b("LogUpload Service", "初始化失败，MessageDigest不支持MD5Util。");
            e2.printStackTrace();
            instance = null;
        }
        InputStream fileInputStream;
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
                h.a(fileInputStream, "LogUpload Service");
            } catch (RuntimeException e3) {
                e = e3;
            } catch (Exception e4) {
            }
        } catch (RuntimeException e5) {
            RuntimeException runtimeException = e5;
            fileInputStream = null;
            e = runtimeException;
            try {
                throw e;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            fileInputStream = null;
            f.b("LogUpload Service", "MD5 Exception");
            h.a(fileInputStream, "LogUpload Service");
            if (instance == null) {
                return null;
            }
            return C5442g.m26097a(instance.digest());
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            h.a(fileInputStream, "LogUpload Service");
            throw th;
        }
        if (instance == null) {
            return C5442g.m26097a(instance.digest());
        }
        return null;
    }

    private static String m26097a(byte[] bArr) {
        return C5442g.m26098a(bArr, 0, bArr.length);
    }

    private static String m26098a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            C5442g.m26099a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void m26099a(byte b, StringBuffer stringBuffer) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
