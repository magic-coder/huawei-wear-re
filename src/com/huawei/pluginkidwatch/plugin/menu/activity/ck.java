package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ContactsListActivity */
class ck implements OnClickListener {
    final /* synthetic */ ContactsListActivity f6001a;

    ck(ContactsListActivity contactsListActivity) {
        this.f6001a = contactsListActivity;
    }

    public void onClick(View view) {
        this.f6001a.f5580D.dismiss();
        this.f6001a.f5581E.dismiss();
    }
}
