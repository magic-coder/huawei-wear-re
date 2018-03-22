package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AddPeroidActivity */
class ap implements OnClickListener {
    final /* synthetic */ String f5936a;
    final /* synthetic */ AddPeroidActivity f5937b;

    ap(AddPeroidActivity addPeroidActivity, String str) {
        this.f5937b = addPeroidActivity;
        this.f5936a = str;
    }

    public void onClick(View view) {
        this.f5937b.f5485R.cancel();
        this.f5937b.f5485R = null;
        this.f5937b.f5481N = this.f5936a;
        this.f5937b.m9083a(this.f5936a);
    }
}
