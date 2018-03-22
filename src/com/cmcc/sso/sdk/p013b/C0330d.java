package com.cmcc.sso.sdk.p013b;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

public final class C0330d {
    private static final char[] f186a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest f187b;

    static {
        f187b = null;
        try {
            f187b = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
        }
    }

    public static String m211a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            f187b.update(fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length()));
            fileInputStream.close();
            return C0330d.m213a(f187b.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String m212a(String str) {
        f187b.update(str.getBytes());
        return C0330d.m213a(f187b.digest());
    }

    private static String m213a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = bArr[length];
            char c = f186a[(b & 240) >> 4];
            char c2 = f186a[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
