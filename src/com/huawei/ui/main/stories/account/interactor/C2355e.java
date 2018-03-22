package com.huawei.ui.main.stories.account.interactor;

import android.content.Context;
import android.os.AsyncTask;

/* compiled from: HuaweiCloudLogin */
final class C2355e extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Context f8521a;
    final /* synthetic */ C2353b f8522b;
    final /* synthetic */ C2344c f8523c;

    C2355e(Context context, C2353b c2353b, C2344c c2344c) {
        this.f8521a = context;
        this.f8522b = c2353b;
        this.f8523c = c2344c;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11956a((Void[]) objArr);
    }

    protected Void m11956a(Void... voidArr) {
        return C2354d.m11951b(this.f8521a, this.f8522b, this.f8523c);
    }
}
