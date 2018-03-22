package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.view.wheel.C5791c;
import com.huawei.pluginaf500.view.wheel.WheelView;

/* compiled from: SleepRemindActivity */
class bs implements C5791c {
    final /* synthetic */ SleepRemindActivity f19939a;

    bs(SleepRemindActivity sleepRemindActivity) {
        this.f19939a = sleepRemindActivity;
    }

    public void mo5113a(WheelView wheelView, int i, int i2) {
        if (this.f19939a.f19837j == 1) {
            this.f19939a.f19835h = this.f19939a.m26812a(this.f19939a.f19835h, i2);
        } else if (this.f19939a.f19837j == 2) {
            this.f19939a.f19836i = this.f19939a.m26812a(this.f19939a.f19836i, i2);
        }
    }
}
