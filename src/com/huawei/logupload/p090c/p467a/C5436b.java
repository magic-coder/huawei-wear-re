package com.huawei.logupload.p090c.p467a;

import com.huawei.logupload.c.f;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC */
public final class C5436b {
    public static byte[] m26077a(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5436b.m26078a(bArr, i, bArr2, i2, 0);
    }

    public static byte[] m26079b(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5436b.m26078a(bArr, i, bArr2, i2, 1);
    }

    private static byte[] m26078a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = 16;
        if (bArr == null || bArr2 == null) {
            return null;
        }
        int length;
        int i6;
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
        for (i6 = 0; i6 < 16; i6++) {
            bArr3[i6] = (byte) 0;
        }
        for (i6 = 0; i6 < length; i6++) {
            bArr3[i6] = bArr2[i6];
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr4 = new byte[16];
        if (i3 == 0) {
            length = 1;
            C5436b.m26076a(bArr4);
            i5 = 0;
        } else {
            length = 2;
            while (i4 < 16 && i4 < bArr.length) {
                bArr4[i4] = bArr[i4];
                i4++;
            }
        }
        try {
            instance.init(length, new SecretKeySpec(bArr3, 0, 16, "AES"), new IvParameterSpec(bArr4));
        } catch (InvalidAlgorithmParameterException e) {
        }
        byte[] copyOf;
        try {
            Object doFinal = instance.doFinal(bArr, i5, i - i5);
            if (i3 != 0) {
                return doFinal;
            }
            copyOf = Arrays.copyOf(bArr4, bArr4.length + doFinal.length);
            try {
                System.arraycopy(doFinal, 0, copyOf, bArr4.length, doFinal.length);
                return copyOf;
            } catch (RuntimeException e2) {
                f.d("LogUpload Service", "RuntimeException");
                return copyOf;
            } catch (Exception e3) {
                f.d("LogUpload Service", "Exception");
                return copyOf;
            }
        } catch (RuntimeException e4) {
            copyOf = null;
            f.d("LogUpload Service", "RuntimeException");
            return copyOf;
        } catch (Exception e5) {
            copyOf = null;
            f.d("LogUpload Service", "Exception");
            return copyOf;
        }
    }

    private static void m26076a(byte[] bArr) {
        C5436b.m26075a().nextBytes(bArr);
    }

    private static SecureRandom m26075a() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            f.d("LogUpload Service", "NoSuchAlgorithmException");
        }
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
