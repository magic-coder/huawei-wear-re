package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: UserProfileSettingsInteractors */
class C2468i implements IBaseResponseCallback {
    final /* synthetic */ C2467h f8876a;

    C2468i(C2467h c2467h) {
        this.f8876a = c2467h;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("UserProfileSettingsInteractors", "设置用户信息更改体重的callback回来了！！");
        if (i != 0) {
            C2538c.m12680e("UserProfileSettingsInteractors", "设置用户信息失败！");
            this.f8876a.f8875c.f8860n.sendEmptyMessage(0);
            return;
        }
        C2538c.m12680e("UserProfileSettingsInteractors", "设置用户信息成功！");
        this.f8876a.f8875c.f8860n.sendEmptyMessage(9);
    }
}
