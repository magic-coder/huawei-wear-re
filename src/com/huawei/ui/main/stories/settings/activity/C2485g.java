package com.huawei.ui.main.stories.settings.activity;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: PersonalPrivacySettingsActivity */
class C2485g implements IBaseResponseCallback {
    final /* synthetic */ C2484f f8952a;

    C2485g(C2484f c2484f) {
        this.f8952a = c2484f;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(PersonalPrivacySettingsActivity.f8910a, "设置用户信息更改的callback回来了！！errorCode=" + i);
        if (i != 0) {
            C2538c.m12680e(PersonalPrivacySettingsActivity.f8910a, "设置用户信息失败！");
            return;
        }
        C2538c.m12674b(PersonalPrivacySettingsActivity.f8910a, "设置用户信息成功！");
        if (obj != null) {
            C2538c.m12674b(PersonalPrivacySettingsActivity.f8910a, "new userInfo:" + obj);
        }
    }
}
