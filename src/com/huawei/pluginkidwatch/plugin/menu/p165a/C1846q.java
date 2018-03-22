package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomMultiChoiceDialog */
class C1846q implements OnClickListener {
    final /* synthetic */ C1841l f5314a;
    final /* synthetic */ C1843n f5315b;

    C1846q(C1843n c1843n, C1841l c1841l) {
        this.f5315b = c1843n;
        this.f5314a = c1841l;
    }

    public void onClick(View view) {
        this.f5315b.f5304i.onClick(this.f5314a, -2);
        if (this.f5315b.f5309n) {
            this.f5314a.dismiss();
        }
    }
}
