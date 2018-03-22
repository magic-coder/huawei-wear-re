package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class aq implements OnClickListener {
    final /* synthetic */ ChatActivity f4822a;

    aq(ChatActivity chatActivity) {
        this.f4822a = chatActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("ChatActivity", "=====cellResendClickListener-->onClick");
        if (view instanceof av) {
            C2538c.m12674b("ChatActivity", "=====cellResendClickListener-->postion:" + this.f4822a.f4725i.getPositionForView((av) view));
            C1744a c1744a = (C1744a) this.f4822a.f4719c.get(r0);
            if (c1744a == null) {
                C2538c.m12674b("ChatActivity", "=====cellResendClickListener-->model is null,return");
                return;
            }
            this.f4822a.m8382a(c1744a);
        }
    }
}
