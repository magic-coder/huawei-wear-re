package com.huawei.pluginkidwatch.plugin.chat;

import java.util.TimerTask;

/* compiled from: ChatActivity */
class ad extends TimerTask {
    final /* synthetic */ ChatActivity f4806a;

    ad(ChatActivity chatActivity) {
        this.f4806a = chatActivity;
    }

    public void run() {
        this.f4806a.runOnUiThread(new ae(this));
    }
}
