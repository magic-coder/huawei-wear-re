package com.huawei.p461i;

import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5401i implements IBaseResponseCallback {
    final /* synthetic */ C5393a f19217a;

    C5401i(C5393a c5393a) {
        this.f19217a = c5393a;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list == null) {
            C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() smartAlarmInfoList is null"});
            list = new ArrayList();
        }
        C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() smartAlarmInfoList.size() = " + list.size()});
        if (list.size() == 0) {
            list.add(new SmartAlarmInfo());
        }
        this.f19217a.m25987b(list, this.f19217a.f19192a, true);
        C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() setSmartAlarm finish."});
    }
}
