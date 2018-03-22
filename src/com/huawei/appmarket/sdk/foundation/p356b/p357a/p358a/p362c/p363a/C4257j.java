package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.p363a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d.C4266b;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4262a;
import com.sina.weibo.sdk.component.GameManager;

public class C4257j {
    public static C4258k m20589a(String str, C4258k c4258k) {
        Object obj = null;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!C4262a.m20630d(charAt) && !C4262a.m20629c(charAt)) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                try {
                    c4258k.m20608c(C4266b.m20637a(str.getBytes(GameManager.DEFAULT_CHARSET)));
                    c4258k.m20606b("utf8");
                } catch (Throwable e) {
                    C4241a.m20530a("StringValue", "encode error", e);
                }
                return c4258k;
            }
        }
        c4258k.m20608c(str);
        return c4258k;
    }
}
