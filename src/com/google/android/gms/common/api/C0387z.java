package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

public abstract class C0387z<R extends C0366w, S extends C0366w> {
    @NonNull
    public Status m411a(@NonNull Status status) {
        return status;
    }

    @Nullable
    @WorkerThread
    public abstract C0382t<S> m412a(@NonNull R r);
}
