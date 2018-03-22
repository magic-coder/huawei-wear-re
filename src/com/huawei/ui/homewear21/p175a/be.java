package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class be implements OnClickListener {
    final /* synthetic */ bd f8076a;

    be(bd bdVar) {
        this.f8076a = bdVar;
    }

    public void onClick(View view) {
        C2538c.m12677c("HomeFragment", "guideToHealth enter cancle");
        this.f8076a.f8075a.aL.dismiss();
        this.f8076a.f8075a.aL = null;
    }
}
