package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0528f;
import java.io.IOException;
import java.io.OutputStream;

final class ds implements C0528f {
    private final Status f1048a;
    private final OutputStream f1049b;

    ds(Status status, OutputStream outputStream) {
        this.f1048a = (Status) C0424f.m649a((Object) status);
        this.f1049b = outputStream;
    }

    public void mo1750a() {
        if (this.f1049b != null) {
            try {
                this.f1049b.close();
            } catch (IOException e) {
            }
        }
    }

    public Status getStatus() {
        return this.f1048a;
    }
}
