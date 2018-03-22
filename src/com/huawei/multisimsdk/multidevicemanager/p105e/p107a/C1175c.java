package com.huawei.multisimsdk.multidevicemanager.p105e.p107a;

import android.text.TextUtils;
import com.sina.weibo.sdk.component.GameManager;
import java.nio.charset.Charset;

/* compiled from: SecurityCodeUtil */
public class C1175c {
    private static int f2574a = 7;
    private static int f2575b = 4;
    private static final Charset f2576c = Charset.forName(GameManager.DEFAULT_CHARSET);

    public static String m5270a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        return C1175c.m5269a(C1175c.m5271b(C1175c.m5269a(C1175c.m5268a(str, f2575b), str3), f2574a), str2);
    }

    private static String m5268a(String str, int i) {
        if (TextUtils.isEmpty(str) || str.length() < i) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str.toCharArray();
        for (int i2 = 0; i2 < toCharArray.length; i2++) {
            if (i2 - i < 0) {
                toCharArray2[(toCharArray.length - i) + i2] = toCharArray[i2];
            } else {
                toCharArray2[i2 - i] = toCharArray[i2];
            }
        }
        return new String(toCharArray2);
    }

    private static String m5271b(String str, int i) {
        if (TextUtils.isEmpty(str) || str.length() < i) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str.toCharArray();
        for (int i2 = 0; i2 < toCharArray.length; i2++) {
            if (i2 + i >= toCharArray.length) {
                toCharArray2[(i + i2) - toCharArray.length] = toCharArray[i2];
            } else {
                toCharArray2[i2 + i] = toCharArray[i2];
            }
        }
        return String.valueOf(toCharArray2);
    }

    private static String m5269a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bytes = str2.getBytes();
        byte[] bytes2 = str.getBytes(f2576c);
        int length = bytes2.length;
        for (int i = 0; i < length; i++) {
            for (byte b : bytes) {
                bytes2[i] = (byte) (b ^ bytes2[i]);
            }
        }
        return new String(bytes2);
    }
}
