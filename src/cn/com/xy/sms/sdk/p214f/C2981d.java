package cn.com.xy.sms.sdk.p214f;

import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2981d implements Runnable {
    private final /* synthetic */ String f10098a;
    private final /* synthetic */ String f10099b;
    private final /* synthetic */ String f10100c;

    C2981d(String str, String str2, String str3) {
        this.f10098a = str;
        this.f10099b = str2;
        this.f10100c = str3;
    }

    public final void run() {
        try {
            C2978a.m13407b(this.f10098a, this.f10099b, this.f10100c, false);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
