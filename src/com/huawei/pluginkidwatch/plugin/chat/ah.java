package com.huawei.pluginkidwatch.plugin.chat;

import android.os.AsyncTask;
import java.util.List;

/* compiled from: ChatActivity */
class ah extends AsyncTask<String, Void, Void> {
    final /* synthetic */ List f4810a;
    final /* synthetic */ ChatActivity f4811b;

    ah(ChatActivity chatActivity, List list) {
        this.f4811b = chatActivity;
        this.f4810a = list;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8485a((String[]) objArr);
    }

    protected Void m8485a(String... strArr) {
        this.f4811b.m8413d(this.f4810a);
        return null;
    }
}
