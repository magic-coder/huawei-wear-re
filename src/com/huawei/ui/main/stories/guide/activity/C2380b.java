package com.huawei.ui.main.stories.guide.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ab.a;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2380b implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8643a;

    C2380b(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8643a = basicInfoSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("BasicInfoSettingActivity", "showObtainFailed cancel click");
        this.f8643a.f8613s.dismiss();
        this.f8643a.f8613s = null;
        if (a.a(this.f8643a.f8596a).b() != null) {
            this.f8643a.f8581H = a.a(this.f8643a.f8596a).b();
            C2538c.m12674b("BasicInfoSettingActivity", "showObtainFailed cancel click userInfo:" + this.f8643a.f8581H.toString());
            this.f8643a.m12082m();
            this.f8643a.m12110a();
            this.f8643a.m12101v();
        }
    }
}
