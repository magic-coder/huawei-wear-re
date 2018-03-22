package org.p198a.p199a.p200a.p201a;

import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;

/* compiled from: StringUtils */
public class C2766c {
    public static byte[] m12878a(String str) {
        return C2766c.m12879a(str, GameManager.DEFAULT_CHARSET);
    }

    public static byte[] m12879a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw C2766c.m12875a(str2, e);
        }
    }

    private static IllegalStateException m12875a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(new StringBuilder(String.valueOf(str)).append(": ").append(unsupportedEncodingException).toString());
    }

    public static String m12877a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw C2766c.m12875a(str, e);
        }
    }

    public static String m12876a(byte[] bArr) {
        return C2766c.m12877a(bArr, GameManager.DEFAULT_CHARSET);
    }
}
