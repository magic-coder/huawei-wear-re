package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;

final class C3043h implements Runnable {
    private final /* synthetic */ String f10288a;
    private final /* synthetic */ String f10289b;

    C3043h(String str, String str2) {
        this.f10288a = str;
        this.f10289b = str2;
    }

    public final void run() {
        try {
            C3050o.m13680b(this.f10288a, this.f10289b);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "chmod: " + th.getMessage(), th);
        }
    }
}
