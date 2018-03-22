package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: AddContactActivity */
class C1879u implements Runnable {
    final /* synthetic */ AddContactActivity f6187a;

    private C1879u(AddContactActivity addContactActivity) {
        this.f6187a = addContactActivity;
    }

    public void run() {
        C1506g.m6979b();
        this.f6187a.f5382B = true;
        C1483c.m6824a(this.f6187a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
    }
}
