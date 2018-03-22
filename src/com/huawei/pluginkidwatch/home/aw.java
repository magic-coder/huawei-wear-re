package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: HomeActivity */
class aw implements OnClickListener {
    final /* synthetic */ HomeActivity f4190a;

    aw(HomeActivity homeActivity) {
        this.f4190a = homeActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww======点击高德地图");
        if (C1483c.m6826a(this.f4190a.f4109F, "com.autonavi.minimap")) {
            this.f4190a.bX.setChecked(true);
            this.f4190a.bY.setChecked(false);
            this.f4190a.az();
            C1491k.m6895a(this.f4190a.f4109F, "save_navigation_map", 1);
        } else {
            this.f4190a.bX.setChecked(false);
            this.f4190a.bY.setChecked(false);
            C1491k.m6895a(this.f4190a.f4109F, "save_navigation_map", 5);
            C1483c.m6828b(this.f4190a.f4109F, C1680l.IDS_plugin_kidwatch_menu_relation_navigation_no_gaodemap_content);
        }
        this.f4190a.bT.dismiss();
    }
}
