package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: TailorContactActivity */
class gh implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6151a;

    gh(TailorContactActivity tailorContactActivity) {
        this.f6151a = tailorContactActivity;
    }

    public void onClick(View view) {
        if ("".equals(this.f6151a.f5897d.getText().toString())) {
            C1483c.m6824a(this.f6151a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_tv_name_not_null);
        } else if ("".equals(this.f6151a.f5898e.getText().toString())) {
            C1483c.m6824a(this.f6151a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_tv_phonenumber_not_null);
        } else if (C1492l.m6917b(this.f6151a.f5897d.getText().toString().replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
            C1506g.m6978a(this.f6151a, this.f6151a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
            this.f6151a.f5882H = false;
            this.f6151a.f5877C.postDelayed(this.f6151a.f5881G, FileWatchdog.DEFAULT_DELAY);
            if (this.f6151a.f5879E.equals("7")) {
                new gi(this).execute(new String[0]);
            } else {
                this.f6151a.f5877C.sendEmptyMessage(11);
            }
        } else {
            C1483c.m6824a(this.f6151a, C1680l.IDS_plugin_kidwatch_common_illegal);
        }
    }
}
