package com.huawei.ui.device.activity.alarm;

import com.huawei.p190v.C2538c;
import java.util.Calendar;

/* compiled from: AlarmActivity */
class C2016a implements Runnable {
    final /* synthetic */ AlarmActivity f7091a;

    C2016a(AlarmActivity alarmActivity) {
        this.f7091a = alarmActivity;
    }

    public void run() {
        C2538c.m12677c("AlarmActivity", "==once== set timer enter...curSecond = " + Calendar.getInstance().get(13));
        this.f7091a.f7066C.postDelayed(this, (long) (60000 - ((r0 - 1) * 1000)));
        this.f7091a.m10590e();
        this.f7091a.m10588d();
    }
}
