package com.huawei.ui.main.stories.guide.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2382d implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8645a;

    C2382d(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8645a = basicInfoSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("BasicInfoSettingActivity", "showLoginFail cancel click");
        this.f8645a.f8612r.dismiss();
        this.f8645a.f8612r = null;
        this.f8645a.finish();
    }
}
