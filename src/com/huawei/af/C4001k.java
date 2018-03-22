package com.huawei.af;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;

/* compiled from: HWCombineMigrateMgr */
class C4001k implements IBaseResponseCallback {
    final /* synthetic */ C3991a f15273a;

    C4001k(C3991a c3991a) {
        this.f15273a = c3991a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getWearCommonSetting() err_code = " + i + ",objData = " + obj});
        if (i == 0) {
            this.f15273a.f15243c = (Map) obj;
            if (this.f15273a.f15243c == null || 8 != this.f15273a.f15243c.size()) {
                this.f15273a.m19750a();
                return;
            }
            C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 mCommonSettingList on HiHealth is not null"});
            this.f15273a.setSharedPreference("have_migrate_all_common_settings_key", String.valueOf(true), null);
        }
    }
}
