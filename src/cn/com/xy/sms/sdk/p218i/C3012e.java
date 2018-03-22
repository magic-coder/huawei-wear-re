package cn.com.xy.sms.sdk.p218i;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.ad;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;

final class C3012e implements C2904g {
    private final /* synthetic */ int f10172a;

    C3012e(int i) {
        this.f10172a = i;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr[0].toString().equals("0") && objArr.length == 2) {
                    String obj = objArr[1].toString();
                    C2947n.m13274a("LastCheckResourseTime_" + this.f10172a, new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                    ad.m13229a(C2990h.m13442f(obj));
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "requestResourseQueue: " + th.getMessage(), th);
            }
        }
    }
}
