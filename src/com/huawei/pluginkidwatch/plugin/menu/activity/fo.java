package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PeroidActivity */
class fo implements OnClickListener {
    final /* synthetic */ int f6127a;
    final /* synthetic */ fn f6128b;

    fo(fn fnVar, int i) {
        this.f6128b = fnVar;
        this.f6127a = i;
    }

    public void onClick(View view) {
        this.f6128b.f6126a.f5796b.cancel();
        this.f6128b.f6126a.m9484b(this.f6127a);
    }
}
