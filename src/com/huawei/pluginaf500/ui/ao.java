package com.huawei.pluginaf500.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: IncomingRemindActivity */
class ao implements OnCheckedChangeListener {
    final /* synthetic */ IncomingRemindActivity f19892a;

    ao(IncomingRemindActivity incomingRemindActivity) {
        this.f19892a = incomingRemindActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SettingActivity.f19813a.m18175d(z ? 1 : 0);
    }
}
