package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2067e implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7263a;

    C2067e(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7263a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12680e("EventAlarmClockActivity", "showPromptDeleteDialog() yes ...");
        this.f7263a.m10747f();
        this.f7263a.f7258x.cancel();
    }
}
