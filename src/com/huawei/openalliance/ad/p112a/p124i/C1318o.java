package com.huawei.openalliance.ad.p112a.p124i;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.huawei.openalliance.ad.p112a.p124i.p126a.C1297d;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

class C1318o implements OnTouchListener {
    final /* synthetic */ ImageView f2855a;
    final /* synthetic */ C1315l f2856b;

    C1318o(C1315l c1315l, ImageView imageView) {
        this.f2856b = c1315l;
        this.f2855a = imageView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (motionEvent.getAction() == 0) {
            this.f2856b.setOnTouchListener(null);
            C1336d.m5884a("SplashView", "touch down jumpBtn x=" + rawX + ", y=" + rawY);
            view.setClickable(false);
            if (this.f2855a instanceof C1297d) {
                ((C1297d) this.f2855a).m5757b();
            }
            if (this.f2856b.f2845d != null) {
                this.f2856b.f2845d.onAdDismissed();
            }
            if (this.f2856b.f2846e != null) {
                this.f2856b.f2846e.mo2438b((int) rawX, (int) rawY);
            }
        }
        return true;
    }
}
