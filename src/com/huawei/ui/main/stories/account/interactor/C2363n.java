package com.huawei.ui.main.stories.account.interactor;

import android.os.AsyncTask;

/* compiled from: QQ */
class C2363n extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String f8542a;
    final /* synthetic */ String f8543b;
    final /* synthetic */ C2362m f8544c;

    C2363n(C2362m c2362m, String str, String str2) {
        this.f8544c = c2362m;
        this.f8542a = str;
        this.f8543b = str2;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11974a((Void[]) objArr);
    }

    protected Void m11974a(Void... voidArr) {
        String a = this.f8544c.f8541a.m11966a(this.f8544c.f8541a.f8535b, this.f8542a, this.f8543b, "QQ");
        if (this.f8544c.f8541a.f8536c != null) {
            this.f8544c.f8541a.f8536c.mo2654a(0, this.f8542a, this.f8543b, a, -1);
        }
        return null;
    }
}
