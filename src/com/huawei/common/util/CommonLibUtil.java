package com.huawei.common.util;

import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p111o.p478b.C5697c;
import com.huawei.p111o.p478b.C5699d;
import com.huawei.p190v.C2538c;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CommonLibUtil {
    public static final int IV_LENGTH = 32;
    public static final String TAG = "CommonLibUtil";
    private static byte[] mSecretKey = null;
    public static final int outputKeyLength = 256;

    public static String encrypt(String str) {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return C0973a.a(bArr) + C5697c.m26287a(str, getAESKey(), bArr);
        } catch (Exception e) {
            C2538c.e("encrypt--Exception:", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String decrypt(String str) {
        try {
            if (str.length() < 32) {
                return null;
            }
            return C5697c.m26289c(str.substring(32), getAESKey(), C0973a.g(str.substring(0, 32)));
        } catch (NoSuchAlgorithmException e) {
            C2538c.b(TAG, new Object[]{"========NoSuchAlgorithmException"});
            C2538c.e(TAG, new Object[]{e.getMessage()});
            return null;
        } catch (NoSuchPaddingException e2) {
            C2538c.e(TAG, new Object[]{"========NoSuchPaddingException"});
            C2538c.e(TAG, new Object[]{e2.getMessage()});
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.e(TAG, new Object[]{"========InvalidAlgorithmParameterException"});
            C2538c.e(TAG, new Object[]{e3.getMessage()});
            return null;
        } catch (InvalidKeyException e4) {
            C2538c.e(TAG, new Object[]{"========InvalidKeyException"});
            C2538c.e(TAG, new Object[]{e4.getMessage()});
            return null;
        } catch (BadPaddingException e5) {
            C2538c.e(TAG, new Object[]{"========BadPaddingException"});
            C2538c.e(TAG, new Object[]{e5.getMessage()});
            return decryptNopadding(str);
        } catch (IllegalBlockSizeException e6) {
            C2538c.e(TAG, new Object[]{"========IllegalBlockSizeException"});
            C2538c.e(TAG, new Object[]{e6.getMessage()});
            return null;
        } catch (UnsupportedEncodingException e7) {
            C2538c.e(TAG, new Object[]{"========UnsupportedEncodingException"});
            C2538c.e(TAG, new Object[]{e7.getMessage()});
            return null;
        } catch (Exception e8) {
            C2538c.e(TAG, new Object[]{"========Exception"});
            C2538c.e(TAG, new Object[]{e8.getMessage()});
            return null;
        }
    }

    public static String decryptNopadding(String str) {
        String str2 = null;
        try {
            if (str.length() >= 32) {
                str2 = C5697c.m26288b(str.substring(32), getAESKey(), C0973a.g(str.substring(0, 32)));
            }
        } catch (NoSuchAlgorithmException e) {
            C2538c.b(TAG, new Object[]{"========NoSuchAlgorithmException2"});
            C2538c.e(TAG, new Object[]{e.getMessage()});
        } catch (NoSuchPaddingException e2) {
            C2538c.b(TAG, new Object[]{"========NoSuchPaddingException3"});
            C2538c.e(TAG, new Object[]{e2.getMessage()});
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.e(TAG, new Object[]{"========InvalidAlgorithmParameterException4"});
            C2538c.e(TAG, new Object[]{e3.getMessage()});
        } catch (InvalidKeyException e4) {
            C2538c.e(TAG, new Object[]{"========InvalidKeyException5"});
            C2538c.e(TAG, new Object[]{e4.getMessage()});
        } catch (BadPaddingException e5) {
            C2538c.e(TAG, new Object[]{"========BadPaddingException6"});
            C2538c.e(TAG, new Object[]{e5.getMessage()});
        } catch (IllegalBlockSizeException e6) {
            C2538c.e(TAG, new Object[]{"========IllegalBlockSizeException7"});
            C2538c.e(TAG, new Object[]{e6.getMessage()});
        } catch (UnsupportedEncodingException e7) {
            C2538c.e(TAG, new Object[]{"========UnsupportedEncodingException8"});
            C2538c.e(TAG, new Object[]{e7.getMessage()});
        } catch (Exception e8) {
            C2538c.e(TAG, new Object[]{"========Exception"});
            C2538c.e(TAG, new Object[]{e8.getMessage()});
        }
        return str2;
    }

    private static byte[] getAESKey() {
        return mSecretKey;
    }

    public static void setAESKey(String str) {
        C2538c.b(TAG, new Object[]{"==aes==str:" + str});
        mSecretKey = C5699d.m26303a(str);
    }
}
