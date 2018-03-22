package com.huawei.ui.device.activity.onelevelmenu;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OneLevelMenuManagerActivity */
class C2110f implements OnClickListener {
    final /* synthetic */ OneLevelMenuManagerActivity f7462a;

    C2110f(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7462a = oneLevelMenuManagerActivity;
    }

    public void onClick(View view) {
        this.f7462a.f7452u.cancel();
        this.f7462a.finish();
    }
}
