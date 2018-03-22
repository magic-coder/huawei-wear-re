package com.google.android.gms.internal;

import android.support.annotation.BinderThread;
import java.lang.ref.WeakReference;

class ap extends dp {
    private final WeakReference<ai> f562a;

    ap(ai aiVar) {
        this.f562a = new WeakReference(aiVar);
    }

    @BinderThread
    public void mo1826a(zzbaw com_google_android_gms_internal_zzbaw) {
        ai aiVar = (ai) this.f562a.get();
        if (aiVar != null) {
            aiVar.f529a.m1623a(new aq(this, aiVar, aiVar, com_google_android_gms_internal_zzbaw));
        }
    }
}
