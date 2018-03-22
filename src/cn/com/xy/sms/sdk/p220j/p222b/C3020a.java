package cn.com.xy.sms.sdk.p220j.p222b;

import cn.com.xy.sms.p204a.C2905f;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.C2956w;
import cn.com.xy.sms.sdk.p208d.p211c.C2957x;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class C3020a {
    public static JSONObject m13549a(String str, String str2, HashMap<String, String> hashMap, C2905f c2905f) {
        if (C3049n.m13653e(str)) {
            C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "phone num is null");
            return null;
        }
        JSONObject a = C2956w.m13304a(str);
        if (a != null) {
            try {
                String optString = a.optString("updateInfoTime");
                JSONObject jSONObject = new JSONObject(a.optString("actions"));
                if (System.currentTimeMillis() < Long.parseLong(optString) + C2973a.m13350a(27, 2592000000L)) {
                    C3050o.m13670a((C2904g) c2905f, "0", jSONObject);
                    return jSONObject;
                } else if (C3050o.m13663a(C2917a.m13105a()) == -1) {
                    C3050o.m13670a((C2904g) c2905f, "0", jSONObject);
                    return jSONObject;
                } else {
                    C3020a.m13553c(str, str2, hashMap, c2905f);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "queryOperatorCmd: " + th.getMessage(), th);
            }
        } else if (C3050o.m13663a(C2917a.m13105a()) == -1) {
            C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "have no available net work");
        } else {
            C3020a.m13553c(str, str2, hashMap, c2905f);
        }
        return null;
    }

    public static JSONObject m13551b(String str, String str2, HashMap<String, String> hashMap, C2905f c2905f) {
        if (C3049n.m13644a(str, str2)) {
            JSONObject a = C2957x.m13307a(str, str2);
            if (a != null) {
                try {
                    String optString = a.optString("updateInfoTime");
                    JSONObject jSONObject = new JSONObject(a.optString("result"));
                    if (System.currentTimeMillis() < Long.parseLong(optString) + C2973a.m13350a(26, 2592000000L)) {
                        C3050o.m13670a((C2904g) c2905f, "0", jSONObject);
                        return jSONObject;
                    } else if (C3050o.m13663a(C2917a.m13105a()) == -1) {
                        C3050o.m13670a((C2904g) c2905f, "0", jSONObject);
                        return jSONObject;
                    } else {
                        C3020a.m13554d(str, str2, hashMap, c2905f);
                    }
                } catch (Throwable th) {
                    C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "error:" + th.getMessage());
                }
            } else if (C3050o.m13663a(C2917a.m13105a()) == -1) {
                C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "have no available net work");
            } else {
                C3020a.m13554d(str, str2, hashMap, c2905f);
            }
            return null;
        }
        C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "phone num or sms content is null");
        return null;
    }

    private static boolean m13552b(Map map) {
        if (map == null || !map.containsKey("isNewThread")) {
            return true;
        }
        return "true".equalsIgnoreCase((String) map.get("isNewThread"));
    }

    private static void m13553c(String str, String str2, HashMap<String, String> hashMap, C2905f c2905f) {
        if (C3049n.m13653e(str)) {
            C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "phone num is null");
            return;
        }
        String a = C2991i.m13452a(str, str2, (Map) hashMap);
        if (C3049n.m13653e(a)) {
            C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "request content error");
            return;
        }
        C2996a.m13496b((Map) hashMap);
        try {
            C2996a.m13490a("opinfo", a, (C2904g) new C3021b(a, hashMap, C2996a.m13505f(), c2905f, str, str2), C3020a.m13552b(hashMap), false, true, (Map) hashMap);
        } catch (Throwable th) {
            C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "request error:" + th.getMessage());
        }
    }

    private static void m13554d(String str, String str2, HashMap<String, String> hashMap, C2905f c2905f) {
        if (C3049n.m13644a(str, str2)) {
            String b = C2991i.m13462b(str, str2, hashMap);
            if (C3049n.m13653e(b)) {
                C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "request content error");
                return;
            }
            C2996a.m13496b((Map) hashMap);
            try {
                C2996a.m13490a("opanalysis", b, (C2904g) new C3022c(b, hashMap, C2996a.m13505f(), c2905f, str, str2), C3020a.m13552b(hashMap), false, true, (Map) hashMap);
                return;
            } catch (Throwable th) {
                C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "request error:" + th.getMessage());
                return;
            }
        }
        C3050o.m13670a((C2904g) c2905f, Integer.valueOf(-10), "phone num or sms content is null");
    }
}
