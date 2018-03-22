package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ChatActivity */
class ao implements OnClickListener {
    final /* synthetic */ ChatActivity f4819a;

    ao(ChatActivity chatActivity) {
        this.f4819a = chatActivity;
    }

    public void onClick(View view) {
        this.f4819a.f4712T.cancel();
        this.f4819a.f4712T = null;
    }
}
