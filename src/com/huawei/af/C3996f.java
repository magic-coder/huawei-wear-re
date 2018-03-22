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
class C3996f implements Runnable {
    final /* synthetic */ boolean f15258a;
    final /* synthetic */ String f15259b;
    final /* synthetic */ C3991a f15260c;

    C3996f(C3991a c3991a, boolean z, String str) {
        this.f15260c = c3991a;
        this.f15258a = z;
        this.f15259b = str;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWeatherSwitchStatus isMigrateAllData : " + this.f15258a});
        if (this.f15258a || w.a(a.a(BaseApplication.b()).c())) {
            Map a = this.f15260c.m19753b(this.f15260c.m19757a("custom.wear_common_setting"));
            if (a == null) {
                a = new HashMap();
            }
            a.put("weather_switch_status", this.f15259b);
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", a.toString()), true);
            if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateWeatherSwitchStatus value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
