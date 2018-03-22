package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.br;
import com.google.android.gms.wearable.C0522l;
import com.google.android.gms.wearable.C0570o;

final class cm implements br<C0522l> {
    final /* synthetic */ DataHolder f1012a;

    cm(DataHolder dataHolder) {
        this.f1012a = dataHolder;
    }

    public void mo2013a() {
        this.f1012a.close();
    }

    public void m2073a(C0522l c0522l) {
        try {
            c0522l.mo1908a(new C0570o(this.f1012a));
        } finally {
            this.f1012a.close();
        }
    }

    public /* synthetic */ void mo2014a(Object obj) {
        m2073a((C0522l) obj);
    }
}
