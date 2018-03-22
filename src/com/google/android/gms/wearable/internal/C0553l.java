package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.C0552n;
import com.google.android.gms.wearable.C0558p;

public class C0553l implements C0552n {
    private int f1064a;
    private C0558p f1065b;

    public C0553l(C0552n c0552n) {
        this.f1064a = c0552n.mo2024b();
        this.f1065b = (C0558p) c0552n.mo2023a().freeze();
    }

    public C0558p mo2023a() {
        return this.f1065b;
    }

    public int mo2024b() {
        return this.f1064a;
    }

    public C0552n m2190c() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return m2190c();
    }

    public String toString() {
        String str = mo2024b() == 1 ? "changed" : mo2024b() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(mo2023a());
        return new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(valueOf).length()).append("DataEventEntity{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
    }
}
