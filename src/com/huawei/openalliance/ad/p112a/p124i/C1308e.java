package com.huawei.openalliance.ad.p112a.p124i;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;

class C1308e implements OnKeyListener {
    final /* synthetic */ C1307d f2830a;

    C1308e(C1307d c1307d) {
        this.f2830a = c1307d;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 4 || this.f2830a.f2817a == null || !this.f2830a.f2817a.canGoBack() || !C1287e.m5683a(this.f2830a.f2817a.getContext())) {
            return false;
        }
        this.f2830a.f2817a.goBack();
        return true;
    }
}
