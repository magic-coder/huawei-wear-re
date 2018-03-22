package com.android.volley;

import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class InternalUtils {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    InternalUtils() {
    }

    private static String convertToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = HEX_CHARS[i2 >>> 4];
            cArr[(i * 2) + 1] = HEX_CHARS[i2 & 15];
        }
        return new String(cArr);
    }

    public static String sha1Hash(String str) {
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            instance.update(bytes, 0, bytes.length);
            str2 = convertToHex(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return str2;
    }
}
