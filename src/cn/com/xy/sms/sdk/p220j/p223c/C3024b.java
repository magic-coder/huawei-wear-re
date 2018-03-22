package cn.com.xy.sms.sdk.p220j.p223c;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2972o;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import org.json.JSONArray;

final class C3024b implements C2904g {
    C3024b() {
    }

    public final void execute(Object... objArr) {
        if (objArr != null) {
            String obj = objArr[0].toString();
            if (obj.equals("1")) {
                C2996a.m13502d(null);
                C3050o.m13670a(null, null, Integer.valueOf(HttpStatus.SC_FORBIDDEN));
                return;
            } else if (obj.equals("2") || obj.equals("3")) {
                C3050o.m13670a(null, null, Integer.valueOf(HttpStatus.SC_METHOD_NOT_ALLOWED));
                return;
            } else if (obj.equals("0") && objArr.length == 2) {
                obj = objArr[1].toString();
                if (C3049n.m13653e(obj)) {
                    C3050o.m13670a(null, null, Integer.valueOf(HttpStatus.SC_NOT_FOUND));
                    return;
                }
                try {
                    C2972o.m13349a(new JSONArray(obj));
                    C2972o.m13347a(true);
                    return;
                } catch (Throwable e) {
                    C2982a.m13415a("XIAOYUAN", "checkValidUrlNetBatch: " + e.getMessage(), e);
                }
            } else {
                C3050o.m13670a(null, null, Integer.valueOf(HttpStatus.SC_NOT_FOUND));
                return;
            }
        }
        C3050o.m13670a(null, null, Integer.valueOf(HttpStatus.SC_NOT_FOUND));
    }
}
