package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p547b.C6517l;

final class C6538p implements Runnable {
    final /* synthetic */ Context f22770a;
    final /* synthetic */ C6547y f22771b = null;

    C6538p(Context context) {
        this.f22770a = context;
    }

    public final void run() {
        if (this.f22770a == null) {
            C6546x.f22856q.m29707d("The Context of StatService.onPause() can not be null!");
        } else {
            C6546x.m29872b(this.f22770a, C6517l.m29752h(this.f22770a), this.f22771b);
        }
    }
}
