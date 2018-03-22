package com.huawei.ui.homewear21.card.p176a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HeartRateStatusInteractors */
class C2248f implements OnClickListener {
    final /* synthetic */ C2247e f8185a;

    C2248f(C2247e c2247e) {
        this.f8185a = c2247e;
    }

    public void onClick(View view) {
        if (C2247e.f8170d == -5) {
            C2247e.f8171e = 12;
            Message message = new Message();
            message.what = 1002;
            this.f8185a.f8172a.sendMessage(message);
        } else if (C2247e.f8170d == -6) {
            C2247e.f8171e = 12;
            this.f8185a.m11641o();
        }
    }
}
