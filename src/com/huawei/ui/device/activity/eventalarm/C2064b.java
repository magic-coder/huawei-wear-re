package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2064b implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7260a;

    C2064b(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7260a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12680e("EventAlarmClockActivity", "showPromptSaveDialog() No ...");
        this.f7260a.m10745e();
        this.f7260a.finish();
        this.f7260a.f7257w.cancel();
    }
}
