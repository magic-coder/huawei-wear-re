package com.huawei.pluginkidwatch.p137a;

import com.huawei.android.pushagent.PushReceiver;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: KidWatchUtil */
class C1382e implements Runnable {
    final /* synthetic */ C1377a f2975a;

    C1382e(C1377a c1377a) {
        this.f2975a = c1377a;
    }

    public void run() {
        String b = C1497q.m6945b(this.f2975a.f2969a, "push_access_token", null);
        C2538c.m12674b("KidWatchUtil", "==========deviceToken:" + b);
        C2538c.m12674b("KidWatchUtil", "===============deviceToken is empty");
        C2538c.m12674b("KidWatchUtil", "=============getToken");
        PushReceiver.getToken(this.f2975a.f2969a);
    }
}
