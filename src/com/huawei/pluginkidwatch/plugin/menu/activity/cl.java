package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ContactsListActivity */
class cl implements OnClickListener {
    final /* synthetic */ int f6002a;
    final /* synthetic */ UserInfo f6003b;
    final /* synthetic */ ContactsListActivity f6004c;

    cl(ContactsListActivity contactsListActivity, int i, UserInfo userInfo) {
        this.f6004c = contactsListActivity;
        this.f6002a = i;
        this.f6003b = userInfo;
    }

    public void onClick(View view) {
        if (this.f6002a == this.f6004c.f5603b) {
            this.f6004c.m9209a(this.f6003b);
        } else if (this.f6002a == this.f6004c.f5604c) {
            this.f6004c.m9222b(this.f6003b);
        } else {
            C1483c.m6824a(this.f6004c, C1680l.IDS_plugin_kidwatch_common_process_failed);
        }
        this.f6004c.f5580D.dismiss();
        this.f6004c.f5581E.dismiss();
    }
}
