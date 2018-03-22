package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CropImage */
class C1548i implements OnClickListener {
    final /* synthetic */ CropImage f3703a;

    C1548i(CropImage cropImage) {
        this.f3703a = cropImage;
    }

    public void onClick(View view) {
        this.f3703a.f3666q = C1562y.m7178a(this.f3703a.f3666q, 90.0f);
        this.f3703a.f3664o.mo2536a(new C1561x(this.f3703a.f3666q), true);
        this.f3703a.f3653d.run();
    }
}
