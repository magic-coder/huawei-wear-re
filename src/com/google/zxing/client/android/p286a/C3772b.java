package com.google.zxing.client.android.p286a;

import android.os.AsyncTask;

/* compiled from: AutoFocusManager */
final class C3772b extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ C3771a f14690a;

    private C3772b(C3771a c3771a) {
        this.f14690a = c3771a;
    }

    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        synchronized (this.f14690a) {
            if (this.f14690a.f14685c) {
                this.f14690a.m18975a();
            }
        }
        return null;
    }
}
