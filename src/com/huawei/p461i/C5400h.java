package com.huawei.p461i;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5400h implements IBaseResponseCallback {
    final /* synthetic */ C5393a f19216a;

    C5400h(C5393a c5393a) {
        this.f19216a = c5393a;
    }

    public void onResponse(int i, Object obj) {
        synchronized (C5393a.f19190o) {
            List list = (List) obj;
            if (list == null) {
                list = new ArrayList();
            }
            this.f19216a.m25982a(list, this.f19216a.f19192a, true);
            C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() setEventAlarm finish."});
        }
    }
}
