package com.huawei.hwbtsdk.p399a;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryptUtil */
public class C4618u {
    private static final Object f16882a = new Object();

    public static byte[] m22032a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = null;
        synchronized (f16882a) {
            C4596v c4597a;
            switch (i) {
                case 1:
                    c4597a = new C4597a(1);
                    break;
                default:
                    c4597a = null;
                    break;
            }
            if (c4597a == null) {
            } else {
                bArr4 = c4597a.mo4537a(bArr, bArr2, bArr3);
            }
        }
        return bArr4;
    }

    public static byte[] m22035b(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = null;
        synchronized (f16882a) {
            C4596v c4597a;
            switch (i) {
                case 1:
                    c4597a = new C4597a(1);
                    break;
                default:
                    c4597a = null;
                    break;
            }
            if (c4597a == null) {
            } else {
                bArr4 = c4597a.mo4538b(bArr, bArr2, bArr3);
            }
        }
        return bArr4;
    }

    public static byte[] m22033a(byte[] bArr) {
        Object obj = new byte[16];
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            System.arraycopy(instance.digest(), 0, obj, 0, 16);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] m22034a(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        Key secretKeySpec = new SecretKeySpec(bArr, "HMACSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public static byte[] m22031a(int i) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(i * 8, secureRandom);
        return instance.generateKey().getEncoded();
    }
}
