package com.huawei.hwid.core.encrypt;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/* compiled from: HMACSHA256 */
public class C5200d {
    public static String m25303a(String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA256");
            Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
            instance.init(secretKeySpec);
            return new String(new Hex().encode(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET))), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C5165e.m24910d("HMACSHA256", e.getMessage());
        } catch (InvalidKeyException e2) {
            C5165e.m24910d("HMACSHA256", e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            C5165e.m24910d("HMACSHA256", e3.getMessage());
        }
        return null;
    }
}
