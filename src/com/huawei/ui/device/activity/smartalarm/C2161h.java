package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SmartAlarmClockActivity */
class C2161h implements OnClickListener {
    final /* synthetic */ SmartAlarmClockActivity f7654a;

    C2161h(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7654a = smartAlarmClockActivity;
    }

    public void onClick(View view) {
        C2538c.m12680e("SmartAlarmClockActivity", "showPromptSaveDialog() No ...");
        this.f7654a.finish();
        this.f7654a.f7615A.cancel();
    }
}
