package com.huawei.ui.main.stories.guide.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2383e implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8646a;

    C2383e(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8646a = basicInfoSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("BasicInfoSettingActivity", "showLoginFail ok click");
        this.f8646a.f8612r.dismiss();
        this.f8646a.f8612r = null;
        this.f8646a.m12070g();
    }
}
