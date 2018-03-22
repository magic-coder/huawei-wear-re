package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class C2233q implements OnClickListener {
    final /* synthetic */ C2217a f8147a;

    C2233q(C2217a c2217a) {
        this.f8147a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12674b("HomeFragment", "notification cancel click");
        this.f8147a.m11487b(bz.NOTIFICATION);
    }
}
