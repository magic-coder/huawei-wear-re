package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: GeneralSettingsActivity */
class en implements OnClickListener {
    final /* synthetic */ GeneralSettingsActivity f6083a;

    en(GeneralSettingsActivity generalSettingsActivity) {
        this.f6083a = generalSettingsActivity;
    }

    public void onClick(View view) {
        this.f6083a.f5739h.cancel();
        this.f6083a.f5739h = null;
        C1506g.m6978a(this.f6083a.f5733b, this.f6083a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_reseting), false);
        this.f6083a.f5746o.postDelayed(this.f6083a.f5757z, 2000);
    }
}
