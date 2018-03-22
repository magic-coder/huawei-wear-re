package com.huawei.ui.main.stories.guide.activity;

import android.os.Bundle;
import com.huawei.p190v.C2538c;
import com.huawei.up.b.a;

/* compiled from: BasicInfoSettingActivity */
class C2401w implements a {
    final /* synthetic */ BasicInfoSettingActivity f8669a;

    C2401w(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8669a = basicInfoSettingActivity;
    }

    public void m12129a(Bundle bundle) {
        C2538c.m12677c("BasicInfoSettingActivity", "get userinfo from cloud success.");
        this.f8669a.f8592T.sendEmptyMessage(0);
    }

    public void m12128a(int i) {
        C2538c.m12679d("BasicInfoSettingActivity", "get userinfo from cloud failure.");
        this.f8669a.f8592T.sendEmptyMessage(1);
    }
}
