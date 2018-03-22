package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.homewear21.card.p176a.C2243a;

/* compiled from: HomeFragment */
class bs implements OnClickListener {
    final /* synthetic */ C2217a f8092a;

    bs(C2217a c2217a) {
        this.f8092a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showOpenSystemBluetoothDialog 3333 !!!");
        if (C2243a.m11601a() != null && !C2243a.m11601a().m11618g()) {
            C2243a.m11601a().m11611a(true);
        }
    }
}
