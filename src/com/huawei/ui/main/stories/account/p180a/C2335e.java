package com.huawei.ui.main.stories.account.p180a;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2331j;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2353b;

/* compiled from: WeChatAccount */
class C2335e implements C2331j {
    final /* synthetic */ C2344c f8461a;
    final /* synthetic */ C2334d f8462b;

    C2335e(C2334d c2334d, C2344c c2344c) {
        this.f8462b = c2334d;
        this.f8461a = c2344c;
    }

    public void mo2653a(int i, Boolean bool) {
        C2538c.m12674b(C2334d.f8458a, "logoutCallback  isSuccess = ", bool);
        switch (i) {
            case 0:
                this.f8461a.mo2657a(bool);
                return;
            case 1:
                this.f8461a.mo2656a(5, "");
                return;
            default:
                this.f8461a.mo2656a(9, "");
                return;
        }
    }

    public void mo2654a(int i, String str, String str2, String str3, int i2) {
        C2538c.m12674b(C2334d.f8458a, "logoutCallback  resultCode = ", Integer.valueOf(i), ",accessToken = ", str, ",userID = ", str2, ",userName = ", str3, ",siteId = ", Integer.valueOf(i2));
        switch (i) {
            case 0:
                C2353b c2353b = new C2353b();
                c2353b.m11938c(1);
                c2353b.m11939c(str2);
                c2353b.m11936b(str);
                c2353b.m11941d(str3);
                this.f8461a.mo2657a(c2353b);
                return;
            case 1:
                this.f8461a.mo2656a(5, "");
                return;
            default:
                this.f8461a.mo2656a(9, "");
                return;
        }
    }

    public void mo2655a(boolean z) {
        C2538c.m12674b(C2334d.f8458a, "initCallback  isSuccess = ", Boolean.valueOf(z));
        if (!z) {
            this.f8461a.mo2656a(3, "isSuccess = " + z);
        }
    }
}
