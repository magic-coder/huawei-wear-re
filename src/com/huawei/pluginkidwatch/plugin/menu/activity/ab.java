package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: AddFenceActivity */
class ab implements Runnable {
    final /* synthetic */ AddFenceActivity f5922a;

    ab(AddFenceActivity addFenceActivity) {
        this.f5922a = addFenceActivity;
    }

    public void run() {
        this.f5922a.m9045g();
        C1483c.m6828b(this.f5922a.f5418C, C1680l.f4387xf0551154);
        C2538c.m12674b("AddFenceActivity", "==========网络定位超时");
    }
}
