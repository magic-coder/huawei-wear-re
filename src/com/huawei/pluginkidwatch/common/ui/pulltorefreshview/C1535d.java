package com.huawei.pluginkidwatch.common.ui.pulltorefreshview;

import android.os.Handler;
import android.os.Message;

/* compiled from: PullToRefreshLayout */
class C1535d extends Handler {
    final /* synthetic */ PullToRefreshLayout f3641a;

    C1535d(PullToRefreshLayout pullToRefreshLayout) {
        this.f3641a = pullToRefreshLayout;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f3641a.m7051b(5);
        this.f3641a.m7046a();
    }
}
