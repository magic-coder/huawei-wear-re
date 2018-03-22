package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ProfileSettingActivity */
class bj implements TextWatcher {
    final /* synthetic */ ProfileSettingActivity f6631a;

    bj(ProfileSettingActivity profileSettingActivity) {
        this.f6631a = profileSettingActivity;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f6631a.m9893b(true);
    }
}
