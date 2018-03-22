package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class C1661p implements OnClickListener {
    final /* synthetic */ HomeActivity f4363a;

    C1661p(HomeActivity homeActivity) {
        this.f4363a = homeActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================Show Left slide Menu");
        this.f4363a.f4151x.setClickable(false);
        this.f4363a.m7550a(true);
    }
}
