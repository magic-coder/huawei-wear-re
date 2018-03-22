package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p208d.p211c.C2934a;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;

final class C3029e implements Runnable {
    private final /* synthetic */ C2937d f10237a;

    C3029e(C2937d c2937d) {
        this.f10237a = c2937d;
    }

    public final void run() {
        try {
            Thread.sleep(5000);
            C2934a.m13204a(this.f10237a);
            synchronized (C3030f.f10238a) {
                C3026b.f10217b = false;
            }
        } catch (Throwable th) {
            synchronized (C3030f.f10238a) {
                C3026b.f10217b = false;
            }
        }
    }
}
