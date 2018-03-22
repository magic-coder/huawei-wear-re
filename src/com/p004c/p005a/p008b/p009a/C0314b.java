package com.p004c.p005a.p008b.p009a;

import com.sina.weibo.sdk.component.GameManager;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class C0314b {
    public static byte[] m148a(String str, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = instance.getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            Object obj = new byte[length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            instance.init(1, new SecretKeySpec(str.getBytes(GameManager.DEFAULT_CHARSET), "AES"), new IvParameterSpec(str.getBytes(GameManager.DEFAULT_CHARSET)));
            return instance.doFinal(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
