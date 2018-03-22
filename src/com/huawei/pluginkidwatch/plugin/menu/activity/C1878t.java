package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: AddContactActivity */
class C1878t extends Handler {
    final /* synthetic */ AddContactActivity f6186a;

    C1878t(AddContactActivity addContactActivity) {
        this.f6186a = addContactActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 5:
                if (!this.f6186a.f5382B) {
                    this.f6186a.m8991b();
                    return;
                }
                return;
            case 56:
                this.f6186a.f5412w.removeCallbacks(this.f6186a.f5381A);
                C1506g.m6979b();
                C1483c.m6824a(this.f6186a, C1680l.IDS_plugin_kidwatch_menu_option_failed);
                return;
            default:
                return;
        }
    }
}
