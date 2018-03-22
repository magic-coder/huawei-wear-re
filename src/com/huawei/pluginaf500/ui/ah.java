package com.huawei.pluginaf500.ui;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* compiled from: AntiLostRemindActivity */
class ah implements OnSeekBarChangeListener {
    final /* synthetic */ AntiLostRemindActivity f19883a;

    ah(AntiLostRemindActivity antiLostRemindActivity) {
        this.f19883a = antiLostRemindActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (SettingActivity.f19813a != null) {
            SettingActivity.f19813a.m18181f(i + 3);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
