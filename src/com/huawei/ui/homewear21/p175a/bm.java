package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bm implements OnClickListener {
    final /* synthetic */ C2217a f8085a;

    bm(C2217a c2217a) {
        this.f8085a = c2217a;
    }

    public void onClick(View view) {
        this.f8085a.bt();
        C0996a.m3611a(this.f8085a.f8041z, String.valueOf(10000), "key_allowed_with_3G", "false", null);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "not allowed sync in 3G");
    }
}
