package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import com.huawei.hwcloudmodel.callback.C0971c;
import com.huawei.hwcloudmodel.mgr.HwWearPushReceiver;
import com.huawei.p190v.C2538c;

/* compiled from: KidWatchPushUtil */
public class C1446a {
    private static C1446a f3326a;
    private Context f3327b;
    private C0971c f3328c = new C1447b(this);

    public static C1446a m6678a(Context context) {
        if (f3326a == null) {
            f3326a = new C1446a(context);
        }
        return f3326a;
    }

    private C1446a(Context context) {
        this.f3327b = context;
    }

    public void m6679a() {
        C2538c.m12674b("KidWatchPushUtil", "init...");
        HwWearPushReceiver.m3497a(this.f3327b, "KidWatchPushUtil", this.f3328c);
    }
}
