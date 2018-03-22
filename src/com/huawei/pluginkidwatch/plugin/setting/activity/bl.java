package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ProfileSettingActivity */
class bl implements Runnable {
    final /* synthetic */ ProfileSettingActivity f6633a;

    private bl(ProfileSettingActivity profileSettingActivity) {
        this.f6633a = profileSettingActivity;
    }

    public void run() {
        C1506g.m6979b();
        this.f6633a.f6394Z = true;
        C1483c.m6824a(this.f6633a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
    }
}
