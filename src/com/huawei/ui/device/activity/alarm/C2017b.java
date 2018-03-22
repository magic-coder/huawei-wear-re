package com.huawei.ui.device.activity.alarm;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: AlarmActivity */
class C2017b implements IBaseResponseCallback {
    final /* synthetic */ AlarmActivity f7092a;

    C2017b(AlarmActivity alarmActivity) {
        this.f7092a = alarmActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("AlarmActivity", "updateEventAlarm() err_code = " + i);
    }
}
