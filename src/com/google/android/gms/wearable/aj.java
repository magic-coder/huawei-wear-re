package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

class aj implements Runnable {
    final /* synthetic */ DataHolder f932a;
    final /* synthetic */ ai f933b;

    aj(ai aiVar, DataHolder dataHolder) {
        this.f933b = aiVar;
        this.f932a = dataHolder;
    }

    public void run() {
        C0570o c0570o = new C0570o(this.f932a);
        try {
            this.f933b.f930a.mo1908a(c0570o);
        } finally {
            c0570o.mo1750a();
        }
    }
}
