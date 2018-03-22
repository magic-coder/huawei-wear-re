package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactInfoActivity */
class bx implements Runnable {
    final /* synthetic */ ContactInfoActivity f5984a;

    private bx(ContactInfoActivity contactInfoActivity) {
        this.f5984a = contactInfoActivity;
    }

    public void run() {
        C1506g.m6979b();
        this.f5984a.f5542O = true;
        C1483c.m6824a(this.f5984a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
    }
}
