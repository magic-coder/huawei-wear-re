package com.huawei.ui.device.activity.onelevelmenu;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: OneLevelMenuManagerActivity */
class C2111g implements OnClickListener {
    final /* synthetic */ OneLevelMenuManagerActivity f7463a;

    C2111g(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7463a = oneLevelMenuManagerActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "showPromptSaveDialog() Yes ...");
        this.f7463a.f7452u.cancel();
        this.f7463a.m10891j();
        this.f7463a.finish();
    }
}
