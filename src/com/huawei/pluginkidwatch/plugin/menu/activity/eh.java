package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;

/* compiled from: GeneralSettingsActivity */
class eh implements OnClickListener {
    final /* synthetic */ GeneralSettingsActivity f6076a;

    eh(GeneralSettingsActivity generalSettingsActivity) {
        this.f6076a = generalSettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww======点击百度地图 ");
        if (C1483c.m6826a(this.f6076a.getApplication(), "com.baidu.BaiduMap")) {
            C1491k.m6895a(this.f6076a.f5733b, "save_navigation_map", 2);
            this.f6076a.f5752u.setChecked(false);
            this.f6076a.f5753v.setChecked(true);
            this.f6076a.f5741j.notifyDataSetChanged();
        } else {
            C1491k.m6895a(this.f6076a.f5733b, "save_navigation_map", 5);
            this.f6076a.f5752u.setChecked(false);
            this.f6076a.f5753v.setChecked(false);
            C1483c.m6828b(this.f6076a.f5733b, C1680l.IDS_plugin_kidwatch_menu_relation_navigation_no_baidumap_content);
        }
        this.f6076a.m9385a(this.f6076a.f5755x);
        this.f6076a.f5748q.dismiss();
    }
}
