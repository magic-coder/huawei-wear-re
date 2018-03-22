package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.C1680l;

/* compiled from: GeneralSettingsActivity */
class ec implements Runnable {
    final /* synthetic */ eb f6069a;

    ec(eb ebVar) {
        this.f6069a = ebVar;
    }

    public void run() {
        this.f6069a.f6068b.f5736e.setText(this.f6069a.f6068b.getResources().getString(C1680l.IDS_plugin_kidwatch_network_error_load_failed));
        this.f6069a.f6068b.m9393a(true);
    }
}
