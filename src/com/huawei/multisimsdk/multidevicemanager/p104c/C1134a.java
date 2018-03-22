package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.os.Build.VERSION;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashMap;

/* compiled from: AuthenHandler */
public class C1134a {
    private static final String f2398a = C1134a.class.getSimpleName();
    private static int f2399b = VERSION.SDK_INT;
    private static HashMap<String, String> f2400c = new HashMap();

    static void m5054a(String str, String str2) {
        C1183h.m5282b(f2398a, "setCmccSsoParam");
        if (f2400c == null) {
            f2400c = new HashMap();
        }
        f2400c.clear();
        f2400c.put("appid", str);
        f2400c.put(LogBuilder.KEY_APPKEY, str2);
    }

    public static HashMap<String, String> m5053a() {
        return f2400c;
    }
}
