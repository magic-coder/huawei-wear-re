package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SmartAlarmClockActivity */
class C2162i implements OnClickListener {
    final /* synthetic */ SmartAlarmClockActivity f7655a;

    C2162i(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7655a = smartAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("SmartAlarmClockActivity", "showPromptSaveDialog() Yes ...");
        if (1 == this.f7655a.f7636q) {
            this.f7655a.m11069g();
        }
        this.f7655a.f7615A.cancel();
    }
}
