package com.huawei.pluginkidwatch.home.p156b;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: CheckNewVersionUtils */
class C1637q implements Runnable {
    final /* synthetic */ C1624d f4248a;

    private C1637q(C1624d c1624d) {
        this.f4248a = c1624d;
    }

    public void run() {
        if (this.f4248a.f4218q != null) {
            this.f4248a.f4218q.m9666a();
        }
        this.f4248a.f4213j = true;
        C1483c.m6824a(this.f4248a.f4215n, C1680l.IDS_plugin_kidwatch_menu_check_new_version_timeout);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww===mLoadingDialog.closeLoadingDialog()postDelayed==timeout");
    }
}
