package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class cv implements Runnable {
    final /* synthetic */ ContactsListActivity f6016a;

    private cv(ContactsListActivity contactsListActivity) {
        this.f6016a = contactsListActivity;
    }

    public void run() {
        C2538c.m12674b("ContactsListActivity", "==ww== MyRunnable timeout closeDialog");
        C1506g.m6979b();
        C1483c.m6824a(this.f6016a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
    }
}
