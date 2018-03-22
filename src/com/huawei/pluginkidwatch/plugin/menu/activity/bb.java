package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AlarmActivity */
class bb implements OnClickListener {
    final /* synthetic */ int f5955a;
    final /* synthetic */ ba f5956b;

    bb(ba baVar, int i) {
        this.f5956b = baVar;
        this.f5955a = i;
    }

    public void onClick(View view) {
        this.f5956b.f5954a.f5511b.cancel();
        this.f5956b.f5954a.m9124b(this.f5955a);
    }
}
