package com.huawei.multisimsdk.multidevicemanager.p105e.p107a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESCBCUtils */
public class C1173a {
    public static String m5243a(Context context, String str) {
        return C1173a.m5244a(str, C1174b.m5252a(context));
    }

    public static String m5249b(Context context, String str) {
        return C1173a.m5250b(str, C1174b.m5252a(context));
    }

    public static byte[] m5247a() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            return instance.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            Log.d("AESCBCUtils", " AESSecureKey is exception");
            return new byte[0];
        }
    }

    public static String m5244a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                bytes = new byte[0];
            }
        } else {
            bytes = new byte[0];
        }
        if (bytes.length == 0) {
            return null;
        }
        return C1173a.m5245a(str, bytes);
    }

    public static String m5245a(String str, byte[] bArr) {
        String str2 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr2 = new byte[16];
            new SecureRandom().nextBytes(bArr2);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            str2 = C1173a.m5246a(bArr2) + C1173a.m5246a(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET)));
        } catch (RuntimeException e) {
            Log.d("AESCBCUtils", " aesEncrypt is RuntimeException ");
        } catch (Exception e2) {
            Log.d("AESCBCUtils", " aesEncrypt is exception");
        }
        return str2;
    }

    public static String m5250b(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                bytes = new byte[0];
            }
        } else {
            bytes = new byte[0];
        }
        if (bytes.length == 0) {
            return null;
        }
        return C1173a.m5251b(str, bytes);
    }

    public static String m5251b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(C1173a.m5248a(str.substring(0, 32))));
            return new String(instance.doFinal(C1173a.m5248a(str.substring(32))), GameManager.DEFAULT_CHARSET);
        } catch (InvalidKeyException e) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (NoSuchAlgorithmException e2) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (NoSuchPaddingException e3) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (InvalidAlgorithmParameterException e4) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (IllegalBlockSizeException e5) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (BadPaddingException e6) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        } catch (UnsupportedEncodingException e7) {
            Log.d("AESCBCUtils", " aesDncrypt is exception");
            return null;
        }
    }

    public static String m5246a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            Object toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            if (!TextUtils.isEmpty(toHexString)) {
                stringBuffer.append(toHexString.toUpperCase(Locale.getDefault()));
            }
        }
        return stringBuffer.toString();
    }

    private static byte[] m5248a(String str) {
        int i = 0;
        if (str.length() < 1) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        while (i < length) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
            i++;
        }
        return bArr;
    }
}
