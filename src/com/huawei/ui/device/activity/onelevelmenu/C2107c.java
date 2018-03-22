package com.huawei.ui.device.activity.onelevelmenu;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: OneLevelMenuManagerActivity */
class C2107c implements OnClickListener {
    final /* synthetic */ OneLevelMenuManagerActivity f7459a;

    C2107c(OneLevelMenuManagerActivity oneLevelMenuManagerActivity) {
        this.f7459a = oneLevelMenuManagerActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123====setRightButtonOnClickListener 右键点击响应");
        if (!this.f7459a.f7437f.m10311b()) {
            this.f7459a.m10887h();
            this.f7459a.finish();
        }
    }
}
