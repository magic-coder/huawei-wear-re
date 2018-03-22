package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class ab implements OnClickListener {
    final /* synthetic */ HomeActivity f4164a;

    ab(HomeActivity homeActivity) {
        this.f4164a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter setPositiveButton");
        this.f4164a.bc.dismiss();
        this.f4164a.f4131c.post(this.f4164a.cs);
        this.f4164a.af();
    }
}
