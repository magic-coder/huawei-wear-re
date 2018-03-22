package com.huawei.phoneserviceuni.common.p132d.p133a.p135b;

import com.huawei.phoneserviceuni.common.d.a.b.a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHAUtils */
public class C1371b {
    private static byte[] m6105b(String str) {
        byte[] bArr = null;
        try {
            bArr = MessageDigest.getInstance("SHA-256").digest(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            C1373c.m6141d("SHAUtils", "UnsupportedEncodingException");
        } catch (NoSuchAlgorithmException e2) {
            C1373c.m6141d("SHAUtils", "NoSuchAlgorithmException");
        }
        return bArr;
    }

    public static String m6104a(String str) {
        if (str == null) {
            return null;
        }
        byte[] b = C1371b.m6105b(str);
        if (b == null || b.length == 0) {
            return null;
        }
        return a.a(b);
    }
}
