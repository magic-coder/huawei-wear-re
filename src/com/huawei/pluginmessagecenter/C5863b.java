package com.huawei.pluginmessagecenter;

import com.huawei.pluginmessagecenter.provider.C5877a;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import java.util.ArrayList;

/* compiled from: MessageDBProvider */
class C5863b implements Runnable {
    final /* synthetic */ String f20128a;
    final /* synthetic */ C5862a f20129b;

    C5863b(C5862a c5862a, String str) {
        this.f20129b = c5862a;
        this.f20128a = str;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20128a);
        C5877a.m27072a().m27073a(0, new MessageChangeEvent(arrayList, null));
    }
}
