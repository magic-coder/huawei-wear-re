package com.huawei.ui.main.stories.nps.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NPSDialogActivity */
class C2430e implements OnClickListener {
    final /* synthetic */ NPSDialogActivity f8761a;

    C2430e(NPSDialogActivity nPSDialogActivity) {
        this.f8761a = nPSDialogActivity;
    }

    public void onClick(View view) {
        this.f8761a.finish();
        if (this.f8761a.f8719b.m12210e() != null) {
            this.f8761a.f8719b.m12210e().onClick(view);
        }
    }
}
