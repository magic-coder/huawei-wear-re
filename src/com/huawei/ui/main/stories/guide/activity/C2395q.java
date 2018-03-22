package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2395q implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8663a;

    C2395q(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8663a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8663a.f8615u != null) {
            this.f8663a.f8615u.dismiss();
            this.f8663a.f8615u = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "cancel mSettingWeightDialog is null");
    }
}
