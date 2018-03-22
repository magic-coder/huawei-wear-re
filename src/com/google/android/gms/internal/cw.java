package com.google.android.gms.internal;

import android.os.Process;

class cw implements Runnable {
    private final Runnable f673a;
    private final int f674b;

    public cw(Runnable runnable, int i) {
        this.f673a = runnable;
        this.f674b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f674b);
        this.f673a.run();
    }
}
