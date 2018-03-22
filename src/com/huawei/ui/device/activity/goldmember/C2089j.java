package com.huawei.ui.device.activity.goldmember;

import com.huawei.p190v.C2538c;

/* compiled from: VIPUserInfoActivity */
class C2089j implements Runnable {
    final /* synthetic */ VIPUserInfoActivity f7369a;

    C2089j(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7369a = vIPUserInfoActivity;
    }

    public void run() {
        if (this.f7369a.f7332c != null) {
            this.f7369a.f7332c.m10473a(this.f7369a.f7311G, this.f7369a.f7329Y);
            return;
        }
        C2538c.m12680e(VIPUserInfoActivity.f7302d, "mHuaweiGoldMemberInteractors is null!");
        this.f7369a.f7327W.sendEmptyMessage(7);
    }
}
