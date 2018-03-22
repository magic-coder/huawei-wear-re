package com.huawei.p111o.p478b;

import com.sina.weibo.sdk.component.GameManager;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES_CBC */
public class C5697c {
    private static byte[] f19427a = new byte[1];

    public static String m26287a(String str, byte[] bArr, byte[] bArr2) throws Exception {
        String b;
        synchronized (f19427a) {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            int blockSize = instance.getBlockSize();
            Object bytes = str.trim().getBytes(GameManager.DEFAULT_CHARSET);
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            Object obj = new byte[length];
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            instance.init(1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            b = C5699d.m26308b(instance.doFinal(obj));
        }
        return b;
    }

    public static String m26288b(String str, byte[] bArr, byte[] bArr2) throws Exception {
        byte[] a = C5699d.m26303a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return new String(instance.doFinal(a), GameManager.DEFAULT_CHARSET).trim();
    }

    public static String m26289c(String str, byte[] bArr, byte[] bArr2) throws Exception {
        String trim;
        synchronized (f19427a) {
            byte[] a = C5699d.m26303a(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            trim = new String(instance.doFinal(a), GameManager.DEFAULT_CHARSET).trim();
        }
        return trim;
    }
}
