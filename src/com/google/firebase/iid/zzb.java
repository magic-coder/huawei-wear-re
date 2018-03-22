package com.google.firebase.iid;

import android.app.Service;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    @VisibleForTesting
    final ExecutorService f1080a = Executors.newSingleThreadExecutor();
    private final Object f1081b = new Object();
    private int f1082c = 0;
}
