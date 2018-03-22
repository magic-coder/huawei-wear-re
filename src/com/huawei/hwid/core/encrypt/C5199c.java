package com.huawei.hwid.core.encrypt;

import android.annotation.SuppressLint;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC_HEX */
public class C5199c {
    @SuppressLint({"TrulyRandom"})
    private static String m25299a() {
        byte[] generateSeed = new SecureRandom().generateSeed(16);
        return HEX.encode(generateSeed, generateSeed.length);
    }

    private static SecretKeySpec m25301a(byte[] bArr, int i) {
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

    public static String m25300a(byte[] bArr, byte[] bArr2) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String a = C5199c.m25299a();
        return a + ":" + HEX.encode(C5198b.m25298a(bArr, HEX.decode(a), C5199c.m25301a(bArr2, 0)));
    }

    public static byte[] m25302a(String str, String str2, byte[] bArr) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return C5198b.m25297a(str, HEX.decode(str2), C5199c.m25301a(bArr, 0));
    }
}
