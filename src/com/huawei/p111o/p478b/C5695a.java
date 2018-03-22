package com.huawei.p111o.p478b;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC */
public final class C5695a {
    public static byte[] m26285a(byte[] bArr, byte[] bArr2, SecretKeySpec secretKeySpec) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        return instance.doFinal(bArr);
    }

    public static SecretKeySpec m26284a(byte[] bArr, int i) {
        int length;
        int i2;
        if (i <= 0 || i > bArr.length) {
            length = bArr.length;
        } else {
            length = i;
        }
        if (length > 16) {
            length = 16;
        }
        byte[] bArr2 = new byte[16];
        for (i2 = 0; i2 < 16; i2++) {
            bArr2[i2] = (byte) 0;
        }
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2] = bArr[i2];
        }
        return new SecretKeySpec(bArr2, 0, 16, "AES/CBC/PKCS5Padding");
    }
}
