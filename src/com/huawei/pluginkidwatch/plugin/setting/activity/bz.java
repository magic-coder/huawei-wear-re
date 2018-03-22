package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SetKidWatchNumActivity */
class bz implements TextWatcher {
    final /* synthetic */ SetKidWatchNumActivity f6651a;

    bz(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6651a = setKidWatchNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if ("".equals(this.f6651a.f6503e.getText().toString())) {
            this.f6651a.f6503e.setTextSize(14.0f);
            if (this.f6651a.f6508j.isEnabled()) {
                this.f6651a.f6508j.setEnabled(false);
            }
            if (this.f6651a.f6506h.isEnabled()) {
                this.f6651a.f6506h.setEnabled(false);
                return;
            }
            return;
        }
        this.f6651a.f6503e.setTextSize(18.0f);
        if (!this.f6651a.f6508j.isEnabled()) {
            this.f6651a.f6508j.setEnabled(true);
        }
        if (!"".equals(this.f6651a.f6505g.getText().toString()) && !this.f6651a.f6506h.isEnabled()) {
            this.f6651a.f6506h.setEnabled(true);
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
