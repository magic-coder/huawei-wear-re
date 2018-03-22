package com.huawei.af;

import com.google.gson.Gson;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.b;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWCombineMigrateMgr */
class C3994d implements Runnable {
    final /* synthetic */ boolean f15252a;
    final /* synthetic */ List f15253b;
    final /* synthetic */ C3991a f15254c;

    C3994d(C3991a c3991a, boolean z, List list) {
        this.f15254c = c3991a;
        this.f15252a = z;
        this.f15253b = list;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateEventAlarm isMigrateAllData : " + this.f15252a});
        if (this.f15252a || w.a(a.a(BaseApplication.b()).c())) {
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_event_alarm", new Gson().toJson(this.f15253b)), true);
            if (b.a(BaseApplication.b()).a("custom.wear_event_alarm") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateEventAlarm value = " + b.a(BaseApplication.b()).a("custom.wear_event_alarm").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
