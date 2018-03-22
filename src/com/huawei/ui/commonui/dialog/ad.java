package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomViewDialog */
class ad implements OnClickListener {
    final /* synthetic */ ab f20632a;

    ad(ab abVar) {
        this.f20632a = abVar;
    }

    public void onClick(View view) {
        if (this.f20632a.f20623a != null) {
            this.f20632a.f20623a.dismiss();
        }
        if (this.f20632a.f20629g != null) {
            this.f20632a.f20629g.onClick(view);
        }
    }
}
