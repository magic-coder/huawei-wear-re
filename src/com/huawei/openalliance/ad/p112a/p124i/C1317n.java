package com.huawei.openalliance.ad.p112a.p124i;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

class C1317n implements OnTouchListener {
    final /* synthetic */ C1221g f2852a;
    final /* synthetic */ ImageView f2853b;
    final /* synthetic */ C1315l f2854c;

    C1317n(C1315l c1315l, C1221g c1221g, ImageView imageView) {
        this.f2854c = c1315l;
        this.f2852a = c1221g;
        this.f2853b = imageView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2854c.setOnTouchListener(null);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            C1336d.m5884a("SplashView", "touch down image x=" + rawX + ", y=" + rawY);
            view.setClickable(false);
            if (1 == this.f2852a.getInteractiontype__() && C1287e.m5683a(this.f2854c.f2847f)) {
                this.f2854c.m5829b(C1365i.m6078a(this.f2852a.getHtml__(), "a", "href"), this.f2853b, (int) rawX, (int) rawY);
            } else if (3 == this.f2852a.getInteractiontype__() && this.f2852a.getInteractionparam__() != null) {
                this.f2854c.m5826a(this.f2852a.getInteractionparam__().getIntentUri__(), this.f2853b, (int) rawX, (int) rawY);
            }
        }
        return true;
    }
}
