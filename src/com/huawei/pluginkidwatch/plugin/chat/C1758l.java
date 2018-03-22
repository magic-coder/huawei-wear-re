package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.C1532a;
import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.PullToRefreshLayout;

/* compiled from: ChatActivity */
class C1758l extends C1532a {
    final /* synthetic */ ChatActivity f4850a;

    C1758l(ChatActivity chatActivity) {
        this.f4850a = chatActivity;
    }

    public void mo2529a(PullToRefreshLayout pullToRefreshLayout) {
        C2538c.m12674b("ChatActivity", "=====onRefresh");
        this.f4850a.ay.postDelayed(new C1759m(this, pullToRefreshLayout), 800);
    }
}
