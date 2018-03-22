package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class C2241y implements OnClickListener {
    final /* synthetic */ C2217a f8157a;

    C2241y(C2217a c2217a) {
        this.f8157a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12674b("HomeFragment", "showLoginFail cancel click");
        this.f8157a.aq.dismiss();
        this.f8157a.aq = null;
    }
}
