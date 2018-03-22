package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class C2984b {
    private static byte[] f10106a = new byte[]{TagName.THIRD_PAY_NUMBER, TagName.NOTICE_BODY, TagName.QUERY_DATA_SORT_TYPE, TagName.ELECTRONIC_APP_TYPE, TagName.SYSTEM_VERSION, (byte) -85, (byte) -51, (byte) -17, (byte) -87, (byte) -73, TagName.PROMOTION_MESSAGE_DATA, (byte) -42, (byte) -29, (byte) -15, TagName.TRADE_STATUS, (byte) -2};

    public static byte[] m13418a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(f10106a));
        return instance.doFinal(bArr);
    }

    public static byte[] m13419b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(f10106a));
        return instance.doFinal(bArr);
    }
}
