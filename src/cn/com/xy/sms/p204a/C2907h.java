package cn.com.xy.sms.p204a;

import android.content.Context;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2997c;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import cn.com.xy.sms.sdk.p218i.C3013f;
import cn.com.xy.sms.sdk.p218i.C3015h;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3056u;
import java.util.Map;

final class C2907h implements Runnable {
    private final /* synthetic */ Context f9878a;
    private final /* synthetic */ String f9879b;
    private final /* synthetic */ String f9880c;
    private final /* synthetic */ boolean f9881d;
    private final /* synthetic */ boolean f9882e;
    private final /* synthetic */ Map f9883f;

    C2907h(Context context, String str, String str2, boolean z, boolean z2, Map map) {
        this.f9878a = context;
        this.f9879b = str;
        this.f9880c = str2;
        this.f9881d = z;
        this.f9882e = z2;
        this.f9883f = map;
    }

    public final void run() {
        try {
            Context applicationContext = this.f9878a.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = this.f9878a;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C2947n.m13278a(applicationContext, this.f9879b, this.f9880c, this.f9881d, this.f9882e, this.f9883f);
            String str = this.f9879b;
            C2995m.m13477a();
            new StringBuilder("initParams time=").append(System.currentTimeMillis() - currentTimeMillis);
            C3013f.m13538a();
            C3056u.m13725c();
            C2899a.m13068a(C3040e.m13603a("yyyyMMdd"), C2973a.m13357a(null));
            C3013f.m13539a(new C3015h(2, new String[0]));
            C3013f.m13539a(new C3015h(7, new String[0]));
            C2978a.m13402a(true);
            C2997c.m13508a(false);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ParseManager.initSdk " + th.getMessage(), th);
        }
    }
}
