package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.PullToRefreshLayout;

/* compiled from: ChatActivity */
class C1759m implements Runnable {
    final /* synthetic */ PullToRefreshLayout f4851a;
    final /* synthetic */ C1758l f4852b;

    C1759m(C1758l c1758l, PullToRefreshLayout pullToRefreshLayout) {
        this.f4852b = c1758l;
        this.f4851a = pullToRefreshLayout;
    }

    public void run() {
        this.f4852b.f4850a.m8386a(true);
        this.f4851a.m7059a(0);
    }
}
