package com.tencent.wxop.stat;

import android.content.Context;

final class C6542t implements Runnable {
    final /* synthetic */ String f22777a;
    final /* synthetic */ Context f22778b;
    final /* synthetic */ C6547y f22779c;

    C6542t(String str, Context context, C6547y c6547y) {
        this.f22777a = str;
        this.f22778b = context;
        this.f22779c = c6547y;
    }

    public final void run() {
        try {
            synchronized (C6546x.f22854o) {
                if (C6546x.f22854o.size() >= C6544v.m29846m()) {
                    C6546x.f22856q.m29707d("The number of page events exceeds the maximum value " + Integer.toString(C6544v.m29846m()));
                    return;
                }
                C6546x.f22852m = this.f22777a;
                if (C6546x.f22854o.containsKey(C6546x.f22852m)) {
                    C6546x.f22856q.m29708e("Duplicate PageID : " + C6546x.f22852m + ", onResume() repeated?");
                    return;
                }
                C6546x.f22854o.put(C6546x.f22852m, Long.valueOf(System.currentTimeMillis()));
                C6546x.m29858a(this.f22778b, true, this.f22779c);
            }
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
            C6546x.m29866a(this.f22778b, th);
        }
    }
}
