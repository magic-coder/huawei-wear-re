package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ContactsListActivity */
class cw extends BroadcastReceiver {
    final /* synthetic */ ContactsListActivity f6017a;

    cw(ContactsListActivity contactsListActivity) {
        this.f6017a = contactsListActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.huawei.pluginkidwatch.plugin.menu.manager".equals(intent.getAction())) {
            this.f6017a.m9244h();
        }
    }
}
