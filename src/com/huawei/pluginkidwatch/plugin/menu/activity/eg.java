package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: GeneralSettingsActivity */
class eg implements OnClickListener {
    final /* synthetic */ GeneralSettingsActivity f6075a;

    eg(GeneralSettingsActivity generalSettingsActivity) {
        this.f6075a = generalSettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww======选择高德地图 ");
        if (C1483c.m6826a(this.f6075a.getApplication(), "com.autonavi.minimap")) {
            C1491k.m6895a(this.f6075a.f5733b, "save_navigation_map", 1);
            this.f6075a.f5752u.setChecked(true);
            this.f6075a.f5753v.setChecked(false);
            this.f6075a.f5741j.notifyDataSetChanged();
        } else {
            this.f6075a.f5752u.setChecked(false);
            this.f6075a.f5753v.setChecked(false);
            C1491k.m6895a(this.f6075a.f5733b, "save_navigation_map", 5);
            C1483c.m6828b(this.f6075a.f5733b, C1680l.IDS_plugin_kidwatch_menu_relation_navigation_no_gaodemap_content);
        }
        this.f6075a.m9385a(this.f6075a.f5755x);
        this.f6075a.f5748q.dismiss();
    }
}
