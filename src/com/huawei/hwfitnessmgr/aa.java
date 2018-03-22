package com.huawei.hwfitnessmgr;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWFitnessMgr */
class aa implements IBaseResponseCallback {
    final /* synthetic */ ActivityReminder f18139a;
    final /* synthetic */ q f18140b;

    aa(q qVar, ActivityReminder activityReminder) {
        this.f18140b = qVar;
        this.f18139a = activityReminder;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list == null || list.size() == 0) {
            C2538c.e("HWFitnessMgr", new Object[]{"Set UserInfo2 fail for smartAlarmInfoList is incorrect."});
            return;
        }
        C2538c.c("HWFitnessMgr", new Object[]{"Start to set UserInfo2."});
        C5017d.m24145a(2, this.f18139a, list);
    }
}
