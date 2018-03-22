package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.os.Handler;
import android.os.Message;

/* compiled from: PullLoadListener */
class C1533b extends Handler {
    final /* synthetic */ PullToRefreshLayout f3638a;
    final /* synthetic */ C1532a f3639b;

    C1533b(C1532a c1532a, PullToRefreshLayout pullToRefreshLayout) {
        this.f3639b = c1532a;
        this.f3638a = pullToRefreshLayout;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f3638a.m7059a(0);
    }
}
