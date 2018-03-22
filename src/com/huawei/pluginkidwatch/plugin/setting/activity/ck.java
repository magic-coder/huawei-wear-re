package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SetPhoneNumActivity */
class ck implements TextWatcher {
    final /* synthetic */ SetPhoneNumActivity f6664a;

    ck(SetPhoneNumActivity setPhoneNumActivity) {
        this.f6664a = setPhoneNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String trim = this.f6664a.f6526c.getText().toString().trim();
        String trim2 = this.f6664a.f6527d.getText().toString().trim();
        if ("".equals(trim)) {
            this.f6664a.f6526c.setTextSize(14.0f);
            if (this.f6664a.f6531h.isEnabled()) {
                this.f6664a.f6531h.setEnabled(false);
            }
            if (this.f6664a.f6529f.isEnabled()) {
                this.f6664a.f6529f.setEnabled(false);
                return;
            }
            return;
        }
        this.f6664a.f6526c.setTextSize(18.0f);
        if ("".equals(trim2)) {
            if (this.f6664a.f6529f.isEnabled()) {
                this.f6664a.f6529f.setEnabled(false);
            }
            if (!this.f6664a.f6531h.isEnabled()) {
                this.f6664a.f6531h.setEnabled(true);
                return;
            }
            return;
        }
        if (!this.f6664a.f6529f.isEnabled()) {
            this.f6664a.f6529f.setEnabled(true);
        }
        if (!this.f6664a.f6531h.isEnabled()) {
            this.f6664a.f6531h.setEnabled(true);
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
