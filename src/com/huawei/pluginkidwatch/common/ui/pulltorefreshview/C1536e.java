package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: PullToRefreshLayout */
class C1536e extends TimerTask {
    private Handler f3642a;

    public C1536e(Handler handler) {
        this.f3642a = handler;
    }

    public void run() {
        this.f3642a.obtainMessage().sendToTarget();
    }
}
