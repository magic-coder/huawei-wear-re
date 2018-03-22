package com.huawei.ui.main.stories.account.interactor;

import android.content.Context;
import android.os.AsyncTask;

/* compiled from: HuaweiCloudLogin */
final class C2356f extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Context f8524a;
    final /* synthetic */ C2353b f8525b;
    final /* synthetic */ C2344c f8526c;

    C2356f(Context context, C2353b c2353b, C2344c c2344c) {
        this.f8524a = context;
        this.f8525b = c2353b;
        this.f8526c = c2344c;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11957a((Void[]) objArr);
    }

    protected Void m11957a(Void... voidArr) {
        return C2354d.m11952c(this.f8524a, this.f8525b, this.f8526c);
    }
}
