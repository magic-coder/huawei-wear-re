package com.huawei.appmarket.sdk.foundation.p364c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import java.util.Map;

public class C4269a {
    private static C4269a f15939e;
    private Context f15940a;
    private Map<Handler, Integer> f15941b = new ArrayMap();
    private boolean f15942c;
    private C4271c f15943d = new C4271c();

    public static synchronized C4269a m20641a() {
        C4269a c4269a;
        synchronized (C4269a.class) {
            if (f15939e == null) {
                f15939e = new C4269a();
            }
            c4269a = f15939e;
        }
        return c4269a;
    }

    public synchronized void m20643a(Context context) {
        if (!this.f15942c) {
            this.f15940a = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this.f15943d, intentFilter);
            this.f15942c = true;
        }
    }

    public synchronized void m20644b() {
        if (this.f15942c) {
            this.f15940a.unregisterReceiver(this.f15943d);
            this.f15940a = null;
            this.f15942c = false;
        }
    }
}
