package com.huawei.ui.device.activity.eventalarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2079q implements IBaseResponseCallback {
    final /* synthetic */ EventAlarmClockActivity f7278a;

    C2079q(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7278a = eventAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("EventAlarmClockActivity", "updateEventAlarm() err_code = " + i);
        this.f7278a.m10745e();
        this.f7278a.finish();
    }
}
