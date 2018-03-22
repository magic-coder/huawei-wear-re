package com.huawei.af;

import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.b;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HWCombineMigrateMgr */
class C4000j implements Runnable {
    final /* synthetic */ boolean f15270a;
    final /* synthetic */ String f15271b;
    final /* synthetic */ C3991a f15272c;

    C4000j(C3991a c3991a, boolean z, String str) {
        this.f15272c = c3991a;
        this.f15270a = z;
        this.f15271b = str;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateHeartRateButton isMigrateAllData : " + this.f15270a});
        if (this.f15270a || w.a(a.a(BaseApplication.b()).c())) {
            Map a = this.f15272c.m19753b(this.f15272c.m19757a("custom.wear_common_setting"));
            if (a == null) {
                a = new HashMap();
            }
            a.put("heart_rate_button", this.f15271b);
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", a.toString()), true);
            if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateHeartRateButton value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
