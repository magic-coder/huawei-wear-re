package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TailorContactActivity */
class gj implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6153a;

    gj(TailorContactActivity tailorContactActivity) {
        this.f6153a = tailorContactActivity;
    }

    public void onClick(View view) {
        this.f6153a.startActivity(new Intent(this.f6153a, ImportContactActivity.class));
    }
}
