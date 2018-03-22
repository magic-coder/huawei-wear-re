package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import java.util.List;

/* compiled from: ContactsListActivity */
class ci extends AsyncTask<String, Void, Void> {
    final /* synthetic */ List f5998a;
    final /* synthetic */ ContactsListActivity f5999b;

    ci(ContactsListActivity contactsListActivity, List list) {
        this.f5999b = contactsListActivity;
        this.f5998a = list;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9587a((String[]) objArr);
    }

    protected Void m9587a(String... strArr) {
        this.f5999b.m9226b(this.f5998a);
        return null;
    }
}
