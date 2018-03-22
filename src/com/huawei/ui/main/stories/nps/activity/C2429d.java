package com.huawei.ui.main.stories.nps.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NPSDialogActivity */
class C2429d implements OnClickListener {
    final /* synthetic */ NPSDialogActivity f8760a;

    C2429d(NPSDialogActivity nPSDialogActivity) {
        this.f8760a = nPSDialogActivity;
    }

    public void onClick(View view) {
        this.f8760a.finish();
        if (this.f8760a.f8719b.m12212g() != null) {
            this.f8760a.f8719b.m12212g().onClick(view);
        }
    }
}
