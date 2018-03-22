package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ElectronicFenceActivity */
class dq implements OnClickListener {
    final /* synthetic */ int f6046a;
    final /* synthetic */ String f6047b;
    final /* synthetic */ ElectronicFenceActivity f6048c;

    dq(ElectronicFenceActivity electronicFenceActivity, int i, String str) {
        this.f6048c = electronicFenceActivity;
        this.f6046a = i;
        this.f6047b = str;
    }

    public void onClick(View view) {
        this.f6048c.m9357b(this.f6046a, this.f6047b);
        this.f6048c.m9349a(this.f6048c.f5715k);
    }
}
