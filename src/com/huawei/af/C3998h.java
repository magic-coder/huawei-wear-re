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
class C3998h implements Runnable {
    final /* synthetic */ boolean f15264a;
    final /* synthetic */ String f15265b;
    final /* synthetic */ C3991a f15266c;

    C3998h(C3991a c3991a, boolean z, String str) {
        this.f15266c = c3991a;
        this.f15264a = z;
        this.f15265b = str;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWLANAutoUpdate isMigrateAllData : " + this.f15264a});
        if (this.f15264a || w.a(a.a(BaseApplication.b()).c())) {
            Map a = this.f15266c.m19753b(this.f15266c.m19757a("custom.wear_common_setting"));
            if (a == null) {
                a = new HashMap();
            }
            a.put("wlan_auto_update", this.f15265b);
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", a.toString()), true);
            if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWLANAutoUpdate value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
