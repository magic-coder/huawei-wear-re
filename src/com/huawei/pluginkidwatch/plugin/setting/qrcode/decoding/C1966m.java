package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: InactivityTimer */
public final class C1966m {
    private final ScheduledExecutorService f6824a = Executors.newSingleThreadScheduledExecutor(new C1968o());
    private final Activity f6825b;
    private ScheduledFuture<?> f6826c = null;

    public C1966m(Activity activity) {
        this.f6825b = activity;
        m10230a();
    }

    public void m10230a() {
        m10229c();
        this.f6826c = this.f6824a.schedule(new C1965l(this.f6825b), 300, TimeUnit.SECONDS);
    }

    private void m10229c() {
        if (this.f6826c != null) {
            this.f6826c.cancel(true);
            this.f6826c = null;
        }
    }

    public void m10231b() {
        m10229c();
        this.f6824a.shutdown();
    }
}
