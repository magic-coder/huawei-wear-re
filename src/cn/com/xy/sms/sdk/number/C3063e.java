package cn.com.xy.sms.sdk.number;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3050o;

final class C3063e extends Handler {
    C3063e(C3062a c3062a, Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        Object obj = null;
        try {
            Bundle data = message.getData();
            if (!(data != null && data.containsKey("latitude") && data.containsKey("longitude"))) {
                obj = 1;
            }
            if (obj == null) {
                double d = data.getDouble("latitude");
                double d2 = data.getDouble("longitude");
                if (d != 0.0d || d2 != 0.0d) {
                    C3050o.m13668a(d, d2);
                    C3050o.m13679b();
                } else if (C3062a.f10318e) {
                    C3062a.f10318e = false;
                    Thread.sleep(5000);
                    C3041f.m13609b().m13098a(C2917a.m13105a(), C3062a.f10315b);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "LoactionRunnable initHandler error:" + th.getMessage(), th);
        }
    }
}
