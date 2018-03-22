package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ElectronicFenceActivity */
class dx implements OnClickListener {
    final /* synthetic */ ElectronicFenceActivity f6060a;

    dx(ElectronicFenceActivity electronicFenceActivity) {
        this.f6060a = electronicFenceActivity;
    }

    public void onClick(View view) {
        if (this.f6060a.f5718n == 1) {
            this.f6060a.m9367g();
        } else {
            this.f6060a.onBackPressed();
        }
    }
}
