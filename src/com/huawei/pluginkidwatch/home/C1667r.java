package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: HomeActivity */
class C1667r implements OnClickListener {
    final /* synthetic */ HomeActivity f4365a;

    C1667r(HomeActivity homeActivity) {
        this.f4365a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4365a.bs = true;
        this.f4365a.bh.enable();
    }
}
