package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SmartAlarmClockActivity */
class C2158e implements OnClickListener {
    final /* synthetic */ SmartAlarmClockActivity f7650a;

    C2158e(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7650a = smartAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("SmartAlarmClockActivity", "onClick() id = clock_btn_save_cancel");
        if (this.f7650a.m11061d()) {
            this.f7650a.m11049a(this.f7650a);
        } else {
            this.f7650a.finish();
        }
    }
}
