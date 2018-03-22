package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: ElectronicFenceActivity */
class dy implements OnClickListener {
    final /* synthetic */ ElectronicFenceActivity f6061a;

    dy(ElectronicFenceActivity electronicFenceActivity) {
        this.f6061a = electronicFenceActivity;
    }

    public void onClick(View view) {
        this.f6061a.f5722r.setVisibility(8);
        this.f6061a.f5720p.setText(this.f6061a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_loading));
        this.f6061a.m9364e();
    }
}
