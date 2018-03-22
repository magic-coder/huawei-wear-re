package com.huawei.ab;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.userprofile.DeleteUserProfileRsp;
import com.huawei.p190v.C2538c;

/* compiled from: UserProfileUtil */
final class C3982z implements C3957a<DeleteUserProfileRsp> {
    final /* synthetic */ IBaseResponseCallback f15226a;

    C3982z(IBaseResponseCallback iBaseResponseCallback) {
        this.f15226a = iBaseResponseCallback;
    }

    public void m19716a(DeleteUserProfileRsp deleteUserProfileRsp, String str, boolean z) {
        C2538c.c("UserProfileUtil", new Object[]{"deleteUserProfile result is " + z});
        if (z) {
            if (this.f15226a != null) {
                this.f15226a.onResponse(0, null);
            }
        } else if (this.f15226a != null) {
            this.f15226a.onResponse(300099, null);
        }
    }
}
