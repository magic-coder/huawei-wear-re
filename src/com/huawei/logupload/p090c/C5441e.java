package com.huawei.logupload.p090c;

import com.sina.weibo.sdk.component.GameManager;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HashHmac */
public class C5441e {
    private static String f19274a = "G5qeP1iA8kCp6G3n5iEMUi71phti4PmJYWqxI/Z7xZHHhEQvWJBlLiJD+uhofu7KHojIrz5LdhRffJJ1TwzIGwQKBgQD3KOiKVVoAQHMoqwpBoXG2JfRf1l6vvUY2ylnI261GkEKg2TacEnETTgSHPaBBqqZiP4p7mbVzvVuTsI5xDv/14gMQGLtdk2S7imWinUaGIfy9ybSj9D1ZHEIoA/lJaSsOZ5UXfH8wbw7oqEVat3GFNlDwsqKlziLcZULldr/G+QKBgQCdngbPtAfjp4HxT0I4Fju/jykD+3nBQMn7XeHrJB40+1kYtx+yR06W+eD";

    public static String m26092a() {
        return f19274a;
    }

    public static String m26094b() {
        return "Ye6aU0";
    }

    public static byte[] m26093a(String str, String str2) {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA1");
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(secretKeySpec);
        return instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET));
    }
}
