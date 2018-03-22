package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0527e;
import java.io.IOException;
import java.io.InputStream;

final class dr implements C0527e {
    private final Status f1046a;
    private final InputStream f1047b;

    dr(Status status, InputStream inputStream) {
        this.f1046a = (Status) C0424f.m649a((Object) status);
        this.f1047b = inputStream;
    }

    public void mo1750a() {
        if (this.f1047b != null) {
            try {
                this.f1047b.close();
            } catch (IOException e) {
            }
        }
    }

    public Status getStatus() {
        return this.f1046a;
    }
}
