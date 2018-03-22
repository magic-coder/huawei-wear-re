package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomSingleChoiceDialog */
class C6014m implements OnClickListener {
    final /* synthetic */ C6011j f20724a;
    final /* synthetic */ C6013l f20725b;

    C6014m(C6013l c6013l, C6011j c6011j) {
        this.f20725b = c6013l;
        this.f20724a = c6011j;
    }

    public void onClick(View view) {
        this.f20725b.f20718f.onClick(this.f20724a, -1);
        this.f20724a.dismiss();
    }
}
