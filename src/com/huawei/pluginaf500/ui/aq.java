package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.WheelView;

/* compiled from: IncomingRemindActivity */
class aq implements C5791c {
    final /* synthetic */ IncomingRemindActivity f19894a;

    aq(IncomingRemindActivity incomingRemindActivity) {
        this.f19894a = incomingRemindActivity;
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        String valueOf = String.valueOf(i2);
        if (i2 < 10) {
            valueOf = "0" + valueOf;
        }
        if (this.f19894a.f19765h == 1) {
            this.f19894a.f19763d = this.f19894a.f19763d.substring(0, 3) + valueOf;
        } else {
            this.f19894a.f19764g = this.f19894a.f19764g.substring(0, 3) + valueOf;
        }
    }
}
