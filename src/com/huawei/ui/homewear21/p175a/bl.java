package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdatamigrate.hihealth.f.b;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bl implements OnClickListener {
    final /* synthetic */ b f8083a;
    final /* synthetic */ C2217a f8084b;

    bl(C2217a c2217a, b bVar) {
        this.f8084b = c2217a;
        this.f8083a = bVar;
    }

    public void onClick(View view) {
        this.f8084b.bt();
        C0996a.m3611a(this.f8084b.f8041z, String.valueOf(10000), "key_allowed_with_3G", "true", null);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "allows sync in 3G");
        this.f8083a.a();
    }
}
