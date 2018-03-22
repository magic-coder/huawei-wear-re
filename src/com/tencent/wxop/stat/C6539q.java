package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6498c;
import com.tencent.wxop.stat.p546a.C6500f;

final class C6539q implements Runnable {
    final /* synthetic */ Context f22772a;
    final /* synthetic */ Throwable f22773b;

    C6539q(Context context, Throwable th) {
        this.f22772a = context;
        this.f22773b = th;
    }

    public final void run() {
        try {
            if (C6544v.m29833c()) {
                new ai(new C6498c(this.f22772a, C6546x.m29858a(this.f22772a, false, null), this.f22773b, C6500f.f22592a)).m29659a();
            }
        } catch (Throwable th) {
            C6546x.f22856q.m29708e("reportSdkSelfException error: " + th);
        }
    }
}
