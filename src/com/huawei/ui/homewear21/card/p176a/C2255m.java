package com.huawei.ui.homewear21.card.p176a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: NotificationCardInteractors */
class C2255m implements MessageObserver {
    final /* synthetic */ C2254l f8203a;

    C2255m(C2254l c2254l) {
        this.f8203a = c2254l;
    }

    public void onChange(int i, MessageChangeEvent messageChangeEvent) {
        C2538c.m12677c("NotificationCardInteractors", "MessageObserver onChange start");
        this.f8203a.f8194c.m10250b(new C2256n(this));
        this.f8203a.m11659d();
    }
}
