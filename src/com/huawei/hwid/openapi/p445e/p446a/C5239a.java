package com.huawei.hwid.openapi.p445e.p446a;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class C5239a {
    public static byte[] m25409a(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5239a.m25410a(bArr, i, bArr2, i2, 0);
    }

    private static byte[] m25410a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        int i4;
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        int length = (i2 <= 0 || i2 > bArr2.length) ? bArr2.length : i2;
        if (length > 16) {
            length = 16;
        }
        byte[] bArr3 = new byte[16];
        for (i4 = 0; i4 < 16; i4++) {
            bArr3[i4] = (byte) 0;
        }
        for (i4 = 0; i4 < length; i4++) {
            bArr3[i4] = bArr2[i4];
        }
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(i3 == 0 ? 1 : 2, new SecretKeySpec(bArr3, 0, 16, "AES"));
        return instance.doFinal(bArr, 0, i);
    }

    public static byte[] m25411b(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5239a.m25410a(bArr, i, bArr2, i2, 1);
    }
}
