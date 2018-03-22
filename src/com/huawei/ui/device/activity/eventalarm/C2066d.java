package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2066d implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7262a;

    C2066d(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7262a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "showPromptDeleteDialog() no ...");
        this.f7262a.f7258x.cancel();
    }
}
