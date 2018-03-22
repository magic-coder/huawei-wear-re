package com.huawei.ui.device.activity.eventalarm;

import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: EventAlarmClockActivity */
class C2076n implements IBaseResponseCallback {
    final /* synthetic */ EventAlarmClockActivity f7275a;

    C2076n(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7275a = eventAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f7275a.f7246l = (List) obj;
            C2538c.m12677c("EventAlarmClockActivity", "addAlarm() + mEventAlarmList.size()" + this.f7275a.f7246l.size());
            for (int i2 = 0; i2 < this.f7275a.f7246l.size(); i2++) {
                C2538c.m12677c("EventAlarmClockActivity", "addAlarm() ++ i = " + i2);
                this.f7275a.f7247m.add((EventAlarmInfo) this.f7275a.f7246l.get(i2));
            }
        }
    }
}
