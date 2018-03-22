package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import java.util.TimerTask;

/* compiled from: ChatActivity */
class ac extends TimerTask {
    final /* synthetic */ ChatActivity f4805a;

    ac(ChatActivity chatActivity) {
        this.f4805a = chatActivity;
    }

    public void run() {
        C2538c.m12674b("ChatActivity", "chang count down");
        this.f4805a.ay.sendEmptyMessage(1003);
    }
}
