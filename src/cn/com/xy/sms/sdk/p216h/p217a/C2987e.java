package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.xy.sms.p204a.C2899a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class C2987e {
    private static byte[] f10117a = new byte[]{TagName.THIRD_PAY_NUMBER, TagName.NOTICE_BODY, TagName.QUERY_DATA_SORT_TYPE, TagName.ELECTRONIC_APP_TYPE, TagName.SYSTEM_VERSION, (byte) -85, (byte) -51, (byte) -17};

    public static byte[] m13427a(String str, String str2) {
        try {
            Cipher instance;
            SecureRandom secureRandom = new SecureRandom();
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes()));
            if (C2899a.m13069a()) {
                instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(1, generateSecret, new IvParameterSpec(f10117a));
            } else {
                instance = Cipher.getInstance("DES");
                instance.init(1, generateSecret, secureRandom);
            }
            return instance.doFinal(str.getBytes());
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "decryptDES: " + th.getMessage(), th);
            return null;
        }
    }

    public static byte[] m13428a(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr == null) {
            return null;
        }
        try {
            Cipher instance;
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            if (C2899a.m13069a()) {
                instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(2, generateSecret, new IvParameterSpec(f10117a));
            } else {
                SecureRandom secureRandom = new SecureRandom();
                instance = Cipher.getInstance("DES");
                instance.init(2, generateSecret, secureRandom);
            }
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "decryptDES: " + th.getMessage(), th);
            return null;
        }
    }
}
