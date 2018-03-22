package com.huawei.ui.device.activity.alarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: AlarmActivity */
class C2026k implements IBaseResponseCallback {
    final /* synthetic */ C2025j f7102a;

    C2026k(C2025j c2025j) {
        this.f7102a = c2025j;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("AlarmActivity", "MESSAGE_UPDATE_EVENT_ALARM_UI err_code = " + i);
    }
}
