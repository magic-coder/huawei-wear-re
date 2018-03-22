package cn.com.xy.sms.sdk.p214f;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p208d.p211c.C2948o;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2923a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3049n;

final class C2980c implements C2904g {
    private final /* synthetic */ String f10096a;
    private final /* synthetic */ String f10097b;

    C2980c(String str, String str2) {
        this.f10096a = str;
        this.f10097b = str2;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            String obj = objArr[0].toString();
            if (obj.equals("0") && objArr.length == 2) {
                String obj2 = objArr[1].toString();
                new StringBuilder("iccid=").append(this.f10096a).append(" response=").append(obj2);
                C2948o c = C2991i.m13466c(obj2);
                if (c.f10010a == 0) {
                    new StringBuilder("resutCode=").append(obj).append("response =").append(obj2);
                    c.f10011b = C3049n.m13641a(this.f10097b);
                    c.f10016g = System.currentTimeMillis();
                    if (C3049n.m13653e(this.f10097b)) {
                        if (!C3049n.m13653e(this.f10096a)) {
                            C2943j.m13257a(this.f10096a, true, c.f10013d, c.f10012c, c.f10014e, c.f10015f, C2917a.m13105a());
                        }
                    } else if (C2923a.m13155a(c)) {
                        C2923a.m13154a(c.f10011b, c);
                    }
                } else if (c.f10010a == C2991i.f10119b) {
                    C2996a.m13499c(this.f10096a);
                }
            }
        }
    }
}
