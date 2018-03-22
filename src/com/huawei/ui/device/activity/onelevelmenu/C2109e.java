package com.huawei.ui.device.activity.onelevelmenu;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: OneLevelMenuManagerActivity */
class C2109e implements OnClickListener {
    final /* synthetic */ OneLevelMenuManagerActivity f7461a;

    C2109e(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7461a = oneLevelMenuManagerActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "====123===retry");
        this.f7461a.f7454w.sendEmptyMessage(2);
        this.f7461a.f7454w.sendEmptyMessageDelayed(3, 5000);
        this.f7461a.m10894k();
    }
}
