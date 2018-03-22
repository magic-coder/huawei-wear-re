package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.os.Handler;
import java.util.Timer;

/* compiled from: PullToRefreshLayout */
class C1537f {
    private Handler f3643a;
    private Timer f3644b = new Timer();
    private C1536e f3645c;

    public C1537f(Handler handler) {
        this.f3643a = handler;
    }

    public void m7067a(long j) {
        if (this.f3645c != null) {
            this.f3645c.cancel();
            this.f3645c = null;
        }
        this.f3645c = new C1536e(this.f3643a);
        this.f3644b.schedule(this.f3645c, 0, j);
    }

    public void m7066a() {
        if (this.f3645c != null) {
            this.f3645c.cancel();
            this.f3645c = null;
        }
    }
}
