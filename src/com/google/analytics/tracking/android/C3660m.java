package com.google.analytics.tracking.android;

import android.util.Log;

/* compiled from: DefaultLoggerImpl */
class C3660m implements as {
    private at f14192a = at.INFO;

    C3660m() {
    }

    public void mo4256a(String str) {
        if (this.f14192a.ordinal() <= at.VERBOSE.ordinal()) {
            Log.v("GAV3", m18367e(str));
        }
    }

    public void mo4257b(String str) {
        if (this.f14192a.ordinal() <= at.INFO.ordinal()) {
            Log.i("GAV3", m18367e(str));
        }
    }

    public void mo4258c(String str) {
        if (this.f14192a.ordinal() <= at.WARNING.ordinal()) {
            Log.w("GAV3", m18367e(str));
        }
    }

    public void mo4259d(String str) {
        if (this.f14192a.ordinal() <= at.ERROR.ordinal()) {
            Log.e("GAV3", m18367e(str));
        }
    }

    public void mo4255a(at atVar) {
        this.f14192a = atVar;
    }

    public at mo4254a() {
        return this.f14192a;
    }

    private String m18367e(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }
}
