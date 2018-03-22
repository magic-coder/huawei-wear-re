package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import com.huawei.pluginkidwatch.plugin.menu.view.C1857c;

/* compiled from: AddFenceActivity */
class ae implements C1857c {
    final /* synthetic */ AddFenceActivity f5925a;

    ae(AddFenceActivity addFenceActivity) {
        this.f5925a = addFenceActivity;
    }

    public void mo2618a(View view, boolean z) {
        if (true == z) {
            this.f5925a.f5451k.setVisibility(8);
            this.f5925a.f5452l.setVisibility(0);
            return;
        }
        this.f5925a.f5451k.setVisibility(0);
        this.f5925a.f5452l.setVisibility(8);
    }
}
