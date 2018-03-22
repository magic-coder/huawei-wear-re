package com.huawei.wallet.utils.crypto;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.wallet.utils.log.LogC;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AES {
    private AES() {
    }

    private static byte[] m28506a(byte[] bArr, byte[] bArr2, String str) {
        if (bArr == null || bArr2 == null) {
            LogC.m28534d("The data or key to be encrypted is empty!", false);
            return new byte[0];
        } else if (bArr2.length != 16) {
            LogC.m28534d("Invalid AES key length (must be 16 bytes)", false);
            return new byte[0];
        } else {
            try {
                Cipher instance;
                Key secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                if (TextUtils.isEmpty(str) || "AES/CBC/PKCS5Padding".equals(str)) {
                    instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                } else {
                    instance = Cipher.getInstance(str);
                    instance.init(1, secretKeySpec);
                }
                return instance.doFinal(bArr);
            } catch (NoSuchPaddingException e) {
                LogC.m28534d("encrypt NoSuchPaddingException.", false);
                return new byte[0];
            } catch (NoSuchAlgorithmException e2) {
                LogC.m28534d("encrypt NoSuchAlgorithmException.", false);
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e3) {
                LogC.m28534d("encrypt InvalidAlgorithmParameterException.", false);
                return new byte[0];
            } catch (InvalidKeyException e4) {
                LogC.m28534d("encrypt InvalidKeyException.", false);
                return new byte[0];
            } catch (BadPaddingException e5) {
                LogC.m28534d("encrypt BadPaddingException.", false);
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                LogC.m28534d("encrypt IllegalBlockSizeException.", false);
                return new byte[0];
            }
        }
    }

    private static byte[] m28509b(byte[] bArr, byte[] bArr2, String str) {
        if (bArr == null || bArr2 == null) {
            LogC.m28524a("baselib", "AES decrypt data: " + (bArr == null) + " key: " + (bArr2 == null), true);
            return new byte[0];
        } else if (bArr2.length != 16) {
            return new byte[0];
        } else {
            try {
                Cipher instance;
                Key secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                if (TextUtils.isEmpty(str) || "AES/CBC/PKCS5Padding".equals(str)) {
                    instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
                } else {
                    instance = Cipher.getInstance(str);
                    instance.init(2, secretKeySpec);
                }
                return instance.doFinal(bArr);
            } catch (IllegalArgumentException e) {
                LogC.m28530b("decrypt IllegalArgumentException::" + e, true);
                return new byte[0];
            } catch (NoSuchPaddingException e2) {
                LogC.m28530b("decrypt NoSuchPaddingException::" + e2, true);
                return new byte[0];
            } catch (NoSuchAlgorithmException e3) {
                LogC.m28530b("decrypt NoSuchAlgorithmException::" + e3, true);
                return new byte[0];
            } catch (InvalidKeyException e4) {
                LogC.m28530b("decrypt InvalidKeyException::" + e4, true);
                return new byte[0];
            } catch (BadPaddingException e5) {
                LogC.m28530b("decrypt BadPaddingException::" + e5, true);
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                LogC.m28530b("decrypt IllegalBlockSizeException::" + e6, true);
                return new byte[0];
            } catch (InvalidAlgorithmParameterException e7) {
                LogC.m28530b("decrypt InvalidAlgorithmParameterException::" + e7, true);
                return new byte[0];
            }
        }
    }

    public static String m28502a(String str, String str2) {
        return m28503a(str, str2, "AES/CBC/PKCS5Padding");
    }

    public static String m28503a(String str, String str2, String str3) {
        try {
            return Base64.encodeToString(m28506a(str.getBytes(GameManager.DEFAULT_CHARSET), str2.getBytes(GameManager.DEFAULT_CHARSET), str3), 2);
        } catch (UnsupportedEncodingException e) {
            LogC.m28534d("encrypt UnsupportedEncodingException.", false);
            return null;
        }
    }

    public static String m28507b(String str, String str2) {
        return m28508b(str, str2, "AES/CBC/PKCS5Padding");
    }

    public static String m28508b(String str, String str2, String str3) {
        try {
            byte[] b = m28509b(Base64.decode(str, 2), str2.getBytes(GameManager.DEFAULT_CHARSET), str3);
            if (b != null) {
                return new String(b, GameManager.DEFAULT_CHARSET);
            }
            LogC.m28533d("baselib", "decryptFromBase64 decrypt data is null", false);
            return null;
        } catch (UnsupportedEncodingException e) {
            LogC.m28534d("decryptFromBase64 UnsupportedEncodingException", false);
            return null;
        }
    }

    public static String m28504a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append('0');
            }
            stringBuffer.append(Long.toString((long) (bArr[i] & 255), 16));
        }
        return stringBuffer.toString();
    }

    public static byte[] m28505a(String str) {
        int i = 0;
        if (str.length() < 1) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        while (i < str.length() / 2) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
            i++;
        }
        return bArr;
    }
}
