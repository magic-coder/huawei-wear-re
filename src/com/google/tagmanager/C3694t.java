package com.google.tagmanager;

import android.util.Log;

/* compiled from: DefaultLogger */
class C3694t implements aa {
    private ab f14356a = ab.WARNING;

    C3694t() {
    }

    public void mo4296a(String str) {
        if (this.f14356a.ordinal() <= ab.ERROR.ordinal()) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void mo4297a(String str, Throwable th) {
        if (this.f14356a.ordinal() <= ab.ERROR.ordinal()) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void mo4298b(String str) {
        if (this.f14356a.ordinal() <= ab.WARNING.ordinal()) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void mo4299c(String str) {
        if (this.f14356a.ordinal() <= ab.INFO.ordinal()) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void mo4300d(String str) {
        if (this.f14356a.ordinal() <= ab.VERBOSE.ordinal()) {
            Log.v("GoogleTagManager", str);
        }
    }
}
