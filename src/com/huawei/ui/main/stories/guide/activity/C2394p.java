package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2394p implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8662a;

    C2394p(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8662a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改weight");
        this.f8662a.m12035J();
        if (this.f8662a.f8615u != null) {
            this.f8662a.f8615u.dismiss();
            this.f8662a.f8615u = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改weight mSettingWeightDialog is null");
    }
}
