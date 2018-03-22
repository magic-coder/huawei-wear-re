package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SmartAlarmClockActivity */
class C2157d implements OnClickListener {
    final /* synthetic */ SmartAlarmClockActivity f7649a;

    C2157d(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7649a = smartAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("SmartAlarmClockActivity", "onClick() id = clock_btn_save_sure");
        if (this.f7649a.m11061d()) {
            this.f7649a.m11069g();
        } else if (this.f7649a.f7636q == 0) {
            this.f7649a.f7636q = 1;
            this.f7649a.m11069g();
        } else {
            this.f7649a.finish();
        }
    }
}
