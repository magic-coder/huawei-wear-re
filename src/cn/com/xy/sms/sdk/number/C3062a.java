package cn.com.xy.sms.sdk.number;

import android.os.Handler;
import android.os.HandlerThread;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3052q;

public final class C3062a extends C3052q {
    private static HandlerThread f10314a = null;
    private static Handler f10315b = null;
    private static long f10316c = 0;
    private static long f10317d = 1200000;
    private static boolean f10318e = true;

    public final void mo3635a() {
        try {
            if (f10315b == null) {
                HandlerThread handlerThread = new HandlerThread("LoactionHandlerThread");
                f10314a = handlerThread;
                handlerThread.start();
                f10315b = new C3063e(this, f10314a.getLooper());
            }
            f10316c = System.currentTimeMillis();
            C3041f.m13609b().m13098a(C2917a.m13105a(), f10315b);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "LoactionRunnable execute error:" + th.getMessage(), th);
        }
    }

    public final boolean mo3636b() {
        return f10316c + f10317d > System.currentTimeMillis();
    }
}
