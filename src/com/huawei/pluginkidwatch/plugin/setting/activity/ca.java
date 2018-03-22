package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SetKidWatchNumActivity */
class ca implements TextWatcher {
    final /* synthetic */ SetKidWatchNumActivity f6653a;

    ca(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6653a = setKidWatchNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if ("".equals(this.f6653a.f6505g.getText().toString())) {
            this.f6653a.f6505g.setTextSize(14.0f);
            if (this.f6653a.f6506h.isEnabled()) {
                this.f6653a.f6506h.setEnabled(false);
                return;
            }
            return;
        }
        this.f6653a.f6505g.setTextSize(18.0f);
        if ("".equals(this.f6653a.f6503e.getText().toString())) {
            if (this.f6653a.f6506h.isEnabled()) {
                this.f6653a.f6506h.setEnabled(false);
            }
        } else if (!this.f6653a.f6506h.isEnabled()) {
            this.f6653a.f6506h.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
