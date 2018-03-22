package com.huawei.pluginkidwatch.plugin.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ChatActivity */
class ai extends BroadcastReceiver {
    final /* synthetic */ ChatActivity f4812a;

    ai(ChatActivity chatActivity) {
        this.f4812a = chatActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.SCREEN_ON".equals(action) && "android.intent.action.SCREEN_OFF".equals(action)) {
            this.f4812a.af = true;
        }
    }
}
