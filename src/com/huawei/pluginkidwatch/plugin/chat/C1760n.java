package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import java.util.concurrent.Executors;

/* compiled from: ChatActivity */
class C1760n implements Runnable {
    final /* synthetic */ ChatActivity f4853a;

    C1760n(ChatActivity chatActivity) {
        this.f4853a = chatActivity;
    }

    public void run() {
        if (this.f4853a.ak) {
            C2538c.m12674b("ChatActivity", "initRunnable start thread initMsglist");
            Executors.newSingleThreadExecutor().execute(new C1761o(this));
            return;
        }
        C2538c.m12674b("ChatActivity", "initRunnable initMsglist thread is not finish!");
    }
}
