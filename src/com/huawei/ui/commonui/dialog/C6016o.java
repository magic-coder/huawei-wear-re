package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomSingleChoiceDialog */
class C6016o implements OnClickListener {
    final /* synthetic */ C6011j f20728a;
    final /* synthetic */ C6013l f20729b;

    C6016o(C6013l c6013l, C6011j c6011j) {
        this.f20729b = c6013l;
        this.f20728a = c6011j;
    }

    public void onClick(View view) {
        this.f20729b.f20719g.onClick(this.f20728a, -2);
        this.f20728a.dismiss();
    }
}
