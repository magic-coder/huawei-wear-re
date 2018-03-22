package com.huawei.af;

import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWCombineMigrateMgr */
class C4002l implements Runnable {
    final /* synthetic */ IBaseResponseCallback f15274a;
    final /* synthetic */ C3991a f15275b;

    C4002l(C3991a c3991a, IBaseResponseCallback iBaseResponseCallback) {
        this.f15275b = c3991a;
        this.f15274a = iBaseResponseCallback;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        String a = this.f15275b.m19757a("custom.wear_event_alarm");
        if (a == null) {
            C2538c.e("HWCombineMigrateMgr", new Object[]{"getEventAlarm on HiHealth is null"});
            this.f15274a.onResponse(100001, arrayList);
            return;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"getEventAlarm value = " + a});
        this.f15274a.onResponse(0, (List) new Gson().fromJson(a, new C4003m(this).getType()));
    }
}
