package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactInfoActivity */
class bw extends Handler {
    final /* synthetic */ ContactInfoActivity f5983a;

    private bw(ContactInfoActivity contactInfoActivity) {
        this.f5983a = contactInfoActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 5:
                if (!this.f5983a.f5542O) {
                    this.f5983a.m9150b(this.f5983a.f5533F);
                    return;
                }
                return;
            case 11:
                C1506g.m6979b();
                return;
            case 56:
                C1506g.m6979b();
                C1483c.m6824a(this.f5983a, C1680l.IDS_plugin_kidwatch_menu_option_failed);
                return;
            default:
                return;
        }
    }
}
