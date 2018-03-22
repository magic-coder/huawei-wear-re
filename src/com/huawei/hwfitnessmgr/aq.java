package com.huawei.hwfitnessmgr;

import android.content.Intent;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.b;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class aq implements Runnable {
    final /* synthetic */ q f18158a;

    private aq(q qVar) {
        this.f18158a = qVar;
    }

    public void run() {
        if (w.a(a.a(q.d(this.f18158a)).c())) {
            C2538c.c("HWFitnessMgr", new Object[]{"migrateSettingtoHealth: isDataLogin = true, migrateStatus = " + q.j(this.f18158a)});
            if (!q.j(this.f18158a)) {
                boolean z;
                if (b.a(q.d(this.f18158a)).a("custom.UserPreference_HeartZone_Config") != null) {
                    C2538c.b("HWFitnessMgr", new Object[]{"health already set heart zone config"});
                    this.f18158a.setSharedPreference("kStorage_FitnessMgr_migrate_setting_to_health_status", String.valueOf(true), null);
                    z = true;
                } else {
                    z = false;
                }
                C2538c.c("HWFitnessMgr", new Object[]{"healthSettingFlag = " + z});
                if (!z) {
                    String sharedPreference = this.f18158a.getSharedPreference("kStorage_FitnessMgr_String_HRZoneConf");
                    String a = com.huawei.hwdataaccessmodel.sharedpreference.a.a(q.d(this.f18158a), String.valueOf(1006), "kStorage_FitnessMgr_String_HRZoneThreshold");
                    if (a == null || "".equals(a) || sharedPreference == null || "".equals(sharedPreference)) {
                        C2538c.c("HWFitnessMgr", new Object[]{"heart zone config is not set in 2.0"});
                    } else {
                        b.a(BaseApplication.b()).a(new HiUserPreference("custom.UserPreference_HeartZone_Config", sharedPreference + "," + a), true);
                        C2538c.c("HWFitnessMgr", new Object[]{"heart zone config migrate to health finish"});
                        q.d(this.f18158a).sendBroadcast(new Intent("com.huawei.health.heart_zone_conf_migrate_finish"));
                    }
                    this.f18158a.setSharedPreference("kStorage_FitnessMgr_migrate_setting_to_health_status", String.valueOf(true), null);
                    return;
                }
                return;
            }
            return;
        }
        C2538c.c("HWFitnessMgr", new Object[]{"HiHealth is not login"});
    }
}
