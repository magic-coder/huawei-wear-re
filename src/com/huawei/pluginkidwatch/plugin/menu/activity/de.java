package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditPhoneNumActivity */
class de implements TextWatcher {
    final /* synthetic */ EditPhoneNumActivity f6028a;

    de(EditPhoneNumActivity editPhoneNumActivity) {
        this.f6028a = editPhoneNumActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String trim = this.f6028a.f5662c.getText().toString().trim();
        String trim2 = this.f6028a.f5663d.getText().toString().trim();
        if ("".equals(trim)) {
            this.f6028a.f5662c.setTextSize(14.0f);
            if (this.f6028a.f5667h.isEnabled()) {
                this.f6028a.f5667h.setEnabled(false);
            }
            if (this.f6028a.f5665f.isEnabled()) {
                this.f6028a.f5665f.setEnabled(false);
                return;
            }
            return;
        }
        this.f6028a.f5662c.setTextSize(18.0f);
        if ("".equals(trim2)) {
            if (this.f6028a.f5665f.isEnabled()) {
                this.f6028a.f5665f.setEnabled(false);
            }
            if (!this.f6028a.f5667h.isEnabled()) {
                this.f6028a.f5667h.setEnabled(true);
                return;
            }
            return;
        }
        if (!this.f6028a.f5665f.isEnabled()) {
            this.f6028a.f5665f.setEnabled(true);
        }
        if (!this.f6028a.f5667h.isEnabled()) {
            this.f6028a.f5667h.setEnabled(true);
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
