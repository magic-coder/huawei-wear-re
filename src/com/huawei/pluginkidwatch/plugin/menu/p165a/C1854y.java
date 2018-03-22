package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomSingleChoiceDialog */
class C1854y implements OnClickListener {
    final /* synthetic */ C1851v f5336a;
    final /* synthetic */ C1853x f5337b;

    C1854y(C1853x c1853x, C1851v c1851v) {
        this.f5337b = c1853x;
        this.f5336a = c1851v;
    }

    public void onClick(View view) {
        this.f5337b.f5331g.onClick(this.f5336a, -2);
        this.f5336a.dismiss();
    }
}
