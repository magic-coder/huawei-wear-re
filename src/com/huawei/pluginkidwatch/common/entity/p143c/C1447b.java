package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import com.huawei.hwcloudmodel.callback.C0971c;
import com.huawei.p190v.C2538c;

/* compiled from: KidWatchPushUtil */
class C1447b implements C0971c {
    final /* synthetic */ C1446a f3329a;

    C1447b(C1446a c1446a) {
        this.f3329a = c1446a;
    }

    public void mo2513a(Context context, String str) {
        C2538c.m12674b("KidWatchPushUtil", "callback --> pushTokenHandle  token:" + str);
        new C1450e().m6689a(context, str);
    }
}
