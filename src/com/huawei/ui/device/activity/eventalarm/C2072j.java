package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.commonui.a.a;

/* compiled from: EventAlarmClockActivity */
class C2072j implements OnClickListener {
    final /* synthetic */ a f7270a;
    final /* synthetic */ EventAlarmClockActivity f7271b;

    C2072j(EventAlarmClockActivity eventAlarmClockActivity, a aVar) {
        this.f7271b = eventAlarmClockActivity;
        this.f7270a = aVar;
    }

    public void onClick(View view) {
        boolean[] a = this.f7270a.a();
        this.f7271b.f7254t = this.f7271b.f7256v.m11188a(a);
        this.f7271b.f7252r.setText(this.f7271b.f7256v.m11194b(this.f7271b.f7256v.m11188a(a)));
    }
}
