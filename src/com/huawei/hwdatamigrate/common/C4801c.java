package com.huawei.hwdatamigrate.common;

import com.huawei.common.util.CommonLibUtil;
import com.huawei.hwdatamigrate.common.p408a.C4796a;
import com.huawei.p111o.p478b.C5697c;
import com.huawei.p190v.C2538c;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: CommonLibUtil */
public class C4801c {
    private static byte[] f17748a;

    public static String m22995a(String str) {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return C4801c.m22996a(bArr) + C5697c.m26287a(str, C4801c.m22998b(), bArr);
        } catch (Exception e) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"encrypt--Exception:" + e.getMessage()});
            return null;
        }
    }

    public static String m22997b(String str) {
        try {
            if (str.length() < 32) {
                return null;
            }
            return C5697c.m26289c(str.substring(32), C4801c.m22998b(), C4801c.m23001e(str.substring(0, 32)));
        } catch (NoSuchAlgorithmException e) {
            C2538c.b(CommonLibUtil.TAG, new Object[]{"=======NoSuchAlgorithm Exception"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e.getMessage()});
            return null;
        } catch (NoSuchPaddingException e2) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======NoSuchPadding Exception"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e2.getMessage()});
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======InvalidAlgorithm ParameterException"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e3.getMessage()});
            return null;
        } catch (InvalidKeyException e4) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======InvalidKeyException ."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e4.getMessage()});
            return null;
        } catch (BadPaddingException e5) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======BadPaddingException."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e5.getMessage()});
            return C4801c.m22999c(str);
        } catch (IllegalBlockSizeException e6) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======IllegalBlockSizeException."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e6.getMessage()});
            return null;
        } catch (UnsupportedEncodingException e7) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======UnsupportedEncodingException."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e7.getMessage()});
            return null;
        } catch (Exception e8) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"=======Exception."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e8.getMessage()});
            return null;
        }
    }

    public static String m22999c(String str) {
        String str2 = null;
        try {
            if (str.length() >= 32) {
                str2 = C5697c.m26288b(str.substring(32), C4801c.m22998b(), C4801c.m23001e(str.substring(0, 32)));
            }
        } catch (NoSuchAlgorithmException e) {
            C2538c.b(CommonLibUtil.TAG, new Object[]{"========NoSuchAlgorithmException2."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e.getMessage()});
        } catch (NoSuchPaddingException e2) {
            C2538c.b(CommonLibUtil.TAG, new Object[]{"========NoSuchPaddingException3."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e2.getMessage()});
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========InvalidAlgorithmParameterException4."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e3.getMessage()});
        } catch (InvalidKeyException e4) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========InvalidKeyException5."});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e4.getMessage()});
        } catch (BadPaddingException e5) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========BadPaddingException6"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e5.getMessage()});
        } catch (IllegalBlockSizeException e6) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========IllegalBlockSizeException7"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e6.getMessage()});
        } catch (UnsupportedEncodingException e7) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========UnsupportedEncodingException8"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e7.getMessage()});
        } catch (Exception e8) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"========Exception"});
            C2538c.e(CommonLibUtil.TAG, new Object[]{e8.getMessage()});
        }
        return str2;
    }

    public static void m23000d(String str) {
        f17748a = C4796a.m22965a(str);
    }

    public static String m22994a() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256, secureRandom);
            return C4796a.m22969b(instance.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            C2538c.e(CommonLibUtil.TAG, new Object[]{"generateKey - >NoSuchAlgorithmException:" + e.getMessage()});
            return "";
        }
    }

    private static byte[] m22998b() {
        return f17748a;
    }

    private static byte[] m23001e(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    private static String m22996a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
