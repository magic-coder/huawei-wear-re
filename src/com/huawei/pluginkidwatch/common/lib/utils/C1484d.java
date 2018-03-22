package com.huawei.pluginkidwatch.common.lib.utils;

import com.huawei.hwdatamigrate.common.a.a;
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
public class C1484d {
    private static byte[] f3457a;

    public static String m6838a(String str) {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return C1484d.m6839a(bArr) + C1481a.m6810a(str, C1484d.m6841b(), bArr);
        } catch (Exception e) {
            C2538c.m12680e("encrypt--Exception:", e.getMessage());
            return null;
        }
    }

    public static String m6840b(String str) {
        try {
            if (str.length() < 32) {
                return null;
            }
            return C1481a.m6814c(str.substring(32), C1484d.m6841b(), C1484d.m6844e(str.substring(0, 32)));
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========NoSuchAlgorithmException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e.getMessage());
            return null;
        } catch (NoSuchPaddingException e2) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========NoSuchPaddingException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e2.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========InvalidAlgorithmParameterException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e3.getMessage());
            return null;
        } catch (InvalidKeyException e4) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========InvalidKeyException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e4.getMessage());
            return null;
        } catch (BadPaddingException e5) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========BadPaddingException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e5.getMessage());
            return C1484d.m6842c(str);
        } catch (IllegalBlockSizeException e6) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========IllegalBlockSizeException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e6.getMessage());
            return null;
        } catch (UnsupportedEncodingException e7) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========UnsupportedEncodingException");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e7.getMessage());
            return null;
        } catch (Exception e8) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========Exception");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e8.getMessage());
            return null;
        }
    }

    public static String m6842c(String str) {
        String str2 = null;
        try {
            if (str.length() >= 32) {
                str2 = C1481a.m6812b(str.substring(32), C1484d.m6841b(), C1484d.m6844e(str.substring(0, 32)));
            }
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========NoSuchAlgorithmException2");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e.getMessage());
        } catch (NoSuchPaddingException e2) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========NoSuchPaddingException3");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========InvalidAlgorithmParameterException4");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e3.getMessage());
        } catch (InvalidKeyException e4) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========InvalidKeyException5");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e4.getMessage());
        } catch (BadPaddingException e5) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========BadPaddingException6");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e5.getMessage());
        } catch (IllegalBlockSizeException e6) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========IllegalBlockSizeException7");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e6.getMessage());
        } catch (UnsupportedEncodingException e7) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========UnsupportedEncodingException8");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e7.getMessage());
        } catch (Exception e8) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "========Exception");
            C2538c.m12680e("KIDWATCH_CommonLibUtil", e8.getMessage());
        }
        return str2;
    }

    private static byte[] m6841b() {
        return f3457a;
    }

    public static void m6843d(String str) {
        C2538c.m12674b("KIDWATCH_CommonLibUtil", "==aes== str: = " + str);
        f3457a = a.a(str);
    }

    public static String m6836a() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256, secureRandom);
            return a.b(instance.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "generateKey-->NoSuchAlgorithmException:" + e.getMessage());
            return "";
        }
    }

    public static String m6837a(int i) {
        String b;
        NoSuchAlgorithmException e;
        String str = "";
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256, secureRandom);
            C2538c.m12680e("KIDWATCH_CommonLibUtil", "generateKey-->key.length:" + instance.generateKey().getEncoded().length + "");
            b = a.b(r0);
            if (b != null) {
                try {
                    if (b.length() > i) {
                        b = b.substring(0, i);
                    }
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    C2538c.m12680e("generateKey---Exception:", e.getMessage());
                    C2538c.m12674b("", "=======generateKey---res:" + b);
                    return b;
                }
            }
        } catch (NoSuchAlgorithmException e3) {
            NoSuchAlgorithmException noSuchAlgorithmException = e3;
            b = str;
            e = noSuchAlgorithmException;
            C2538c.m12680e("generateKey---Exception:", e.getMessage());
            C2538c.m12674b("", "=======generateKey---res:" + b);
            return b;
        }
        C2538c.m12674b("", "=======generateKey---res:" + b);
        return b;
    }

    private static String m6839a(byte[] bArr) {
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

    private static byte[] m6844e(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }
}
