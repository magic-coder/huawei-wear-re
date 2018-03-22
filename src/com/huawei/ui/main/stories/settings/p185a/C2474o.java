package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: UserProfileSettingsInteractors */
class C2474o implements IBaseResponseCallback {
    final /* synthetic */ C2473n f8884a;

    C2474o(C2473n c2473n) {
        this.f8884a = c2473n;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("UserProfileSettingsInteractors", "设置用户信息更改身高的callback回来了！！");
        if (i != 0) {
            C2538c.m12680e("UserProfileSettingsInteractors", "设置用户信息失败！");
            this.f8884a.f8883c.f8860n.sendEmptyMessage(0);
            return;
        }
        C2538c.m12680e("UserProfileSettingsInteractors", "设置用户信息成功！");
        this.f8884a.f8883c.f8860n.sendEmptyMessage(8);
    }
}
