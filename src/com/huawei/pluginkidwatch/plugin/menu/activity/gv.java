package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: TailorContactActivity */
class gv implements Runnable {
    final /* synthetic */ TailorContactActivity f6168a;

    private gv(TailorContactActivity tailorContactActivity) {
        this.f6168a = tailorContactActivity;
    }

    public void run() {
        C1506g.m6979b();
        this.f6168a.f5882H = true;
        C1483c.m6824a(this.f6168a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
    }
}
