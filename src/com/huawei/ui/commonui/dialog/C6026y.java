package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomTextAlertDialog */
class C6026y implements OnClickListener {
    final /* synthetic */ C6024w f20755a;

    C6026y(C6024w c6024w) {
        this.f20755a = c6024w;
    }

    public void onClick(View view) {
        if (this.f20755a.f20743a != null) {
            this.f20755a.f20743a.dismiss();
        }
        if (this.f20755a.f20752j != null) {
            this.f20755a.f20752j.onClick(view);
        }
    }
}
