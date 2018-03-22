package com.huawei.ui.device.activity.alarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: AlarmActivity */
class C2019d implements OnClickListener {
    final /* synthetic */ AlarmActivity f7094a;

    C2019d(AlarmActivity alarmActivity) {
        this.f7094a = alarmActivity;
    }

    public void onClick(View view) {
        this.f7094a.m10597i();
        C2538c.m12677c("AlarmActivity", "mAlarmAdded : onClick() ListView footer");
    }
}
