package com.huawei.ui.main.stories.account.activity;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2353b;
import java.lang.ref.WeakReference;

/* compiled from: ThirdPartyLoginActivity */
class C2350n implements C2344c {
    private WeakReference<ThirdPartyLoginActivity> f8503a;
    private ThirdPartyLoginActivity f8504b = ((ThirdPartyLoginActivity) this.f8503a.get());

    public C2350n(ThirdPartyLoginActivity thirdPartyLoginActivity) {
        this.f8503a = new WeakReference(thirdPartyLoginActivity);
    }

    public void mo2657a(Object obj) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "login onSuccess ");
        if (obj instanceof C2353b) {
            try {
                C2353b c2353b = (C2353b) obj;
                if (this.f8504b != null) {
                    String e = c2353b.m11942e();
                    String d = c2353b.m11940d();
                    int c = c2353b.m11937c();
                    C2538c.m12674b(ThirdPartyLoginActivity.f8465h, "openId==", e, "; accessToken==", d, "; loginType = ", Integer.valueOf(c));
                    if (c != 1) {
                        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "Enter login 4");
                        this.f8504b.m11913a(c2353b);
                        return;
                    } else if (this.f8504b.f8474i != null) {
                        this.f8504b.f8474i.execute(new C2351o(this, c2353b));
                        return;
                    } else {
                        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "Enter login 3");
                        this.f8504b.m11913a(c2353b);
                        return;
                    }
                }
                return;
            } catch (TypeNotPresentException e2) {
                C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "(AccountContext) data error " + e2.getMessage());
                return;
            }
        }
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "login onFailure errcode");
        if (this.f8504b != null) {
            this.f8504b.f8475j.sendEmptyMessage(4012);
        }
    }

    public void mo2656a(int i, String str) {
        C2538c.m12677c(ThirdPartyLoginActivity.f8465h, "login onFailure errcode = " + i + "; errmsg = ", str);
        if (this.f8504b != null) {
            this.f8504b.f8475j.sendEmptyMessage(4012);
        }
    }
}
