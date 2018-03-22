package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class ay implements OnClickListener {
    final /* synthetic */ HomeActivity f4192a;

    ay(HomeActivity homeActivity) {
        this.f4192a = homeActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww======点击取消 ");
        this.f4192a.bT.dismiss();
    }
}
