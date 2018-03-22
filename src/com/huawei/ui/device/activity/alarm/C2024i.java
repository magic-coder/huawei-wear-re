package com.huawei.ui.device.activity.alarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: AlarmActivity */
class C2024i implements IBaseResponseCallback {
    final /* synthetic */ C2023h f7099a;

    C2024i(C2023h c2023h) {
        this.f7099a = c2023h;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("AlarmActivity", "setSmartAlarm() err_code == " + i);
    }
}
