package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HomeFragment */
class C2230n implements OnClickListener {
    final /* synthetic */ C2217a f8144a;

    C2230n(C2217a c2217a) {
        this.f8144a = c2217a;
    }

    public void onClick(View view) {
        if (this.f8144a.bu != null) {
            this.f8144a.bu.removeMessages(24);
            this.f8144a.bu.sendEmptyMessage(24);
        }
    }
}
