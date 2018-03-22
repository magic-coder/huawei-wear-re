package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class C1753g implements OnClickListener {
    final /* synthetic */ C1744a f4844a;
    final /* synthetic */ ChatActivity f4845b;

    C1753g(ChatActivity chatActivity, C1744a c1744a) {
        this.f4845b = chatActivity;
        this.f4844a = c1744a;
    }

    public void onClick(View view) {
        this.f4845b.f4711S.cancel();
        this.f4845b.f4711S = null;
        C2538c.m12674b("ChatActivity", "=====cellResendClickListener-->onClick:" + this.f4844a.toString());
        this.f4844a.f4772g = 2;
        if ("1".equals(this.f4844a.f4784s)) {
            this.f4845b.m8405c(this.f4844a);
        } else if ("0".equals(this.f4844a.f4784s)) {
            this.f4845b.m8394b(this.f4844a);
        }
        this.f4845b.f4705M.m8494a(this.f4845b.ae);
    }
}
