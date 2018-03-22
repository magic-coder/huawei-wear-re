package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TailorContactActivity */
class gs implements OnClickListener {
    final /* synthetic */ gq f6162a;

    gs(gq gqVar) {
        this.f6162a = gqVar;
    }

    public void onClick(View view) {
        this.f6162a.f6160a.f5879E = "0";
        this.f6162a.f6160a.f5904k.cancel();
        this.f6162a.f6160a.f5904k = null;
        this.f6162a.f6160a.finish();
    }
}
