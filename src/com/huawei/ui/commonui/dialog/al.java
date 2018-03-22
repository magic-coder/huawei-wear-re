package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NoTitleCustomAlertDialog */
class al implements OnClickListener {
    final /* synthetic */ ak f20652a;

    al(ak akVar) {
        this.f20652a = akVar;
    }

    public void onClick(View view) {
        if (this.f20652a.f20642a != null) {
            this.f20652a.f20642a.dismiss();
        }
        if (this.f20652a.f20651j != null) {
            this.f20652a.f20651j.onClick(view);
        }
    }
}
