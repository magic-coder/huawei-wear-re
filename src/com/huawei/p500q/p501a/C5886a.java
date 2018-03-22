package com.huawei.p500q.p501a;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;

/* compiled from: AnalyticsUtils */
public class C5886a {
    private static final String f20175a = C5886a.class.getSimpleName();

    public static void m27078a(boolean z) {
        C2538c.b(f20175a, new Object[]{"setAnalyticsStatus() flag = ", Boolean.valueOf(z)});
        a.a(BaseApplication.b(), String.valueOf(1005), "analytics_status", String.valueOf(z), new com.huawei.hwdataaccessmodel.a.c());
    }

    public static boolean m27079a() {
        boolean equals = "true".equals(a.a(BaseApplication.b(), String.valueOf(1005), "analytics_status"));
        C2538c.b(f20175a, new Object[]{"setAnalyticsStatus() flag = ", Boolean.valueOf(equals)});
        return equals;
    }
}
