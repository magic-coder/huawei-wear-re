package com.huawei.ab;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HWUserInfoMgr */
class C3963f implements C3961b {
    final /* synthetic */ IBaseResponseCallback f15191a;
    final /* synthetic */ C3956a f15192b;

    C3963f(C3956a c3956a, IBaseResponseCallback iBaseResponseCallback) {
        this.f15192b = c3956a;
        this.f15191a = iBaseResponseCallback;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth private onSuccess"});
        List list = (List) obj;
        if (list.size() > 0) {
            this.f15191a.onResponse(0, (HiUserInfo) list.get(0));
        }
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth private onFailure"});
        this.f15191a.onResponse(100001, null);
    }
}
