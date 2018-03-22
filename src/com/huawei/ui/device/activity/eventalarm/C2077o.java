package com.huawei.ui.device.activity.eventalarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2077o implements IBaseResponseCallback {
    final /* synthetic */ EventAlarmClockActivity f7276a;

    C2077o(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7276a = eventAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("EventAlarmClockActivity", "addAlarm() err_code = " + i);
        this.f7276a.m10745e();
        this.f7276a.finish();
    }
}
