package com.huawei.cp3.widget.custom.p384a;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HwDialogCustom */
class C4375b implements OnClickListener {
    final /* synthetic */ DialogInterface.OnClickListener f16245a;
    final /* synthetic */ C4374a f16246b;

    C4375b(C4374a c4374a, DialogInterface.OnClickListener onClickListener) {
        this.f16246b = c4374a;
        this.f16245a = onClickListener;
    }

    public void onClick(View view) {
        if (!this.f16246b.f16240k) {
            this.f16246b.dismiss();
        }
        if (this.f16245a != null) {
            this.f16245a.onClick(this.f16246b, -1);
        }
    }
}
