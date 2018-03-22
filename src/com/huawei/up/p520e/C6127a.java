package com.huawei.up.p520e;

import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HMACSHA256 */
public class C6127a {
    public static String m27905a(String str, String str2) {
        String str3 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA256");
            Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
            instance.init(secretKeySpec);
            str3 = C0973a.a(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET)));
        } catch (UnsupportedEncodingException e) {
            C2538c.e("HMACSHA256", new Object[]{"exception e=" + e.getMessage()});
        } catch (InvalidKeyException e2) {
            C2538c.e("HMACSHA256", new Object[]{"exception e=" + e2.getMessage()});
        } catch (NoSuchAlgorithmException e3) {
            C2538c.e("HMACSHA256", new Object[]{"exception e=" + e3.getMessage()});
        }
        return str3;
    }
}
