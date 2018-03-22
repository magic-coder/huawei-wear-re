package com.huawei.ui.device.activity.smartalarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: SmartAlarmClockActivity */
class C2164k implements IBaseResponseCallback {
    final /* synthetic */ C2163j f7657a;

    C2164k(C2163j c2163j) {
        this.f7657a = c2163j;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("SmartAlarmClockActivity", "saveUIData() err_code = " + i);
        this.f7657a.f7656a.m11058c();
        this.f7657a.f7656a.finish();
    }
}
