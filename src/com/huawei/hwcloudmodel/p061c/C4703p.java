package com.huawei.hwcloudmodel.p061c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;
import com.huawei.up.p517a.C6108a;

import java.util.Map;

/* compiled from: HWDataRequest */
public class C4703p {
    private static long f17143c = 0;
    private Context f17144a = null;
    private Handler f17145b = null;

    public static long m22512a() {
        return f17143c;
    }

    public static void m22513a(long j) {
        f17143c = j;
    }

    public C4703p(Context context) {
        this.f17144a = context;
    }

    public void m22516b() {
        HandlerThread handlerThread = new HandlerThread("HwCloudManager");
        handlerThread.start();
        this.f17145b = new C4705r(handlerThread.getLooper());
    }

    public void m22517c() {
        C2538c.c("HWDataRequest", new Object[]{"refreshToken begin"});
        if (d.c()) {
            C2538c.c("HWDataRequest", new Object[]{"isGreenVersion return"});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - C4703p.m22512a();
        C2538c.c("HWDataRequest", new Object[]{"refreshToken time:" + currentTimeMillis});
        if (Math.abs(System.currentTimeMillis() - C4703p.m22512a()) >= 5000) {
            C4703p.m22513a(System.currentTimeMillis());
            a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "false", new com.huawei.hwdataaccessmodel.a.c(0));
            new C6108a(this.f17144a).m27878a(com.huawei.login.ui.login.a.a(this.f17144a).g(), false);
        }
    }

    public void m22515a(String str, Map<String, Object> map, C4691b c4691b) {
        m22514a(str, map, 30, 30, c4691b);
    }

    public void m22514a(String str, Map<String, Object> map, int i, int i2, C4691b c4691b) {
        C2538c.c("HWDataRequest", new Object[]{"call(),service=" + str});
        this.f17145b.post(new C4704q(this, new C4706s(this.f17144a), str, map, i, i2, c4691b));
    }
}
