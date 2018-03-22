package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CropImage */
class C1545f implements OnClickListener {
    final /* synthetic */ CropImage f3700a;

    C1545f(CropImage cropImage) {
        this.f3700a = cropImage;
    }

    public void onClick(View view) {
        this.f3700a.setResult(0);
        this.f3700a.finish();
    }
}
