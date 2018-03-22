package com.huawei.hwid.core.encrypt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p434c.C5147a;
import com.huawei.hwid.core.p435d.C5154a;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES128_CBC */
public class C5197a {
    private static String f18790a = "";

    public static void m25285a(Context context) {
        f18790a = C5147a.m24824a(context).m24827a("rkey", "");
    }

    @SuppressLint({"TrulyRandom"})
    public static String m25281a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(f18790a)) {
                f18790a = C5154a.m24848b();
                C5147a.m24824a(context).m24829a("rkey", f18790a);
            }
            Key secretKeySpec = new SecretKeySpec(C5197a.m25296f(context, f18790a), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
            return C5197a.m25284a(C5166b.m24918a(bArr), C5166b.m24918a(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET))));
        } catch (Throwable e) {
            C5165e.m24911d("AES128_CBC", "aes cbc encrypter data error", e);
            return "";
        } catch (Throwable e2) {
            C5165e.m24911d("AES128_CBC", "aes cbc encrypter data error", e2);
            return "";
        }
    }

    public static String m25289b(Context context, String str) {
        if (TextUtils.isEmpty(f18790a)) {
            return C5197a.m25294d(context, str);
        }
        return C5197a.m25292c(context, str);
    }

    public static String m25292c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return C5197a.m25282a(context, str, C5197a.m25296f(context, f18790a));
        } catch (Throwable e) {
            C5165e.m24911d("AES128_CBC", "Random decrypter data error", e);
            return C5197a.m25294d(context, str);
        }
    }

    private static String m25294d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return C5197a.m25282a(context, str, C5197a.m25291b(context));
        } catch (Throwable e) {
            C5165e.m24911d("AES128_CBC", "decrypter data error", e);
            return C5197a.m25295e(context, str);
        }
    }

    private static String m25295e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return C5197a.m25282a(context, str, C5197a.m25293c(context));
        } catch (Throwable e) {
            C5165e.m24911d("AES128_CBC", "OLDKEY decrypter data error again", e);
            return "";
        }
    }

    private static String m25282a(Context context, String str, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        String a = C5197a.m25283a(str);
        String b = C5197a.m25290b(str);
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            C5165e.m24906b("AES128_CBC", "ivParameter or encrypedWord is null");
            return "";
        }
        instance.init(2, secretKeySpec, new IvParameterSpec(C5166b.m24935b(a)));
        return new String(instance.doFinal(C5166b.m24935b(b)), GameManager.DEFAULT_CHARSET);
    }

    public static byte[] m25291b(Context context) {
        byte[] b = C5166b.m24935b(HwAccountConstants.m24832a());
        byte[] b2 = C5166b.m24935b(C5166b.m24936c());
        return C5197a.m25288a(C5197a.m25287a(C5197a.m25288a(C5197a.m25287a(b, -4), b2), 6), C5166b.m24935b(C5154a.m24845a()));
    }

    private static byte[] m25296f(Context context, String str) {
        byte[] b = C5166b.m24935b(HwAccountConstants.m24832a());
        byte[] b2 = C5166b.m24935b(C5166b.m24936c());
        return C5197a.m25288a(C5197a.m25287a(C5197a.m25288a(C5197a.m25287a(b, -4), b2), 6), C5166b.m24935b(C5154a.m24849b(context, str)));
    }

    private static byte[] m25293c(Context context) {
        byte[] b = C5166b.m24935b(HwAccountConstants.m24832a());
        byte[] b2 = C5166b.m24935b(C5166b.m24936c());
        return C5197a.m25286a(C5197a.m25288a(C5197a.m25288a(b, b2), C5166b.m24935b(C5154a.m24845a())));
    }

    private static byte[] m25286a(byte[] bArr) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] >> 2);
            }
        }
        return bArr;
    }

    private static byte[] m25288a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (!(bArr == null || bArr2 == null)) {
            int length = bArr.length;
            if (length == bArr2.length) {
                bArr3 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
                }
            }
        }
        return bArr3;
    }

    private static byte[] m25287a(byte[] bArr, int i) {
        if (bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (i < 0) {
                    bArr[i2] = (byte) (bArr[i2] << (-i));
                } else {
                    bArr[i2] = (byte) (bArr[i2] >> i);
                }
            }
        }
        return bArr;
    }

    private static String m25284a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.substring(0, 6));
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str2.substring(6, 10));
            stringBuffer.append(str.substring(6, 16));
            stringBuffer.append(str2.substring(10, 16));
            stringBuffer.append(str.substring(16));
            stringBuffer.append(str2.substring(16));
            return stringBuffer.toString();
        } catch (Exception e) {
            C5165e.m24910d("AES128_CBC", e.getMessage());
            return "";
        }
    }

    private static String m25283a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(6, 12));
            stringBuffer.append(str.substring(16, 26));
            stringBuffer.append(str.substring(32, 48));
            return stringBuffer.toString();
        } catch (Exception e) {
            C5165e.m24910d("AES128_CBC", e.getMessage());
            return "";
        }
    }

    private static String m25290b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str.substring(12, 16));
            stringBuffer.append(str.substring(26, 32));
            stringBuffer.append(str.substring(48));
            return stringBuffer.toString();
        } catch (Exception e) {
            C5165e.m24910d("AES128_CBC", e.getMessage());
            return "";
        }
    }
}
