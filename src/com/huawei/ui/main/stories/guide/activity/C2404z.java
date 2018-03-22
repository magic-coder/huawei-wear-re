package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2404z implements IBaseResponseCallback {
    final /* synthetic */ BasicInfoSettingActivity f8673a;

    C2404z(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8673a = basicInfoSettingActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            C2538c.m12677c("BasicInfoSettingActivity", "onCreate() getUserInfo success.");
        }
    }
}
