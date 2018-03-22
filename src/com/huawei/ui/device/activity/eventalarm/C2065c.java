package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import java.io.UnsupportedEncodingException;

/* compiled from: EventAlarmClockActivity */
class C2065c implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7261a;

    C2065c(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7261a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "showPromptSaveDialog() Yes ...");
        try {
            this.f7261a.m10748g();
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("EventAlarmClockActivity", "UnsupportedEncodingException = " + e.getMessage());
        }
        this.f7261a.f7257w.cancel();
    }
}
