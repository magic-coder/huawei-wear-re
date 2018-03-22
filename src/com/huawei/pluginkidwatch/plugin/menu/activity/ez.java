package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import com.huawei.pluginkidwatch.common.entity.model.ImportContact;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1905w;
import java.util.Iterator;

/* compiled from: ImportContactActivity */
class ez extends AsyncTask<String, Void, Void> {
    final /* synthetic */ ex f6108a;

    ez(ex exVar) {
        this.f6108a = exVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9614a((String[]) objArr);
    }

    protected Void m9614a(String... strArr) {
        this.f6108a.f6105a.f5768k.clear();
        Iterator it = this.f6108a.f6105a.f5766i.iterator();
        while (it.hasNext()) {
            ImportContact importContact = (ImportContact) it.next();
            if (C1905w.m9689b(importContact.getName()).startsWith(this.f6108a.f6106b.toLowerCase()) || C1905w.m9690c(importContact.getName()).contains(this.f6108a.f6106b.toLowerCase())) {
                this.f6108a.f6105a.f5768k.add(importContact);
            }
        }
        this.f6108a.f6105a.f5770m.sendEmptyMessage(7);
        return null;
    }
}
