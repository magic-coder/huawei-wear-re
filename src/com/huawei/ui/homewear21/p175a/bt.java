package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.homewear21.card.p176a.C2243a;

/* compiled from: HomeFragment */
class bt implements OnClickListener {
    final /* synthetic */ C2217a f8093a;

    bt(C2217a c2217a) {
        this.f8093a = c2217a;
    }

    public void onClick(View view) {
        if (C2243a.m11601a() != null && C2243a.m11601a().m11618g()) {
            C2243a.m11601a().m11611a(false);
        }
        if (this.f8093a.be != null) {
            this.f8093a.be.dismiss();
            this.f8093a.be = null;
        }
    }
}
