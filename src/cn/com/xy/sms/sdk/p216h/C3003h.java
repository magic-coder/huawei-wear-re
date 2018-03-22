package cn.com.xy.sms.sdk.p216h;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;

final class C3003h implements C2904g {
    C3003h() {
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            String obj = objArr[0].toString();
            if (obj.equals("0") && objArr.length == 2) {
                String obj2 = objArr[1].toString();
                new StringBuilder("resutCode=").append(obj).append("response =").append(obj2);
                obj = C2991i.m13468d(obj2);
                if (obj != null) {
                    C2947n.m13274a("HTTPTOKEN", obj);
                    C2947n.f10009a.put("HTTPTOKEN", obj);
                }
            }
        }
    }
}
