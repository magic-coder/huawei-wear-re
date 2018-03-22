package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SetPhoneNumActivity */
class cj implements TextWatcher {
    final /* synthetic */ SetPhoneNumActivity f6663a;

    cj(SetPhoneNumActivity setPhoneNumActivity) {
        this.f6663a = setPhoneNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        String trim = this.f6663a.f6526c.getText().toString().trim();
        String trim2 = this.f6663a.f6527d.getText().toString().trim();
        if ("".equals(trim2)) {
            this.f6663a.f6527d.setTextSize(14.0f);
        } else {
            this.f6663a.f6527d.setTextSize(18.0f);
        }
        if ("".equals(trim) || "".equals(trim2)) {
            this.f6663a.f6529f.setEnabled(false);
        } else {
            this.f6663a.f6529f.setEnabled(true);
        }
    }
}
