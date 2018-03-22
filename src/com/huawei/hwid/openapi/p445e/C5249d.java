package com.huawei.hwid.openapi.p445e;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class C5249d {
    private static char[] f18883a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String m25452a(String str) {
        String str2 = "";
        if (str != null) {
            try {
                str2 = C5249d.m25453a(MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.defaultCharset())));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    private static String m25453a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr != null) {
            for (byte b : bArr) {
                stringBuffer.append(f18883a[(b >>> 4) & 15]);
                stringBuffer.append(f18883a[b & 15]);
            }
        }
        return stringBuffer.toString();
    }
}
