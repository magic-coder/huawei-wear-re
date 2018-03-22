package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class C1769w implements Runnable {
    final /* synthetic */ C1744a f4862a;
    final /* synthetic */ int f4863b;
    final /* synthetic */ ChatActivity f4864c;

    C1769w(ChatActivity chatActivity, C1744a c1744a, int i) {
        this.f4864c = chatActivity;
        this.f4862a = c1744a;
        this.f4863b = i;
    }

    public void run() {
        C2538c.m12674b("ChatActivity", "==saveVoiceToCloudResult--->run");
        this.f4862a.f4772g = this.f4863b;
        this.f4864c.m8412d(this.f4862a);
        this.f4864c.f4705M.m8494a(this.f4864c.ae);
    }
}
