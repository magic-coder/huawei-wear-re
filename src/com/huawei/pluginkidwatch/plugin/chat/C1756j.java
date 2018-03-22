package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class C1756j implements OnClickListener {
    final /* synthetic */ ChatActivity f4848a;

    C1756j(ChatActivity chatActivity) {
        this.f4848a = chatActivity;
    }

    public void onClick(View view) {
        if (view instanceof av) {
            C2538c.m12674b("ChatActivity", "=====_cellClickListener:");
            int positionForView = this.f4848a.f4725i.getPositionForView((av) view);
            if (positionForView >= 0 && positionForView < this.f4848a.f4719c.size()) {
                C1744a c1744a = (C1744a) this.f4848a.f4719c.get(positionForView);
                for (C1744a c1744a2 : this.f4848a.f4719c) {
                    if (c1744a2 != c1744a) {
                        c1744a2.f4774i = false;
                    }
                }
                if (c1744a.f4774i) {
                    c1744a.f4774i = false;
                    this.f4848a.m8449s();
                } else {
                    this.f4848a.m8395b(c1744a.f4767b);
                    c1744a.f4774i = true;
                }
                if (!c1744a.f4776k) {
                    c1744a.f4776k = true;
                    this.f4848a.m8412d(c1744a);
                }
                this.f4848a.f4705M.m8494a(this.f4848a.ae);
            }
        }
    }
}
