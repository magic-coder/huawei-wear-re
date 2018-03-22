package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;

/* compiled from: ChatActivity */
class ab implements Runnable {
    final /* synthetic */ ChatActivity f4804a;

    ab(ChatActivity chatActivity) {
        this.f4804a = chatActivity;
    }

    public void run() {
        C2538c.m12674b("ChatActivity", "======Enter loopVoiceRunnable");
        this.f4804a.m8459x();
        if (ChatActivity.aa <= 10) {
            this.f4804a.ay.postDelayed(this.f4804a.aE, (long) this.f4804a.m8456w());
        }
    }
}
