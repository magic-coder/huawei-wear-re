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
class C4009s implements Runnable {
    final /* synthetic */ boolean f15291a;
    final /* synthetic */ List f15292b;
    final /* synthetic */ C3991a f15293c;

    C4009s(C3991a c3991a, boolean z, List list) {
        this.f15293c = c3991a;
        this.f15291a = z;
        this.f15292b = list;
    }

    public void run() {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAddressBook isMigrateAllData : " + this.f15291a});
        if (this.f15291a || w.a(a.a(BaseApplication.b()).c())) {
            b.a(BaseApplication.b()).a(new HiUserPreference("custom.address_book", new Gson().toJson(this.f15292b)), true);
            if (b.a(BaseApplication.b()).a("custom.address_book") != null) {
                C2538c.c("HWCombineMigrateMgr", new Object[]{"migrateAddressBook value = " + b.a(BaseApplication.b()).a("custom.address_book").getValue()});
                return;
            }
            return;
        }
        C2538c.e("HWCombineMigrateMgr", new Object[]{"HiHealth login error"});
    }
}
