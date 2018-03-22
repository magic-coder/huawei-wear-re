package com.huawei.ui.device.activity.eventalarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2075m implements IBaseResponseCallback {
    final /* synthetic */ C2074l f7274a;

    C2075m(C2074l c2074l) {
        this.f7274a = c2074l;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.m12677c("EventAlarmClockActivity", "deleteClock() success");
            this.f7274a.f7273a.m10745e();
            this.f7274a.f7273a.finish();
            return;
        }
        C2538c.m12677c("EventAlarmClockActivity", "deleteClock() failed, err_code = " + i);
    }
}
