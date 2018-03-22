package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p547b.C6517l;

final class ae implements Runnable {
    final /* synthetic */ Context f22608a;
    final /* synthetic */ C6547y f22609b = null;

    ae(Context context) {
        this.f22608a = context;
    }

    public final void run() {
        if (this.f22608a == null) {
            C6546x.f22856q.m29707d("The Context of StatService.onResume() can not be null!");
        } else {
            C6546x.m29865a(this.f22608a, C6517l.m29752h(this.f22608a), this.f22609b);
        }
    }
}
