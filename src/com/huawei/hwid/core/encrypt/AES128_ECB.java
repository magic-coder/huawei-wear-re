package com.huawei.hwid.core.encrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public abstract class AES128_ECB {
    public static final String PART_CODE_KEY = "2994807A3";
    public static final String PART_CODE_KEY_SEC = "F6A10EDFAEDEB663";
    public static final String PART_KEY_CODE_KEY = "dbGd";

    public static byte[] decode(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return m25280a(bArr, i, bArr2, i2);
    }

    private static byte[] m25280a(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        int length;
        int i3;
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
        for (i3 = 0; i3 < 16; i3++) {
            bArr3[i3] = (byte) 0;
        }
        for (i3 = 0; i3 < length; i3++) {
            bArr3[i3] = bArr2[i3];
        }
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr3, 0, 16, "AES"));
        return instance.doFinal(bArr, 0, i);
    }
}
