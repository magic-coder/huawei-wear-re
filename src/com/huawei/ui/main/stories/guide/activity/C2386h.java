package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwcloudmodel.callback.a;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2386h implements a<Boolean> {
    final /* synthetic */ BasicInfoSettingActivity f8649a;

    C2386h(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8649a = basicInfoSettingActivity;
    }

    public void m12124a(Boolean bool, String str, boolean z) {
        C2538c.m12677c("BasicInfoSettingActivity", "mHWUserProfileMgr.setUserInfoToLocal() operationResult isSuccess=" + z);
        if (z) {
            this.f8649a.f8592T.sendEmptyMessage(3);
        } else {
            this.f8649a.f8592T.sendEmptyMessage(4);
        }
    }
}
