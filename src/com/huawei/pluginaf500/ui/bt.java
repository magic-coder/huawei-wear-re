package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.WheelView;

/* compiled from: SleepRemindActivity */
class bt implements C5791c {
    final /* synthetic */ SleepRemindActivity f19940a;

    bt(SleepRemindActivity sleepRemindActivity) {
        this.f19940a = sleepRemindActivity;
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        String valueOf = String.valueOf(i2);
        if (i2 < 10) {
            valueOf = "0" + valueOf;
        }
        if (this.f19940a.f19837j == 1) {
            this.f19940a.f19835h = this.f19940a.f19835h.substring(0, 3) + valueOf;
        } else {
            this.f19940a.f19836i = this.f19940a.f19836i.substring(0, 3) + valueOf;
        }
    }
}
