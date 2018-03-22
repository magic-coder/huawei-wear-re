package com.huawei.feedback;

import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: StorageFileUtil */
public class C0821e {
    public static void m2884a(byte[] bArr) {
        C0821e.m2883a().nextBytes(bArr);
    }

    public static SecureRandom m2883a() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            C1373c.m6141d("FeedbackDetailActivity/StorageFileUtil", "NoSuchAlgorithmException");
        }
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
