package com.huawei.af;

import com.google.gson.Gson;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.b;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWCombineMigrateMgr */
class C4005o implements Runnable {
    final /* synthetic */ boolean f15279a;
    final /* synthetic */ ActivityReminder f15280b;
    final /* synthetic */ C3991a f15281c;

    C4005o(C3991a c3991a, boolean z, ActivityReminder activityReminder) {
        this.f15281c = c3991a;
        this.f15279a = z;
        this.f15280b = activityReminder;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateActivityReminder isMigrateAllData : " + this.f15279a});
        if (this.f15279a || w.a(a.a(BaseApplication.b()).c())) {
            C2538c.c("HWCombineMigrateMgr", new Object[]{"activityReminder : " + new Gson().toJson(this.f15280b)});
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.activity_reminder", r0), true);
            if (b.a(BaseApplication.b()).a("custom.activity_reminder") != null) {
                C2538c.b("HWCombineMigrateMgr", new Object[]{"migrateActivityReminder value = " + b.a(BaseApplication.b()).a("custom.activity_reminder").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
