package com.huawei.ui.main.stories.guide.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2381c implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8644a;

    C2381c(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8644a = basicInfoSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("BasicInfoSettingActivity", "showObtainFailed ok click");
        this.f8644a.f8613s.dismiss();
        this.f8644a.f8613s = null;
        this.f8644a.m12074i();
        this.f8644a.m12065d();
    }
}
