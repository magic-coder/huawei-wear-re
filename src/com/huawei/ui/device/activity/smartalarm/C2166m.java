package com.huawei.ui.device.activity.smartalarm;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SmartAlarmClockActivity */
class C2166m extends Handler {
    WeakReference<SmartAlarmClockActivity> f7659a;
    final /* synthetic */ SmartAlarmClockActivity f7660b;

    C2166m(SmartAlarmClockActivity smartAlarmClockActivity, SmartAlarmClockActivity smartAlarmClockActivity2) {
        this.f7660b = smartAlarmClockActivity;
        this.f7659a = new WeakReference(smartAlarmClockActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((SmartAlarmClockActivity) this.f7659a.get()) != null) {
            switch (message.what) {
                case 1:
                    this.f7660b.m11067f();
                    return;
                default:
                    return;
            }
        }
    }
}
