package com.huawei.android.pushagent.p018c.p019a.p026a;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class C4101g {
    private static PublicKey m20118a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static byte[] m20119a(byte[] bArr, String str) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        instance.init(1, C4101g.m20118a(str));
        return instance.doFinal(bArr);
    }
}
