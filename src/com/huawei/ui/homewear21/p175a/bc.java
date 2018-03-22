package com.huawei.ui.homewear21.p175a;

import android.support.v4.view.GravityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;

/* compiled from: HomeFragment */
class bc implements OnClickListener {
    final /* synthetic */ C2217a f8074a;

    bc(C2217a c2217a) {
        this.f8074a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter leftDrawerClickListener --> onClick");
        if (C2217a.m11520n() == null || C2217a.m11522o() == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter leftDrawerClickListener --> onClick --> null");
        } else if (!C2217a.m11520n().isDrawerOpen(C2217a.m11522o())) {
            C2217a.m11520n().openDrawer((int) GravityCompat.START);
        }
        c.a().a(BaseApplication.m2632b(), a.cp.a(), new HashMap(), 0);
    }
}
