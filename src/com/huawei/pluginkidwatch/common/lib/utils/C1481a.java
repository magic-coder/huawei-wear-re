package com.huawei.pluginkidwatch.common.lib.utils;

import com.huawei.hwdatamigrate.common.a.a;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES_CBC */
public class C1481a {
    private static final byte[] f3455a = new byte[0];

    public static String m6810a(String str, byte[] bArr, byte[] bArr2) throws Exception {
        String a;
        synchronized (f3455a) {
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
            a = a.a(instance.doFinal(obj));
        }
        return a;
    }

    public static String m6812b(String str, byte[] bArr, byte[] bArr2) throws Exception {
        byte[] a = a.a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return new String(instance.doFinal(a), GameManager.DEFAULT_CHARSET).trim();
    }

    public static String m6811a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            int blockSize = instance.getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            Object obj = new byte[length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return a.a(instance.doFinal(obj));
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12674b("AES_CBC", "NoSuchAlgorithmException e" + e.getMessage());
            return "";
        } catch (NoSuchPaddingException e2) {
            C2538c.m12674b("AES_CBC", "NoSuchPaddingException e" + e2.getMessage());
            return "";
        } catch (InvalidKeyException e3) {
            C2538c.m12674b("AES_CBC", "InvalidKeyException e" + e3.getMessage());
            return "";
        } catch (InvalidAlgorithmParameterException e4) {
            C2538c.m12674b("AES_CBC", "InvalidAlgorithmParameterException e" + e4.getMessage());
            return "";
        } catch (IllegalBlockSizeException e5) {
            C2538c.m12674b("AES_CBC", "IllegalBlockSizeException e" + e5.getMessage());
            return "";
        } catch (BadPaddingException e6) {
            C2538c.m12674b("AES_CBC", "BadPaddingException e" + e6.getMessage());
            return "";
        }
    }

    public static byte[] m6813b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        C2538c.m12674b("AES_CBC", "=======secret:" + bArr2.length);
        C2538c.m12674b("AES_CBC", "=======iv:" + bArr3.length);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        C2538c.m12674b("AES_CBC", "=======encrypted:" + instance.doFinal(bArr).length);
        return instance.doFinal(bArr);
    }

    public static String m6814c(String str, byte[] bArr, byte[] bArr2) throws Exception {
        String trim;
        synchronized (f3455a) {
            byte[] a = a.a(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            trim = new String(instance.doFinal(a), GameManager.DEFAULT_CHARSET).trim();
        }
        return trim;
    }

    public static byte[] m6816d(String str, byte[] bArr, byte[] bArr2) {
        try {
            byte[] a = a.a(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12674b("NoSuchAlgorithmException e" + e.getMessage(), new Object[0]);
            return null;
        } catch (NoSuchPaddingException e2) {
            C2538c.m12674b("NoSuchPaddingException e" + e2.getMessage(), new Object[0]);
            return null;
        } catch (InvalidKeyException e3) {
            C2538c.m12674b("InvalidKeyException e" + e3.getMessage(), new Object[0]);
            return null;
        } catch (InvalidAlgorithmParameterException e4) {
            C2538c.m12674b("InvalidAlgorithmParameterException e" + e4.getMessage(), new Object[0]);
            return null;
        } catch (IllegalBlockSizeException e5) {
            C2538c.m12674b("IllegalBlockSizeException e" + e5.getMessage(), new Object[0]);
            return null;
        } catch (BadPaddingException e6) {
            C2538c.m12674b("BadPaddingException e" + e6.getMessage(), new Object[0]);
            return null;
        }
    }

    public static byte[] m6815c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }
}
