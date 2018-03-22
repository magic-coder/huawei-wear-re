package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: CropImage */
class C1546g implements OnClickListener {
    final /* synthetic */ CropImage f3701a;

    C1546g(CropImage cropImage) {
        this.f3701a = cropImage;
    }

    public void onClick(View view) {
        try {
            this.f3701a.m7095e();
        } catch (Exception e) {
            C2538c.m12680e("CropImage", "EXCEPTION E = " + e.getMessage());
            this.f3701a.finish();
        }
    }
}
