package cn.com.xy.sms.sdk.p220j.p221a;

import android.content.Context;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.Map;

final class C3018c implements Runnable {
    private final /* synthetic */ Context f10192a;
    private final /* synthetic */ String f10193b;
    private final /* synthetic */ String f10194c;
    private final /* synthetic */ String f10195d;
    private final /* synthetic */ long f10196e;
    private final /* synthetic */ Map f10197f;
    private final /* synthetic */ C2904g f10198g;

    C3018c(Context context, String str, String str2, String str3, long j, Map map, C2904g c2904g) {
        this.f10192a = context;
        this.f10193b = str;
        this.f10194c = str2;
        this.f10195d = str3;
        this.f10196e = j;
        this.f10197f = map;
        this.f10198g = c2904g;
    }

    public final void run() {
        try {
            if (C3017b.m13547b(this.f10192a, this.f10193b, this.f10194c, this.f10195d, this.f10196e, this.f10197f) != null) {
                this.f10198g.execute(r0);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ParseSmsMessage parseMsgAsyn error:" + th.getLocalizedMessage(), th);
        }
    }
}
