package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;

/* compiled from: ChatActivity */
class C1765s implements Runnable {
    final /* synthetic */ ChatActivity f4858a;

    C1765s(ChatActivity chatActivity) {
        this.f4858a = chatActivity;
    }

    public void run() {
        C2538c.m12674b("ChatActivity", "before _updateSpeakShortFalse,_speakShor= " + this.f4858a.ah);
        if (1 != this.f4858a.al) {
            this.f4858a.ah = false;
        }
    }
}
