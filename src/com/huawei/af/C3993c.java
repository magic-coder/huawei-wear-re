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
class C3993c implements Runnable {
    final /* synthetic */ boolean f15249a;
    final /* synthetic */ List f15250b;
    final /* synthetic */ C3991a f15251c;

    C3993c(C3991a c3991a, boolean z, List list) {
        this.f15251c = c3991a;
        this.f15249a = z;
        this.f15250b = list;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateSmartAlarm isMigrateAllData : " + this.f15249a});
        if (this.f15249a || w.a(a.a(BaseApplication.b()).c())) {
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_smart_alarm", new Gson().toJson(this.f15250b)), true);
            if (b.a(BaseApplication.b()).a("custom.wear_smart_alarm") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateSmartAlarm value = " + b.a(BaseApplication.b()).a("custom.wear_smart_alarm").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
