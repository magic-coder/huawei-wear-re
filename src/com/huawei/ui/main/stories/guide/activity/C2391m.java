package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2391m implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8657a;

    C2391m(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8657a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改height");
        this.f8657a.m12031H();
        if (this.f8657a.f8614t != null) {
            this.f8657a.f8614t.dismiss();
            this.f8657a.f8614t = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改height mSettingHighDialog is null");
    }
}
