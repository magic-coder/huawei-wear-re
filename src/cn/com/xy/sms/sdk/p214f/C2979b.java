package cn.com.xy.sms.sdk.p214f;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2979b implements Runnable {
    private final /* synthetic */ C2942i f10095a;

    C2979b(C2942i c2942i) {
        this.f10095a = c2942i;
    }

    public final void run() {
        try {
            C2978a.m13396a(C2917a.m13105a(), this.f10095a, false);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
