package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AlarmActivity */
class bd implements OnClickListener {
    final /* synthetic */ int f5958a;
    final /* synthetic */ AlarmActivity f5959b;

    bd(AlarmActivity alarmActivity, int i) {
        this.f5959b = alarmActivity;
        this.f5958a = i;
    }

    public void onClick(View view) {
        this.f5959b.m9113a(this.f5958a);
        this.f5959b.m9116a(this.f5959b.f5512c);
    }
}
