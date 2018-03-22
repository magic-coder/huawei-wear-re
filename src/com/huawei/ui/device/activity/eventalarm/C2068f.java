package com.huawei.ui.device.activity.eventalarm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.huawei.hwcommonmodel.C0973a;

/* compiled from: EventAlarmClockActivity */
class C2068f implements TextWatcher {
    final /* synthetic */ EditText f7264a;
    final /* synthetic */ EventAlarmClockActivity f7265b;

    C2068f(EventAlarmClockActivity eventAlarmClockActivity, EditText editText) {
        this.f7265b = eventAlarmClockActivity;
        this.f7264a = editText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (24 < C0973a.m3518e(this.f7264a.getText().toString()).length() / 2) {
            this.f7265b.f7236a = this.f7264a.getText().toString();
            this.f7264a.setText(this.f7265b.f7236a.substring(0, this.f7265b.f7236a.length() - 1));
            this.f7264a.setSelection(this.f7265b.f7236a.length() - 1);
        }
    }

    public void afterTextChanged(Editable editable) {
    }
}
