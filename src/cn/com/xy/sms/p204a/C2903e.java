package cn.com.xy.sms.p204a;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.C2944k;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p220j.p221a.C3017b;
import cn.com.xy.sms.sdk.p229l.C3037b;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class C2903e {
    public static JSONObject m13075a(String str, String str2, String str3, String str4, long j, Map map, C2905f c2905f) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        Map hashMap = new HashMap();
        if (map != null) {
            try {
                Object obj = map.get("ref_basevalue");
                map.remove("parse_recognise_value");
                if (obj != null) {
                    z = Boolean.valueOf(obj.toString()).booleanValue();
                }
                hashMap.putAll(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (z) {
            C3037b b = C3037b.m13589b(str2);
            if (b.f10277j.containsKey(str)) {
                hashMap.putAll((Map) b.f10277j.get(str));
            } else {
                C3017b.m13545a(C2917a.m13105a(), str2, str3, str4, j, map, new C2908i(b, str, c2905f));
            }
        }
        JSONObject a = C2899a.m13065a(str2, str4, j, hashMap);
        if (a != null) {
            C2973a.m13365a(a, hashMap, map);
            new StringBuilder("特征值识别时间:").append(System.currentTimeMillis() - currentTimeMillis).append(", msgId:").append(str).append(", 结果:").append(a.toString());
            String jSONObject = a.toString();
            try {
                String a2 = C2944k.m13265a(str2, str4);
                if (!C3049n.m13653e(a2)) {
                    String[] strArr = new String[10];
                    strArr[0] = "msg_num_md5";
                    strArr[1] = a2;
                    strArr[2] = "phonenum";
                    strArr[3] = C3049n.m13646b(str2);
                    strArr[4] = "msg_id";
                    strArr[5] = str;
                    strArr[6] = "value_recognise_result";
                    if (jSONObject == null) {
                        jSONObject = "";
                    }
                    strArr[7] = jSONObject;
                    strArr[8] = "recognise_lasttime";
                    strArr[9] = String.valueOf(System.currentTimeMillis());
                    C2944k.m13263a(C2921a.m13130a(null, strArr), 4);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
            }
        }
        return a;
    }

    static /* synthetic */ void m13076a(String str) {
        C2982a.m13414a("duoquTest", "deleteRecognisedResultFromDb:" + str);
        C2944k.m13270b(str, null);
    }
}
