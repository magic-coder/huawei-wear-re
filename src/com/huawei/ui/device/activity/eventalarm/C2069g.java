package com.huawei.ui.device.activity.eventalarm;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.huawei.p190v.C2538c;

/* compiled from: EventAlarmClockActivity */
class C2069g implements OnClickListener {
    final /* synthetic */ EditText f7266a;
    final /* synthetic */ EventAlarmClockActivity f7267b;

    C2069g(EventAlarmClockActivity eventAlarmClockActivity, EditText editText) {
        this.f7267b = eventAlarmClockActivity;
        this.f7266a = editText;
    }

    public void onClick(View view) {
        C2538c.m12677c("EventAlarmClockActivity", "editName():用户修改name为：" + this.f7266a.getText().toString());
        EventAlarmClockActivity.f7235h = r0;
        this.f7267b.f7241f.setText(EventAlarmClockActivity.f7235h);
    }
}
