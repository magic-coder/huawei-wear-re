package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2392n implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8658a;

    C2392n(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8658a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8658a.f8614t != null) {
            this.f8658a.f8614t.dismiss();
            this.f8658a.f8614t = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "cancel mSettingHighDialog is null");
    }
}
