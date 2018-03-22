package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0535v;

public class ba implements C0535v {
    private final Status f965a;
    private final int f966b;

    public ba(Status status, int i) {
        this.f965a = status;
        this.f966b = i;
    }

    public Status getStatus() {
        return this.f965a;
    }
}
