package com.huawei.ui.main.stories.account.p180a;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2331j;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2353b;

/* compiled from: QQAccount */
class C2332b implements C2331j {
    final /* synthetic */ C2344c f8453a;
    final /* synthetic */ C2330a f8454b;

    C2332b(C2330a c2330a, C2344c c2344c) {
        this.f8454b = c2330a;
        this.f8453a = c2344c;
    }

    public void mo2653a(int i, Boolean bool) {
        C2538c.m12674b(C2330a.f8450a, "logoutCallback  isSuccess = ", bool);
        switch (i) {
            case 0:
                this.f8453a.mo2657a(bool);
                return;
            case 1:
                this.f8453a.mo2656a(5, "");
                return;
            default:
                this.f8453a.mo2656a(9, "");
                return;
        }
    }

    public void mo2654a(int i, String str, String str2, String str3, int i2) {
        C2538c.m12674b(C2330a.f8450a, "logoutCallback  resultCode = ", Integer.valueOf(i), ",accessToken = ", str, ",userID = ", str2, ",userName = ", str3, ",siteId = ", Integer.valueOf(i2));
        switch (i) {
            case 0:
                C2353b c2353b = new C2353b();
                c2353b.m11938c(7);
                c2353b.m11939c(str2);
                c2353b.m11936b(str);
                c2353b.m11941d(str3);
                this.f8453a.mo2657a(c2353b);
                return;
            case 1:
                this.f8453a.mo2656a(5, "");
                return;
            default:
                this.f8453a.mo2656a(9, "");
                return;
        }
    }

    public void mo2655a(boolean z) {
        C2538c.m12674b(C2330a.f8450a, "initCallback  isSuccess = ", Boolean.valueOf(z));
        if (!z) {
            this.f8453a.mo2656a(3, "isSuccess = " + z);
        }
    }
}
