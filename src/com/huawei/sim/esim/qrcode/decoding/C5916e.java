package com.huawei.sim.esim.qrcode.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: InactivityTimer */
public final class C5916e {
    private final ScheduledExecutorService f20281a = Executors.newSingleThreadScheduledExecutor(new C5918g());
    private ScheduledFuture<?> f20282b = null;
    private final Activity f20283c;

    public C5916e(Activity activity) {
        this.f20283c = activity;
        m27181a();
    }

    public void m27181a() {
        m27180c();
        this.f20282b = this.f20281a.schedule(new C5915d(this.f20283c), 300, TimeUnit.SECONDS);
    }

    public void m27182b() {
        m27180c();
        this.f20281a.shutdown();
    }

    private void m27180c() {
        if (this.f20282b != null) {
            this.f20282b.cancel(true);
            this.f20282b = null;
        }
    }
}
