package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bf implements OnClickListener {
    final /* synthetic */ bd f8077a;

    bf(bd bdVar) {
        this.f8077a = bdVar;
    }

    public void onClick(View view) {
        C2538c.m12677c("HomeFragment", "guideToHealth showunBindDialog onclick");
        this.f8077a.f8075a.m11410M();
        this.f8077a.f8075a.aL.dismiss();
        this.f8077a.f8075a.aL = null;
    }
}
