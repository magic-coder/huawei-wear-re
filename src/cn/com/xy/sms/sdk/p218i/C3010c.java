package cn.com.xy.sms.sdk.p218i;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONObject;

final class C3010c implements C2904g {
    private final /* synthetic */ int f10169a;
    private final /* synthetic */ String f10170b;

    C3010c(int i, String str) {
        this.f10169a = i;
        this.f10170b = str;
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            try {
                String obj = objArr[0].toString();
                if (obj.equals("1")) {
                    C2996a.m13502d(null);
                } else if (obj.equals("0") && objArr.length == 2) {
                    obj = objArr[1].toString();
                    if (!C3049n.m13653e(obj) && new JSONObject(obj).optString("result").equals("0")) {
                        new StringBuilder("callback type=").append(this.f10169a).append(" postData=").append(this.f10170b);
                        C2973a.m13361a(Integer.valueOf(this.f10169a), this.f10170b);
                    }
                }
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "sendLog=" + e.getMessage(), e);
            }
        }
    }
}
