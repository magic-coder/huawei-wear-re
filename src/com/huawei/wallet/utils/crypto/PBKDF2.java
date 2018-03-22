package com.huawei.wallet.utils.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2 {

    public interface PBKDF2Sai1 {
    }

    public interface PBKDF2Sai2 {
    }

    public interface PBKDF2Sai3 {
    }

    public interface PBKDF2Sai4 {
    }

    public static boolean m28515a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return m28517a(str.toCharArray(), str2);
    }

    public static boolean m28517a(char[] cArr, String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        byte[] a = m28518a(split[1]);
        byte[] a2 = m28518a(split[2]);
        return m28516a(a2, m28519a(cArr, a, parseInt, a2.length));
    }

    private static boolean m28516a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length ^ bArr2.length;
        int i = 0;
        while (i < bArr.length && i < bArr2.length) {
            length |= bArr[i] ^ bArr2[i];
            i++;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }

    private static byte[] m28519a(char[] cArr, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, i, i2 * 8)).getEncoded();
    }

    private static byte[] m28518a(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
