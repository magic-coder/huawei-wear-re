package com.google.android.gms.internal;

import android.app.Dialog;

class C0506l extends bi {
    final /* synthetic */ Dialog f801a;
    final /* synthetic */ C0505k f802b;

    C0506l(C0505k c0505k, Dialog dialog) {
        this.f802b = c0505k;
        this.f801a = dialog;
    }

    public void mo1833a() {
        this.f802b.f800a.m869d();
        if (this.f801a.isShowing()) {
            this.f801a.dismiss();
        }
    }
}
