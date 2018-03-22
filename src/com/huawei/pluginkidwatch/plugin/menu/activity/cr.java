package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class cr implements OnClickListener {
    final /* synthetic */ ContactsListActivity f6012a;

    cr(ContactsListActivity contactsListActivity) {
        this.f6012a = contactsListActivity;
    }

    public void onClick(View view) {
        this.f6012a.m9210a(this.f6012a.f5579C);
        this.f6012a.mo2518d();
        C1506g.m6978a(this.f6012a, this.f6012a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_deleting), false);
    }
}
