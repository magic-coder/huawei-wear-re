package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;

final class C3036a implements C2904g {
    C3036a() {
    }

    public final void execute(Object... objArr) {
        if (objArr != null && objArr[0].toString().equals("0") && objArr.length == 2 && C2990h.m13439c(objArr[1].toString())) {
            C2947n.m13274a("LastPostIccidSceneTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            C2947n.m13274a("PostCount", new StringBuilder(String.valueOf(C2947n.m13273a("PostCount", 0, C2917a.m13105a()) + 1)).toString());
            try {
                C2922b.m13134a("tb_count_scene", null, null);
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "deleteAll: " + th.getMessage(), th);
            }
        }
    }
}
