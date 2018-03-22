package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;

final class C3032h implements Runnable {
    private final /* synthetic */ boolean f10244a;
    private final /* synthetic */ String f10245b;
    private final /* synthetic */ String f10246c;
    private final /* synthetic */ String f10247d;
    private final /* synthetic */ String f10248e;
    private final /* synthetic */ int f10249f;
    private final /* synthetic */ C2904g f10250g;
    private final /* synthetic */ boolean f10251h;

    C3032h(boolean z, String str, String str2, String str3, String str4, int i, C2904g c2904g, boolean z2) {
        this.f10244a = z;
        this.f10245b = str;
        this.f10246c = str2;
        this.f10247d = str3;
        this.f10248e = str4;
        this.f10249f = i;
        this.f10250g = c2904g;
        this.f10251h = z2;
    }

    public final void run() {
        try {
            if ((C2996a.m13491a() && this.f10244a) || C2996a.m13492a(1)) {
                C3026b.m13567a(false, this.f10245b, this.f10246c, this.f10247d, this.f10248e, String.valueOf(this.f10249f), this.f10250g, 0, false, false, this.f10251h);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "querySinglePubInfoFromNetServer: " + th.getMessage(), th);
        }
    }
}
