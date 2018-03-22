package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2071i implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7269a;

    C2071i(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7269a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "onClick() id = clock_btn_save_cancel");
        this.f7269a.m10751h();
    }
}
