package com.huawei.ab;

import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;

/* compiled from: HWUserInfoMgr */
class C3960d implements Runnable {
    final /* synthetic */ UserInfomation f15183a;
    final /* synthetic */ C4694a f15184b;
    final /* synthetic */ C3956a f15185c;

    C3960d(C3956a c3956a, UserInfomation userInfomation, C4694a c4694a) {
        this.f15185c = c3956a;
        this.f15183a = userInfomation;
        this.f15184b = c4694a;
    }

    public void run() {
        if (!this.f15185c.m19657b(this.f15183a, this.f15184b) && !this.f15185c.m19651a(this.f15184b)) {
            C2538c.c("HWUserInfoMgr", new Object[]{"downloadUserInfo() UP success)"});
            synchronized (C3956a.f15170c) {
                this.f15185c.f15172d = this.f15183a;
            }
            this.f15185c.m19664a(this.f15184b, false, false, new int[0]);
        }
    }
}
