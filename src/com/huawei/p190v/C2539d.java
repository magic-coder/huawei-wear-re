package com.huawei.p190v;

import android.util.Log;

/* compiled from: LogUtil */
final class C2539d implements Runnable {
    C2539d() {
    }

    public void run() {
        try {
            C2538c.m12685i();
            C2538c.m12686j();
        } catch (Exception e) {
            Log.w("LogUtil", "cant get sdcard path" + e.getMessage());
        }
    }
}
