package com.huawei.p502r.p503a;

import android.app.Activity;
import android.content.Context;
import com.google.analytics.tracking.android.ao;
import com.google.analytics.tracking.android.at;
import com.google.analytics.tracking.android.bh;
import com.google.analytics.tracking.android.p;
import com.google.analytics.tracking.android.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

/* compiled from: GoogleAnalyticsParser */
public class C5887a {
    private static ao f20176a;
    private static bh f20177b;
    private static final at f20178c = at.VERBOSE;

    protected void m27080a() {
        f20176a = ao.m18247a(BaseApplication.b());
        w.a().a(5);
        f20177b = f20176a.m18248a("UA-47260154-3");
        f20176a.m18251a(false);
        f20176a.m18254d().mo4255a(f20178c);
    }

    protected void m27081a(Context context) {
        if (context != null) {
            p.a(BaseApplication.b()).a((Activity) context);
            C2538c.c("GoogleAnalyticsParser", new Object[]{"onActivityStart()"});
            return;
        }
        C2538c.e("GoogleAnalyticsParser", new Object[]{"onActivityStart() activity is null"});
    }

    protected void m27082b(Context context) {
        if (context != null) {
            p.a(BaseApplication.b()).b((Activity) context);
            p.a(BaseApplication.b()).b();
            C2538c.c("GoogleAnalyticsParser", new Object[]{"onActivityStop()"});
            return;
        }
        C2538c.e("GoogleAnalyticsParser", new Object[]{"onActivityStop() activity is null"});
    }
}
