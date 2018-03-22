package com.huawei.p086k.p462a;

import com.huawei.p086k.p462a.p463a.C5405a;
import java.security.MessageDigest;

/* compiled from: SHA256 */
public final class C5412g {
    public static byte[] m26003a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (Throwable e) {
            C5405a.m25990a("SHA256", "NoSuchAlgorithmException", e);
            return new byte[0];
        }
    }
}
