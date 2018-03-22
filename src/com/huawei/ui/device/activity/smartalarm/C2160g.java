package com.huawei.ui.device.activity.smartalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.commonui.a.a;

/* compiled from: SmartAlarmClockActivity */
class C2160g implements OnClickListener {
    final /* synthetic */ a f7652a;
    final /* synthetic */ SmartAlarmClockActivity f7653b;

    C2160g(SmartAlarmClockActivity smartAlarmClockActivity, a aVar) {
        this.f7653b = smartAlarmClockActivity;
        this.f7652a = aVar;
    }

    public void onClick(View view) {
        boolean[] a = this.f7652a.a();
        this.f7653b.f7632m = this.f7653b.f7623d.m11188a(a);
        this.f7653b.f7633n.setText(this.f7653b.f7623d.m11194b(this.f7653b.f7623d.m11188a(a)));
    }
}
