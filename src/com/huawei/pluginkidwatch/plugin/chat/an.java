package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.util.List;

/* compiled from: ChatActivity */
class an implements Runnable {
    final /* synthetic */ List f4817a;
    final /* synthetic */ ChatActivity f4818b;

    an(ChatActivity chatActivity, List list) {
        this.f4818b = chatActivity;
        this.f4817a = list;
    }

    public void run() {
        for (C1744a c1744a : this.f4817a) {
            C1392h.m6296b(this.f4818b.f4709Q, C1462f.m6744i(), C1462f.m6746j(), c1744a.f4767b);
        }
    }
}
