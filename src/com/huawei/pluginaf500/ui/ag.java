package com.huawei.pluginaf500.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: AntiLostRemindActivity */
class ag implements OnCheckedChangeListener {
    final /* synthetic */ AntiLostRemindActivity f19882a;

    ag(AntiLostRemindActivity antiLostRemindActivity) {
        this.f19882a = antiLostRemindActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SettingActivity.f19813a.m18178e(z ? 1 : 0);
    }
}
