package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ChatActivity */
class C1752f implements OnClickListener {
    final /* synthetic */ ChatActivity f4843a;

    C1752f(ChatActivity chatActivity) {
        this.f4843a = chatActivity;
    }

    public void onClick(View view) {
        this.f4843a.f4711S.cancel();
        this.f4843a.f4711S = null;
    }
}
