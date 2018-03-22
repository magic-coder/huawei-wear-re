package com.huawei.pluginkidwatch.home;

import android.content.Context;
import com.huawei.android.pushagent.PushReceiver;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: K1PushService */
class bl implements Runnable {
    final /* synthetic */ Context f4277a;
    final /* synthetic */ K1PushService f4278b;

    bl(K1PushService k1PushService, Context context) {
        this.f4278b = k1PushService;
        this.f4277a = context;
    }

    public void run() {
        PushReceiver.getToken(this.f4277a);
        this.f4278b.f4156c.removeCallbacks(this.f4278b.f4157d);
        this.f4278b.f4156c.removeCallbacks(this.f4278b.f4158e);
        this.f4278b.f4156c.postDelayed(this.f4278b.f4157d, FileWatchdog.DEFAULT_DELAY);
        this.f4278b.f4156c.postDelayed(this.f4278b.f4158e, FileWatchdog.DEFAULT_DELAY);
    }
}
