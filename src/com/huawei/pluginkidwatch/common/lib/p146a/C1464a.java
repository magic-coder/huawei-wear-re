package com.huawei.pluginkidwatch.common.lib.p146a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_ECB */
public final class C1464a {
    public static byte[] m6767a(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C1464a.m6768a(bArr, i, bArr2, i2, 0);
    }

    public static byte[] m6769b(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C1464a.m6768a(bArr, i, bArr2, i2, 1);
    }

    private static byte[] m6768a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        int length;
        int i4;
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        if (i2 <= 0 || i2 > bArr2.length) {
            length = bArr2.length;
        } else {
            length = i2;
        }
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
        Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
        if (i3 == 0) {
            length = 1;
        } else {
            length = 2;
        }
        instance.init(length, new SecretKeySpec(bArr3, 0, 16, "AES"));
        return instance.doFinal(bArr, 0, i);
    }
}
