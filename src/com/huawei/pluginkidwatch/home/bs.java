package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MenuFragment */
class bs implements OnClickListener {
    final /* synthetic */ bo f4325a;

    bs(bo boVar) {
        this.f4325a = boVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4325a.f4290J.cancel();
        this.f4325a.f4290J = null;
    }
}
