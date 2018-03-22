package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWFitnessMgr */
class af implements IBaseResponseCallback {
    final /* synthetic */ ActivityReminder f18146a;
    final /* synthetic */ q f18147b;

    af(q qVar, ActivityReminder activityReminder) {
        this.f18147b = qVar;
        this.f18146a = activityReminder;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list == null || list.size() == 0) {
            C2538c.e("HWFitnessMgr", new Object[]{"Start to set smartAlarm fail for smartAlarmInfoList is incorrect."});
            return;
        }
        C2538c.c("HWFitnessMgr", new Object[]{"Start to set smartAlarm."});
        C5017d.m24145a(7, this.f18146a, list);
    }
}
