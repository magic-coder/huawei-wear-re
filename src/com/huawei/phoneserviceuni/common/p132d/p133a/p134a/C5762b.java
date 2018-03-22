package com.huawei.phoneserviceuni.common.p132d.p133a.p134a;

import com.huawei.phoneserviceuni.common.d.c;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC */
public final class C5762b {
    public static String m26456a() {
        return "7OEaK";
    }

    public static byte[] m26458a(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5762b.m26459a(bArr, i, bArr2, i2, 0);
    }

    public static byte[] m26461b(byte[] bArr, int i, byte[] bArr2, int i2) {
        return C5762b.m26459a(bArr, i, bArr2, i2, 1);
    }

    private static byte[] m26459a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 16;
        int i5 = 0;
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        int i6;
        int a = C5762b.m26455a(i, bArr.length);
        int a2 = C5762b.m26455a(i2, bArr2.length);
        if (a2 > 16) {
            a2 = 16;
        }
        byte[] bArr3 = new byte[16];
        for (i6 = 0; i6 < 16; i6++) {
            bArr3[i6] = (byte) 0;
        }
        for (i6 = 0; i6 < a2; i6++) {
            bArr3[i6] = bArr2[i6];
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr4 = new byte[16];
        if (i3 == 0) {
            a2 = 1;
            C5762b.m26457a(bArr4);
            i4 = 0;
        } else {
            a2 = 2;
            while (i5 < 16 && i5 < bArr.length) {
                bArr4[i5] = bArr[i5];
                i5++;
            }
        }
        try {
            instance.init(a2, new SecretKeySpec(bArr3, 0, 16, "AES"), new IvParameterSpec(bArr4));
        } catch (InvalidAlgorithmParameterException e) {
            c.d("LogUpload Service", "InvalidAlgorithmParameterException");
        }
        try {
            Object doFinal = instance.doFinal(bArr, i4, a - i4);
            if (i3 != 0) {
                return doFinal;
            }
            byte[] copyOf = Arrays.copyOf(bArr4, bArr4.length + doFinal.length);
            System.arraycopy(doFinal, 0, copyOf, bArr4.length, doFinal.length);
            return copyOf;
        } catch (RuntimeException e2) {
            c.d("LogUpload Service", "RuntimeException");
            return null;
        } catch (Exception e3) {
            c.d("LogUpload Service", "Exception");
            return null;
        }
    }

    private static int m26455a(int i, int i2) {
        if (i <= 0 || i > i2) {
            return i2;
        }
        return i;
    }

    private static void m26457a(byte[] bArr) {
        C5762b.m26460b().nextBytes(bArr);
    }

    private static SecureRandom m26460b() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            c.d("LogUpload Service", "NoSuchAlgorithmException");
        }
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
