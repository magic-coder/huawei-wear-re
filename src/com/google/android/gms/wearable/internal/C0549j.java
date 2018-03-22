package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0548k;
import com.google.android.gms.wearable.C0558p;

public class C0549j implements C0548k {
    private final Status f1058a;
    private final C0558p f1059b;

    public C0549j(Status status, C0558p c0558p) {
        this.f1058a = status;
        this.f1059b = c0558p;
    }

    public Status getStatus() {
        return this.f1058a;
    }
}
