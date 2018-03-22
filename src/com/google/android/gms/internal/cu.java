package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class cu implements Executor {
    private final Handler f668a;

    public cu(Looper looper) {
        this.f668a = new Handler(looper);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f668a.post(runnable);
    }
}
