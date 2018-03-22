package com.huawei.p030d.p031a;

import android.content.Context;
import com.huawei.d.a.b;
import com.huawei.hwdataaccessmodel.sharedpreference.a;

/* compiled from: TimestampListener */
class C4381c implements Runnable {
    final /* synthetic */ b f16283a;
    private Context f16284b;

    public C4381c(b bVar, Context context) {
        this.f16283a = bVar;
        this.f16284b = context;
    }

    public void run() {
        String str = System.currentTimeMillis() + "";
        b.a(this.f16283a);
        a.a(this.f16284b, "TimestampListener", "timestamp", str, null);
    }
}
