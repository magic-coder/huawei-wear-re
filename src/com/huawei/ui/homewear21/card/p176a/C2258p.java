package com.huawei.ui.homewear21.card.p176a;

import com.huawei.p190v.C2538c;

/* compiled from: NotificationCardInteractors */
class C2258p implements Runnable {
    final /* synthetic */ C2254l f8206a;

    C2258p(C2254l c2254l) {
        this.f8206a = c2254l;
    }

    public void run() {
        this.f8206a.f8200j = false;
        C2538c.m12677c("FAQ", "pushMessageToDevice weakHandler.postDelayed mPushFaqMessageState = false");
    }
}
