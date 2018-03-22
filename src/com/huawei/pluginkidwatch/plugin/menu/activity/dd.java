package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditPhoneNumActivity */
class dd implements TextWatcher {
    final /* synthetic */ EditPhoneNumActivity f6027a;

    dd(EditPhoneNumActivity editPhoneNumActivity) {
        this.f6027a = editPhoneNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String trim = this.f6027a.f5662c.getText().toString().trim();
        String trim2 = this.f6027a.f5663d.getText().toString().trim();
        if ("".equals(trim2)) {
            this.f6027a.f5663d.setTextSize(14.0f);
        } else {
            this.f6027a.f5663d.setTextSize(18.0f);
        }
        if ("".equals(trim) || "".equals(trim2)) {
            this.f6027a.f5665f.setEnabled(false);
        } else {
            this.f6027a.f5665f.setEnabled(true);
        }
    }
}
