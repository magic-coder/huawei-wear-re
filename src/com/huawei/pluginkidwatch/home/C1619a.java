package com.huawei.pluginkidwatch.home;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;

/* compiled from: HomeActivity */
class C1619a implements OnGlobalLayoutListener {
    final /* synthetic */ HomeActivity f4161a;

    C1619a(HomeActivity homeActivity) {
        this.f4161a = homeActivity;
    }

    public void onGlobalLayout() {
        this.f4161a.f4120Q.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.f4161a.f4120Q.setHeight(50);
        C2538c.m12674b("KIDWATCH_HomeActivity", "==== btnCall.getWidth():" + this.f4161a.f4120Q.getWidth());
        this.f4161a.f4111H = (LinearLayout) this.f4161a.findViewById(g.main_liner_bottom_nav);
        this.f4161a.f4112I = (LinearLayout) this.f4161a.findViewById(g.main_liner_bottom_nav_tips);
        this.f4161a.f4113J = (LinearLayout) this.f4161a.findViewById(g.main_liner_bottom_nav_tips_k2);
        LayoutParams layoutParams = this.f4161a.f4111H.getLayoutParams();
        layoutParams.height = this.f4161a.f4120Q.getWidth();
        this.f4161a.f4111H.setLayoutParams(layoutParams);
        this.f4161a.f4112I.getLayoutParams().height = this.f4161a.f4120Q.getWidth();
        this.f4161a.f4112I.getLayoutParams().height = this.f4161a.f4120Q.getWidth();
        this.f4161a.f4112I.setLayoutParams(layoutParams);
        this.f4161a.f4113J.setLayoutParams(layoutParams);
    }
}
