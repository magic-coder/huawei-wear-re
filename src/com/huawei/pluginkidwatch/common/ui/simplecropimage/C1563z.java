package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.app.ProgressDialog;
import android.os.Handler;

/* compiled from: Util */
class C1563z extends C1560v implements Runnable {
    private final MonitoredActivity f3749a;
    private final ProgressDialog f3750b;
    private final Runnable f3751c;
    private final Handler f3752d;
    private final Runnable f3753e = new aa(this);

    public C1563z(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f3749a = monitoredActivity;
        this.f3750b = progressDialog;
        this.f3751c = runnable;
        this.f3749a.m7070a(this);
        this.f3752d = handler;
    }

    public void run() {
        try {
            this.f3751c.run();
        } finally {
            this.f3752d.post(this.f3753e);
        }
    }

    public void mo2542b(MonitoredActivity monitoredActivity) {
        this.f3753e.run();
        this.f3752d.removeCallbacks(this.f3753e);
    }

    public void mo2544d(MonitoredActivity monitoredActivity) {
        this.f3750b.hide();
    }

    public void mo2543c(MonitoredActivity monitoredActivity) {
        this.f3750b.show();
    }
}
