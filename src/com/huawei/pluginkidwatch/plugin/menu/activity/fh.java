package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: PeroidActivity */
class fh implements OnClickListener {
    final /* synthetic */ PeroidActivity f6118a;

    fh(PeroidActivity peroidActivity) {
        this.f6118a = peroidActivity;
    }

    public void onClick(View view) {
        this.f6118a.m9482a(true);
        this.f6118a.f5804j.setVisibility(8);
        this.f6118a.f5802h.setText(this.f6118a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_peroid_get_data));
        this.f6118a.m9493e();
    }
}
