package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.xy.sms.sdk.p208d.p211c.C2934a;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2993k implements Runnable {
    private final /* synthetic */ String f10124a;
    private final /* synthetic */ C2937d f10125b;
    private final /* synthetic */ int f10126c;

    C2993k(String str, C2937d c2937d, int i) {
        this.f10124a = str;
        this.f10125b = c2937d;
        this.f10126c = i;
    }

    public final void run() {
        try {
            C2934a.m13205a(this.f10124a, this.f10125b, this.f10126c);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil parseUploadTask uploadContent:" + this.f10124a + " taskGroup:" + this.f10125b + " version:" + this.f10126c + " error:" + th.getMessage(), th);
        }
    }
}
