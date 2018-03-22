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
class C4006p implements Runnable {
    final /* synthetic */ boolean f15282a;
    final /* synthetic */ String f15283b;
    final /* synthetic */ C3991a f15284c;

    C4006p(C3991a c3991a, boolean z, String str) {
        this.f15284c = c3991a;
        this.f15282a = z;
        this.f15283b = str;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateBTLostRemind isMigrateAllData : " + this.f15282a});
        if (this.f15282a || w.a(a.a(BaseApplication.b()).c())) {
            Map a = this.f15284c.m19753b(this.f15284c.m19757a("custom.wear_common_setting"));
            if (a == null) {
                a = new HashMap();
            }
            a.put("bt_lost_remind", this.f15283b);
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", a.toString()), true);
            if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateBTLostRemind value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
                return;
            }
            C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateBTLostRemind value = null"});
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
