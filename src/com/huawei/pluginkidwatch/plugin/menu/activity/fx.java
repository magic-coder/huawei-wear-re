package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SettingLocationActivity */
class fx implements OnClickListener {
    final /* synthetic */ SettingLocationActivity f6138a;

    fx(SettingLocationActivity settingLocationActivity) {
        this.f6138a = settingLocationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c("SettingLocationActivity", "=======showStartSavingFrequencyDialog ok!");
        this.f6138a.m9515f();
    }
}
