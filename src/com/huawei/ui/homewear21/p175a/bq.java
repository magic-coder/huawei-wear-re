package com.huawei.ui.homewear21.p175a;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: HomeFragment */
class bq implements OnScrollChangedListener {
    final /* synthetic */ C2217a f8090a;

    bq(C2217a c2217a) {
        this.f8090a = c2217a;
    }

    public void onScrollChanged() {
        int height = this.f8090a.f8030o.getHeight();
        if (height <= 0 || this.f8090a.f8008Q.getScrollY() < 0) {
            this.f8090a.f8031p.getBackground().setAlpha(0);
            return;
        }
        float scrollY = ((float) this.f8090a.f8008Q.getScrollY()) / ((float) height);
        if (scrollY > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            scrollY = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        this.f8090a.f8030o.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - Math.abs(scrollY));
        this.f8090a.f8031p.getBackground().setAlpha((int) (scrollY * 255.0f));
    }
}
