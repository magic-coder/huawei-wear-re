package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomMultiChoiceDialog */
class C1844o implements OnClickListener {
    final /* synthetic */ C1841l f5310a;
    final /* synthetic */ C1843n f5311b;

    C1844o(C1843n c1843n, C1841l c1841l) {
        this.f5311b = c1843n;
        this.f5310a = c1841l;
    }

    public void onClick(View view) {
        this.f5311b.f5303h.onClick(this.f5310a, -1);
        this.f5310a.dismiss();
    }
}
