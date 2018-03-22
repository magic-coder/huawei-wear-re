package cn.com.xy.sms.sdk.p220j.p225e;

import cn.com.xy.sms.sdk.p208d.p211c.C2954u;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

final class C3034b implements Runnable {
    private final /* synthetic */ String f10254a;

    C3034b(String str) {
        this.f10254a = str;
    }

    public final void run() {
        int i = 0;
        try {
            if (!C3049n.m13653e(this.f10254a)) {
                String str = this.f10254a;
                if (!C3049n.m13653e(str)) {
                    String[] split = str.split("_ARR_");
                    if (split != null || split.length > 0) {
                        while (i < split.length) {
                            C2954u.m13297a(split[i], 0);
                            i++;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
        }
    }
}
