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
class C3999i implements Runnable {
    final /* synthetic */ boolean f15267a;
    final /* synthetic */ String f15268b;
    final /* synthetic */ C3991a f15269c;

    C3999i(C3991a c3991a, boolean z, String str) {
        this.f15269c = c3991a;
        this.f15267a = z;
        this.f15268b = str;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateLeftOrRightHandWearStatus isMigrateAllData : " + this.f15267a});
        if (this.f15267a || w.a(a.a(BaseApplication.b()).c())) {
            Map a = this.f15269c.m19753b(this.f15269c.m19757a("custom.wear_common_setting"));
            if (a == null) {
                a = new HashMap();
            }
            a.put("left_or_right_hand_wear_status", this.f15268b);
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.wear_common_setting", a.toString()), true);
            if (b.a(BaseApplication.b()).a("custom.wear_common_setting") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateLeftOrRightHandWearStatus value = " + b.a(BaseApplication.b()).a("custom.wear_common_setting").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
