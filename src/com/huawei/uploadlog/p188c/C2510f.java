package com.huawei.uploadlog.p188c;

import com.sina.weibo.sdk.component.GameManager;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HashHmac */
public class C2510f {
    private static String f8996a = "Iee/rdTxNU91/euWyoP4TOdEpp3eUk/9YsJvw7Sr3I2LdZ8Sng3gzukP7IApyHZAErU76dVMcigcrPgq0TMRFJxjKQZqwejWs0Zoqx9QJBAOgljt7vTnOImUkFNlP9mP";

    public static String m12473a() {
        return f8996a;
    }

    public static String m12475b() {
        return "Ye6aU0";
    }

    public static byte[] m12474a(String str, String str2) throws Exception {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(GameManager.DEFAULT_CHARSET), "HmacSHA1");
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(secretKeySpec);
        return instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET));
    }
}
