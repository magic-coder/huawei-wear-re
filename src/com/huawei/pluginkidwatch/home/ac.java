package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class ac implements OnClickListener {
    final /* synthetic */ HomeActivity f4165a;

    ac(HomeActivity homeActivity) {
        this.f4165a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter setNegativeButton");
        this.f4165a.bc.dismiss();
    }
}
