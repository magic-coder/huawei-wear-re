package com.huawei.ab;

import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;

/* compiled from: HWUserInfoMgr */
class C3959c implements C3957a<UserInfomation> {
    final /* synthetic */ C4694a f15181a;
    final /* synthetic */ C3956a f15182b;

    C3959c(C3956a c3956a, C4694a c4694a) {
        this.f15182b = c3956a;
        this.f15181a = c4694a;
    }

    public void m19669a(UserInfomation userInfomation, String str, boolean z) {
        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfoFromUp operationResult is " + z});
        if (z) {
            this.f15182b.m19648a(userInfomation, this.f15181a);
            return;
        }
        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfoFromUp Fail "});
        if (this.f15181a != null) {
            this.f15181a.mo4557a(-1);
            synchronized (C3956a.f15170c) {
                this.f15182b.f15172d = null;
            }
        }
    }
}
