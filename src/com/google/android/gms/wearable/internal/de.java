package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0525c;
import com.google.android.gms.wearable.C0526d;

public class de implements C0525c {
    private final C0526d f1026a;
    private final Status f1027b;

    public de(Status status, C0526d c0526d) {
        this.f1027b = status;
        this.f1026a = c0526d;
    }

    public C0526d mo2018a() {
        return this.f1026a;
    }

    public Status getStatus() {
        return this.f1027b;
    }
}
