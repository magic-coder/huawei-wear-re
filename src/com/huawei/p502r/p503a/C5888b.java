package com.huawei.p502r.p503a;

import android.content.Context;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.p190v.C2538c;
import com.huawei.p500q.p501a.C5886a;

/* compiled from: GoogleAnalyticsUtil */
public class C5888b extends C5887a {
    private static C5888b f20179a;

    public static C5888b m27083b() {
        if (f20179a == null) {
            f20179a = new C5888b();
        }
        return f20179a;
    }

    private C5888b() {
        m27080a();
    }

    public void m27084c(Context context) {
        if (!w.b()) {
            if (!C5886a.m27079a()) {
                C2538c.e("GoogleAnalyticsUtil", new Object[]{"start() AnalyticsStatus is false"});
            } else if (context != null) {
                m27081a(context);
            } else {
                C2538c.e("GoogleAnalyticsUtil", new Object[]{"start() context is null"});
            }
        }
    }

    public void m27085d(Context context) {
        if (!w.b()) {
            if (!C5886a.m27079a()) {
                C2538c.e("GoogleAnalyticsUtil", new Object[]{"stop() AnalyticsStatus is false"});
            } else if (context != null) {
                m27082b(context);
            } else {
                C2538c.e("GoogleAnalyticsUtil", new Object[]{"stop() context is null"});
            }
        }
    }
}
