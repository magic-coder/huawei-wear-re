package com.huawei.ui.main.stories.account.interactor;

import android.content.Context;
import android.os.AsyncTask;

/* compiled from: HuaweiCloudLogin */
final class C2357g extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ C2353b f8527a;
    final /* synthetic */ Context f8528b;
    final /* synthetic */ C2344c f8529c;

    C2357g(C2353b c2353b, Context context, C2344c c2344c) {
        this.f8527a = c2353b;
        this.f8528b = context;
        this.f8529c = c2344c;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11958a((Void[]) objArr);
    }

    protected Void m11958a(Void... voidArr) {
        return C2354d.m11946a(this.f8528b, this.f8529c, this.f8527a.m11942e(), this.f8527a.m11943f(), this.f8527a.m11940d(), this.f8527a.m11931a());
    }
}
