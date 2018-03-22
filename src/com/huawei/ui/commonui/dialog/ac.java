package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomViewDialog */
class ac implements OnClickListener {
    final /* synthetic */ ab f20631a;

    ac(ab abVar) {
        this.f20631a = abVar;
    }

    public void onClick(View view) {
        if (this.f20631a.f20623a != null) {
            this.f20631a.f20623a.dismiss();
        }
        if (this.f20631a.f20630h != null) {
            this.f20631a.f20630h.onClick(view);
        }
    }
}
