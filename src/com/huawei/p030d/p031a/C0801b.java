package com.huawei.p030d.p031a;

import android.content.Context;
import android.content.Intent;
import com.huawei.d.a.c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: TimestampListener */
public class C0801b {
    public static final String f1232a = C0801b.class.getSimpleName();
    private ScheduledExecutorService f1233b = Executors.newScheduledThreadPool(1);
    private C0996a f1234c = new C0996a();

    public void m2685a(Context context) {
        C2538c.m12677c(f1232a, "starting listener......");
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c(f1232a, "currentTimestamp is " + currentTimeMillis);
        C0996a c0996a = this.f1234c;
        String a = C0996a.m3612a(context, "TimestampListener", "timestamp");
        C2538c.m12677c(f1232a, "last timestamp is " + a);
        if (m2684a(a)) {
            if (currentTimeMillis - Long.parseLong(a) > 14400000) {
                C2538c.m12677c(f1232a, "sending broadcast to UI...");
                Intent intent = new Intent("com.huawei.bone.action.force_stop");
                intent.setPackage("com.huawei.bone");
                BaseApplication.m2632b().sendBroadcast(intent, C0976c.f1642a);
            } else {
                C2538c.m12677c(f1232a, "don't need to send broadcast to UI");
            }
        }
        this.f1233b.scheduleWithFixedDelay(new c(this, context), 0, 5, TimeUnit.MINUTES);
    }

    private boolean m2684a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
