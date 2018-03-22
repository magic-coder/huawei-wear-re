package com.huawei.android.pushagent.plugin.tools.p334a;

import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class C4140a {
    private SecureRandom f15545a = new SecureRandom();
    private Key f15546b;

    private C4140a() {
    }

    public static C4140a m20218a(byte[] bArr) throws InvalidKeyException, NoSuchAlgorithmException {
        C4140a c4140a = new C4140a();
        c4140a.m20221b(bArr);
        return c4140a;
    }

    private byte[] m20219a(byte[] bArr, Key key, int i) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        int i2 = 16;
        if (bArr == null || key == null) {
            return new byte[0];
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr2 = new byte[16];
        if (i == 1) {
            m20222c(bArr2);
            i2 = 0;
        } else if (i != 2) {
            return new byte[0];
        } else {
            if (bArr.length <= 16) {
                return new byte[0];
            }
            for (int i3 = 0; i3 < 16; i3++) {
                bArr2[i3] = bArr[i3];
            }
        }
        instance.init(i, key, new IvParameterSpec(bArr2));
        Object doFinal = instance.doFinal(bArr, i2, bArr.length - i2);
        if (i != 1) {
            return doFinal;
        }
        Object copyOf = Arrays.copyOf(bArr2, bArr2.length + doFinal.length);
        System.arraycopy(doFinal, 0, copyOf, bArr2.length, doFinal.length);
        return copyOf;
    }

    public String m20220a(String str) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return C4141b.m20227b(m20219a(str.getBytes(GameManager.DEFAULT_CHARSET), this.f15546b, 1));
    }

    public void m20221b(byte[] bArr) {
        if (bArr.length == 16) {
            this.f15546b = new SecretKeySpec(bArr, "AES");
        }
    }

    public void m20222c(byte[] bArr) {
        this.f15545a.nextBytes(bArr);
    }
}
