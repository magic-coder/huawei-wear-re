package com.huawei.ui.device.activity.eventalarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: EventAlarmClockActivity */
class C2074l implements IBaseResponseCallback {
    final /* synthetic */ EventAlarmClockActivity f7273a;

    C2074l(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7273a = eventAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("EventAlarmClockActivity", "deleteClock()" + this.f7273a.f7249o.m11242g());
        this.f7273a.f7246l = (List) obj;
        if (this.f7273a.f7246l.size() == 0 || this.f7273a.f7246l.size() <= this.f7273a.f7249o.m11242g() - 1) {
            C2538c.m12677c("EventAlarmClockActivity", "deleteClock() error");
        } else {
            this.f7273a.f7246l.remove(this.f7273a.f7249o.m11242g() - 1);
        }
        this.f7273a.f7248n.m10419a(this.f7273a.f7246l, new C2075m(this));
    }
}
