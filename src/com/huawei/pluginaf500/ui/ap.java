package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.WheelView;

/* compiled from: IncomingRemindActivity */
class ap implements C5791c {
    final /* synthetic */ IncomingRemindActivity f19893a;

    ap(IncomingRemindActivity incomingRemindActivity) {
        this.f19893a = incomingRemindActivity;
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        if (this.f19893a.f19765h == 1) {
            this.f19893a.f19763d = this.f19893a.m26725a(this.f19893a.f19763d, i2);
        } else if (this.f19893a.f19765h == 2) {
            this.f19893a.f19764g = this.f19893a.m26725a(this.f19893a.f19764g, i2);
        }
    }
}
