package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ContactsListActivity */
class cj extends AsyncTask<String, Void, List<Contact>> {
    final /* synthetic */ ContactsListActivity f6000a;

    cj(ContactsListActivity contactsListActivity) {
        this.f6000a = contactsListActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9588a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9589a((List) obj);
    }

    protected List<Contact> m9588a(String... strArr) {
        C2538c.m12674b("ContactsListActivity", "==ww==== getContactFromDB ");
        this.f6000a.f5587K.clear();
        this.f6000a.f5587K = this.f6000a.f5585I.m6262a(C1462f.m6746j());
        if (this.f6000a.f5587K != null) {
            this.f6000a.f5587K = this.f6000a.m9235d(this.f6000a.f5587K);
            Collections.sort(this.f6000a.f5587K, this.f6000a.f5591O);
        } else {
            this.f6000a.f5587K = new ArrayList();
            C2538c.m12674b("ContactsListActivity", "====  mDbContactList is bad ===");
        }
        C2538c.m12674b("ContactsListActivity", "==ww ==  form db mContactNum --" + this.f6000a.f5605d);
        return this.f6000a.f5587K;
    }

    protected void m9589a(List<Contact> list) {
        super.onPostExecute(list);
        if (!this.f6000a.isFinishing()) {
            if (list == null || list.size() <= 0) {
                this.f6000a.f5588L.clear();
                this.f6000a.f5624w.notifyDataSetChanged();
                this.f6000a.f5605d = 0;
            } else {
                this.f6000a.f5588L.clear();
                this.f6000a.f5588L.addAll(list);
                this.f6000a.f5624w.notifyDataSetChanged();
                C2538c.m12674b("ContactsListActivity", "==ww ==  form db mContactNum --" + this.f6000a.f5605d);
            }
            this.f6000a.f5626y.sendEmptyMessage(6);
        }
    }
}
