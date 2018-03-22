package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NoTitleCustomAlertDialog */
class am implements OnClickListener {
    final /* synthetic */ ak f20653a;

    am(ak akVar) {
        this.f20653a = akVar;
    }

    public void onClick(View view) {
        if (this.f20653a.f20642a != null) {
            this.f20653a.f20642a.dismiss();
        }
        if (this.f20653a.f20650i != null) {
            this.f20653a.f20650i.onClick(view);
        }
    }
}
