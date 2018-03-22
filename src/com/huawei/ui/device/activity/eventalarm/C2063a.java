package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import java.io.UnsupportedEncodingException;

/* compiled from: EventAlarmClockActivity */
class C2063a implements OnClickListener {
    final /* synthetic */ EventAlarmClockActivity f7259a;

    C2063a(EventAlarmClockActivity eventAlarmClockActivity) {
        this.f7259a = eventAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "onClick() id = clock_btn_save_sure");
        try {
            this.f7259a.m10748g();
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("EventAlarmClockActivity", "UnsupportedEncodingException = " + e.getMessage());
        }
    }
}
