package cn.com.xy.sms.sdk.p220j.p224d;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.C2970m;
import cn.com.xy.sms.sdk.p208d.p211c.C2934a;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2953t;
import cn.com.xy.sms.sdk.p208d.p211c.C2955v;
import cn.com.xy.sms.sdk.p208d.p211c.ai;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class C3030f {
    public static final C3025a f10238a = new C3025a(1);
    static boolean f10239b = false;
    private static C3025a f10240c = new C3025a(2);

    public static String m13570a(String str, int i, String str2, Map<String, String> map, C2904g c2904g) {
        if (C3049n.m13653e(str)) {
            return "";
        }
        if (C2960c.m13317a()) {
            try {
                String a;
                String a2 = C3049n.m13642a((Map) map, "cnum");
                String a3 = C3049n.m13642a((Map) map, "code");
                int c = C2928f.m13190c(C3049n.m13642a((Map) map, "simIndex"));
                if (C3049n.m13653e(a3)) {
                    a3 = C2978a.m13394a(a2, c, str2, str);
                }
                JSONObject a4 = C2928f.m13179a(str, a3, i);
                String str3 = "";
                if (map == null || !map.containsKey("QUERY_NOW")) {
                    boolean c2 = C2928f.m13192c(a4);
                    if (a4 != null && !c2) {
                        if (C2928f.m13189b(a4)) {
                            a = C3045j.m13621a(a4);
                        }
                        a = str3;
                    } else if (map == null || !map.containsKey("SUPPORT_NET_QUERY")) {
                        C3030f.m13573a(str, a2, i, a3, str2, c2904g, false, c2);
                        a = str3;
                    } else {
                        C3030f.m13573a(str, a2, i, a3, str2, c2904g, true, c2);
                        a = str3;
                    }
                    if (c2904g != null) {
                        c2904g.execute(a);
                    }
                } else {
                    C3030f.m13573a(str, a2, i, a3, str2, c2904g, true, true);
                    a = str3;
                }
                C3030f.m13578c(a3, str2);
                return a;
            } catch (Throwable th) {
                C2982a.m13415a("PubInfoService", "queryPublicInfo error: " + th.getMessage(), th);
                if (c2904g != null) {
                    c2904g.execute("");
                }
                return "";
            }
        }
        if (c2904g != null) {
            c2904g.execute(null, "-1");
        }
        return "-1";
    }

    public static void m13571a() {
        if (C2996a.m13492a(2)) {
            C2953t b = C2970m.m13342b();
            new StringBuilder(" menuInfo=").append(b);
            if (b == null) {
                C2970m.m13344b("menuMain");
            }
            b = C2970m.m13342b();
            if (b == null) {
                return;
            }
            if (System.currentTimeMillis() > b.f10027d + C2973a.m13350a(5, 172800000)) {
                C2970m.m13341a(b, null, true, null);
            } else if (C2947n.m13283c(C2917a.m13105a(), "AUTO_UPDATE_DATA") == 0 && C2996a.m13492a(1)) {
                C2970m.m13343b(b);
            }
        }
    }

    public static void m13572a(String str, String str2) {
        try {
            C3030f.m13576b(str, str2);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "checkPubInfoUpdate: " + th.getMessage(), th);
        }
    }

    private static void m13573a(String str, String str2, int i, String str3, String str4, C2904g c2904g, boolean z, boolean z2) {
        if (C2947n.m13283c(C2917a.m13105a(), "QUERY_ONLINE") != 0) {
            C2978a.f10091b.execute(new C3032h(z, str, str2, str3, str4, i, c2904g, z2));
        }
    }

    static void m13574a(String str, String str2, boolean z) {
        List a = C2955v.m13299a(str, System.currentTimeMillis() - C2973a.m13350a(1, 2592000000L), 0);
        if (a != null && !a.isEmpty()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("request_time", Long.valueOf(System.currentTimeMillis()));
                C2922b.m13133a("tb_netquery_time", contentValues, "request_time < ? and request_time > 0 AND status = 0", new String[]{String.valueOf(r0)});
            } catch (Throwable th) {
                C2982a.m13415a("NetQueryTimeManager", "clearUpdateUnKnowNumTime error: " + th.getMessage(), th);
            }
            while (true) {
                int size = a.size();
                if (size > 0) {
                    Collection arrayList = new ArrayList();
                    if (size > 10) {
                        size = 10;
                    }
                    arrayList.addAll(a.subList(0, size));
                    C3026b.m13565a(arrayList, str, str2, "1", null, false);
                    a.removeAll(arrayList);
                } else {
                    return;
                }
            }
        }
    }

    public static void m13575a(String[] strArr) {
        if (strArr != null) {
            if (r3 != 0) {
                ai aiVar;
                StringBuffer stringBuffer = new StringBuffer();
                int i = 0;
                for (String append : strArr) {
                    stringBuffer.append(append);
                    i++;
                    if (i == 10) {
                        aiVar = new ai();
                        aiVar.f9958a = stringBuffer.toString();
                        aiVar.f9960c = C2937d.UPDATE_PUBINFO.toString();
                        C2934a.m13203a(aiVar);
                        stringBuffer.setLength(0);
                        i = 0;
                    } else {
                        stringBuffer.append(",");
                    }
                }
                if (i > 0) {
                    aiVar = new ai();
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    aiVar.f9958a = stringBuffer.toString();
                    aiVar.f9960c = C2937d.UPDATE_PUBINFO.toString();
                    C2934a.m13203a(aiVar);
                }
                C2934a.m13204a(C2937d.UPDATE_PUBINFO);
            }
        }
    }

    public static void m13576b(String str, String str2) {
        synchronized (f10238a) {
            if (f10239b) {
                return;
            }
            f10239b = true;
            f10238a.f10213b = str;
            f10238a.f10212a = str2;
            C3026b.f10216a.execute(f10238a);
        }
    }

    static void m13577b(String str, String str2, boolean z) {
        List a = C2928f.m13176a();
        new StringBuilder("批量更新 needUpdateList=").append(a);
        if (a == null || a.size() == 0) {
            synchronized (f10238a) {
                f10239b = false;
            }
            return;
        }
        C2904g c3031g = new C3031g(str, str2, z);
        new StringBuilder("批量更新开始执行 needUpdateList： ").append(a.size());
        C3026b.m13565a(a, str, str2, "1", c3031g, z);
    }

    private static void m13578c(String str, String str2) {
        if (!f10240c.f10214c && C2947n.m13283c(C2917a.m13105a(), "QUERY_ONLINE") != 0) {
            f10240c.f10213b = str;
            f10240c.f10212a = str2;
            C2978a.f10090a.execute(f10240c);
        }
    }
}
