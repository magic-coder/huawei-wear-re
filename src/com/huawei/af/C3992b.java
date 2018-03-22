package com.huawei.af;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p461i.C5393a;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HWCombineMigrateMgr */
class C3992b implements IBaseResponseCallback {
    final /* synthetic */ C3991a f15248a;

    C3992b(C3991a c3991a) {
        this.f15248a = c3991a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getEventAlarm() err_code = " + i + ",objData = " + obj});
        this.f15248a.f15245e = (List) obj;
        if (this.f15248a.f15245e == null || this.f15248a.f15245e.size() == 0) {
            this.f15248a.f15245e = C5393a.m25948a(BaseApplication.b()).m25984b();
            C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 getEventAlarmNoCallback mEventAlarmList = " + this.f15248a.f15245e.toString()});
            if (this.f15248a.f15245e.size() != 0) {
                this.f15248a.m19765c(this.f15248a.f15245e, true);
                return;
            }
            return;
        }
        C2538c.c("HWCombineMigrateMgr", new Object[]{"===migrateAllData2 mEventAlarmList on HiHealth is not null"});
        this.f15248a.setSharedPreference("have_migrate_event_alarm_key", String.valueOf(true), null);
    }
}
