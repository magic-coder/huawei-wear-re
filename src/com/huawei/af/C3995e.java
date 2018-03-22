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
class C3995e implements Runnable {
    final /* synthetic */ boolean f15255a;
    final /* synthetic */ List f15256b;
    final /* synthetic */ C3991a f15257c;

    C3995e(C3991a c3991a, boolean z, List list) {
        this.f15257c = c3991a;
        this.f15255a = z;
        this.f15256b = list;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAvoidDisturb isMigrateAllData : " + this.f15255a});
        if (this.f15255a || w.a(a.a(BaseApplication.b()).c())) {
            C2538c.c("HWCombineMigrateMgr", new Object[]{"avoidDisturbInfo : " + new Gson().toJson(this.f15256b)});
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.avoid_disturb", r0), true);
            if (b.a(BaseApplication.b()).a("custom.avoid_disturb") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAvoidDisturb value = " + b.a(BaseApplication.b()).a("custom.avoid_disturb").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
