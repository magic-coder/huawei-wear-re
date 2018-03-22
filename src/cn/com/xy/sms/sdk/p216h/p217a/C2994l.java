package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.xy.sms.sdk.p215g.C2982a;
import com.sina.weibo.sdk.component.GameManager;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public final class C2994l {
    public static String m13472a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(GameManager.DEFAULT_CHARSET));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "sha256Encode: " + th.getMessage(), th);
            return "";
        }
    }

    public static String m13473a(String str, String str2) {
        return new String(C2994l.m13474a(str.getBytes(), str2)).replaceAll("\r\n", "").replaceAll("\n", "");
    }

    private static byte[] m13474a(byte[] bArr, String str) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C2985c.m13422b(bArr)));
            Signature instance = Signature.getInstance("SHA256WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes());
            return C2985c.m13421a(instance.sign());
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "sign: " + th.getMessage(), th);
            return null;
        }
    }
}
