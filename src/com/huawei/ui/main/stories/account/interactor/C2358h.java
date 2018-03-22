package com.huawei.ui.main.stories.account.interactor;

import android.content.Context;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiCloudLogin */
class C2358h implements C2344c {
    private Context f8530a;
    private C2344c f8531b;

    public C2358h(Context context, C2344c c2344c) {
        this.f8530a = context;
        this.f8531b = c2344c;
    }

    public void mo2657a(Object obj) {
        C2538c.m12677c("HuaweiCloudLogin_main", "LoginFACEBOOKCallback-->loginHWCloudChangeSTToAT");
        if (obj instanceof C2353b) {
            try {
                obj = (C2353b) obj;
            } catch (TypeNotPresentException e) {
                C2538c.m12680e("HuaweiCloudLogin_main", "LoginFACEBOOKCallback error " + e.getMessage());
                obj = null;
            }
            C2354d.m11954e(this.f8530a, obj, this.f8531b);
            return;
        }
        this.f8531b.mo2656a(6, "type error");
    }

    public void mo2656a(int i, String str) {
        this.f8531b.mo2656a(i, str);
    }
}
