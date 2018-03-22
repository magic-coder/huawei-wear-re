package com.huawei.ui.homewear21.card.p176a;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: HeartRateStatusInteractors */
class C2249g extends Handler {
    final /* synthetic */ C2247e f8186a;

    C2249g(C2247e c2247e) {
        this.f8186a = c2247e;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.f8186a.m11622b(message.arg1);
                break;
            case 1001:
                this.f8186a.m11631g();
                break;
            case 1002:
                this.f8186a.m11634h();
                break;
            case 1003:
                this.f8186a.m11637k();
                break;
            case 1004:
                this.f8186a.m11636j();
                break;
            case 1006:
                this.f8186a.m11638l();
                break;
            default:
                C2538c.m12677c("HeartRateStatusInteractors", "Enter default");
                break;
        }
        super.handleMessage(message);
    }
}
