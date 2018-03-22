package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2397s implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8665a;

    C2397s(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8665a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8665a.f8616v != null) {
            this.f8665a.f8616v.dismiss();
            this.f8665a.f8616v = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "cancel mSettingBirthDialog is null");
    }
}
