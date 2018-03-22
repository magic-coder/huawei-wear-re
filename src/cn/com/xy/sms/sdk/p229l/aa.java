package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class aa {
    public static String m13583a(File file) {
        Throwable e;
        Closeable closeable;
        Closeable fileInputStream;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                instance.update(fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length()));
                String a = aa.m13584a(instance.digest());
                C3055t.m13696a(fileInputStream);
                return a;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                closeable = fileInputStream;
                try {
                    C2982a.m13415a("XIAOYUAN", "getFileMD5String: " + e.getMessage(), e);
                    C3055t.m13696a(closeable);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    fileInputStream = closeable;
                    C3055t.m13696a(fileInputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                try {
                    C2982a.m13415a("XIAOYUAN", "getFileMD5String: " + e.getMessage(), e);
                    C3055t.m13696a(fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    e = th3;
                    C3055t.m13696a(fileInputStream);
                    throw e;
                }
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            closeable = null;
            C2982a.m13415a("XIAOYUAN", "getFileMD5String: " + e.getMessage(), e);
            C3055t.m13696a(closeable);
            return null;
        } catch (Throwable th4) {
            e = th4;
            fileInputStream = null;
            C3055t.m13696a(fileInputStream);
            throw e;
        }
    }

    private static String m13584a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        String str = "0123456789abcdef";
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        while (i2 < bArr.length) {
            cArr[i] = str.charAt((bArr[i2] >> 4) & 15);
            i++;
            cArr[i] = str.charAt(bArr[i2] & 15);
            i2++;
            i++;
        }
        return String.valueOf(cArr);
    }
}
