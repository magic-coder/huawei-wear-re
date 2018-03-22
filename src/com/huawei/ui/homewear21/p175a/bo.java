package com.huawei.ui.homewear21.p175a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: HomeFragment */
class bo implements OnClickListener {
    final /* synthetic */ C2217a f8087a;

    bo(C2217a c2217a) {
        this.f8087a = c2217a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8087a.f8012U != null) {
            this.f8087a.f8012U.dismiss();
            this.f8087a.f8012U = null;
        }
        this.f8087a.m11487b(bz.RATE);
    }
}
