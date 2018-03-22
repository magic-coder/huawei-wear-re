package com.huawei.ui.device.activity.eventalarm;

import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: EventAlarmClockActivity */
class C2078p implements IBaseResponseCallback {
    final /* synthetic */ EventAlarmClockActivity f7277a;

    C2078p(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7277a = eventAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("EventAlarmClockActivity", " updateEventAlarm()---AlarmListItem" + this.f7277a.f7249o.m11242g());
        this.f7277a.f7246l = (List) obj;
        if (this.f7277a.f7246l.size() == 0 || this.f7277a.f7246l.size() <= this.f7277a.f7249o.m11242g() - 1) {
            C2538c.m12677c("EventAlarmClockActivity", "updateEventAlarm() error");
        } else {
            this.f7277a.f7246l.remove(this.f7277a.f7249o.m11242g() - 1);
        }
        for (int i2 = 0; i2 < this.f7277a.f7246l.size(); i2++) {
            C2538c.m12677c("EventAlarmClockActivity", "addAlarm() ++ i  " + i2);
            this.f7277a.f7247m.add((EventAlarmInfo) this.f7277a.f7246l.get(i2));
        }
    }
}
