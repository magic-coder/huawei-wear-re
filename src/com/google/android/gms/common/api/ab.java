package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class ab extends Exception {
    protected final Status f270a;

    public ab(@NonNull Status status) {
        super(status.getStatusMessage());
        this.f270a = status;
    }
}
