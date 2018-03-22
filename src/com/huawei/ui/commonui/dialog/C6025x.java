package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomTextAlertDialog */
class C6025x implements OnClickListener {
    final /* synthetic */ C6024w f20754a;

    C6025x(C6024w c6024w) {
        this.f20754a = c6024w;
    }

    public void onClick(View view) {
        if (this.f20754a.f20743a != null) {
            this.f20754a.f20743a.dismiss();
        }
        if (this.f20754a.f20753k != null) {
            this.f20754a.f20753k.onClick(view);
        }
    }
}
