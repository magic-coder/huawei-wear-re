package com.huawei.cp3.widget.custom.p384a;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HwDialogCustom */
class C4376c implements OnClickListener {
    final /* synthetic */ DialogInterface.OnClickListener f16247a;
    final /* synthetic */ C4374a f16248b;

    C4376c(C4374a c4374a, DialogInterface.OnClickListener onClickListener) {
        this.f16248b = c4374a;
        this.f16247a = onClickListener;
    }

    public void onClick(View view) {
        if (!this.f16248b.f16240k) {
            this.f16248b.dismiss();
        }
        if (this.f16247a != null) {
            this.f16247a.onClick(this.f16248b, -2);
        }
    }
}
