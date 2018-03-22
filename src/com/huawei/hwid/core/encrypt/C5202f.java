package com.huawei.hwid.core.encrypt;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyStore;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: KeyStoreEncryptAndDecrypt */
public class C5202f {
    public static String m25310a(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, C5202f.m25311a(str));
            Object doFinal = instance.doFinal(str2.getBytes(GameManager.DEFAULT_CHARSET));
            byte[] iv = instance.getIV();
            if (iv == null || iv.length != 16) {
                C5165e.m24910d("KeyStoreEncryptAndDecrypt", "IV is invalid.");
                return "";
            }
            bArr = Arrays.copyOf(iv, iv.length + doFinal.length);
            System.arraycopy(doFinal, 0, bArr, iv.length, doFinal.length);
            return HEX.encode(bArr);
        } catch (Exception e) {
            C5165e.m24910d("KeyStoreEncryptAndDecrypt", "Encrypt exception");
        }
    }

    public static String m25312b(String str, String str2) {
        byte[] decode = HEX.decode(str2);
        if (decode.length <= 16) {
            C5165e.m24910d("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.");
            return "";
        }
        byte[] bArr = new byte[0];
        try {
            Key a = C5202f.m25311a(str);
            byte[] copyOf = Arrays.copyOf(decode, 16);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, a, new IvParameterSpec(copyOf));
            decode = instance.doFinal(decode, 16, decode.length - 16);
        } catch (Exception e) {
            C5165e.m24910d("KeyStoreEncryptAndDecrypt", "Decrypt exception");
            decode = bArr;
        }
        try {
            return new String(decode, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            C5165e.m24906b("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException");
            return "";
        }
    }

    @TargetApi(23)
    private static SecretKey m25311a(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            Key key = instance.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                return (SecretKey) key;
            }
            KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance2.init(new Builder(str, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).build());
            return instance2.generateKey();
        } catch (Exception e) {
            C5165e.m24910d("KeyStoreEncryptAndDecrypt", "Generate key exception ");
            return null;
        }
    }
}
