package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: ProfileSettingActivity */
class bg implements OnEditorActionListener {
    final /* synthetic */ ProfileSettingActivity f6628a;

    bg(ProfileSettingActivity profileSettingActivity) {
        this.f6628a = profileSettingActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f6628a.m9882a(textView, i);
    }
}
