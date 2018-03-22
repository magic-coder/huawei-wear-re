package cn.com.xy.sms.p204a;

import android.content.Context;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p220j.p222b.C3020a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import java.util.HashMap;
import org.json.JSONObject;

public class C2901c {
    public static JSONObject m13072a(Context context, String str, String str2, String str3, String str4, long j, HashMap<String, String> hashMap, C2905f c2905f) {
        JSONObject jSONObject = null;
        try {
            if (C3049n.m13644a(str2, str4)) {
                jSONObject = C3020a.m13551b(str2, str4, hashMap, c2905f);
            } else {
                C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "phone num or sms content is null");
            }
        } catch (Throwable th) {
            C2982a.m13415a("ParseOperatorManager", "parseOperatorMsg " + th.getMessage(), th);
        }
        return jSONObject;
    }

    public static JSONObject m13073a(Context context, String str, String str2, HashMap<String, String> hashMap, C2905f c2905f) {
        try {
            return C3020a.m13549a(str, str2, hashMap, c2905f);
        } catch (Throwable th) {
            C2982a.m13415a("ParseOperatorManager", "queryOperatorCmd " + th.getMessage(), th);
            return null;
        }
    }
}
