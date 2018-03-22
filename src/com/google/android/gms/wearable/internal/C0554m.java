package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0402j;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C0552n;
import com.google.android.gms.wearable.C0558p;

public final class C0554m extends C0402j implements C0552n {
    private final int f1066c;

    public C0554m(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f1066c = i2;
    }

    public C0558p mo2023a() {
        return new C0561s(this.a, this.b, this.f1066c);
    }

    public int mo2024b() {
        return m472a("event_type");
    }

    public C0552n m2193c() {
        return new C0553l(this);
    }

    public /* synthetic */ Object freeze() {
        return m2193c();
    }

    public String toString() {
        String str = mo2024b() == 1 ? "changed" : mo2024b() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(mo2023a());
        return new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("DataEventRef{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
    }
}
