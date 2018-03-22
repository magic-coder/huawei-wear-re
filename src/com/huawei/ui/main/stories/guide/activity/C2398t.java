package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2398t implements IBaseResponseCallback {
    final /* synthetic */ BasicInfoSettingActivity f8666a;

    C2398t(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8666a = basicInfoSettingActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("BasicInfoSettingActivity", "GuideInteractors.setUserInfo err_code = " + i);
        if (this.f8666a.f8592T == null) {
            return;
        }
        if (i == 0) {
            this.f8666a.f8592T.sendEmptyMessage(3);
        } else {
            this.f8666a.f8592T.sendEmptyMessage(4);
        }
    }
}
