package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;

final class ah implements C2904g {
    private final /* synthetic */ int f10266a;

    ah(int i) {
        this.f10266a = i;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length == 2 && "0".equals(String.valueOf(objArr[0]))) {
                    String obj = objArr[1].toString();
                    if (C2982a.f10101a) {
                        C3048m.m13640d(C2990h.m13438b(obj), this.f10266a);
                    } else {
                        C3048m.m13640d(C2990h.m13438b(obj), this.f10266a);
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "SceneconfigUtil doRequestQuerySceneRuleRequest callBack error: " + th.getMessage(), th);
            }
        }
    }
}
