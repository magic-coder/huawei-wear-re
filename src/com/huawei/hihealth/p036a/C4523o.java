package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class C4523o implements Runnable {
    final /* synthetic */ HiUserInfo f16733a;
    final /* synthetic */ C3961b f16734b;
    final /* synthetic */ C4509c f16735c;

    C4523o(C4509c c4509c, HiUserInfo hiUserInfo, C3961b c3961b) {
        this.f16735c = c4509c;
        this.f16733a = hiUserInfo;
        this.f16734b = c3961b;
    }

    public void run() {
        this.f16735c.m21598d();
        try {
            this.f16735c.f16699b.mo4515a(this.f16733a, new C4524p(this));
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"setUserData e = ", e.getMessage()});
            if (this.f16734b != null) {
                this.f16734b.mo4332b(1, e.getMessage());
            }
        }
    }
}
