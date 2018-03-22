package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MenuFragment */
class bt implements OnClickListener {
    final /* synthetic */ bo f4326a;

    bt(bo boVar) {
        this.f4326a = boVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4326a.f4290J.cancel();
        this.f4326a.f4290J = null;
        this.f4326a.m7807h();
    }
}
