package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa {
    private static String[] f9946a = new String[]{"scene_id", "date", "action_type", "times", "action_code"};

    public static long m13213a(HashMap<String, String> hashMap) {
        JSONObject jSONObject = null;
        String str = (String) hashMap.get("titleNo");
        String str2 = (String) hashMap.get("type");
        str2 = !C3049n.m13653e(str2) ? str2.trim() : "-1";
        try {
            if (!(C3049n.m13653e(str) || "-1".endsWith(str2))) {
                jSONObject = aa.m13218b(str, str2);
            }
            if (jSONObject != null) {
                jSONObject.put("times", String.valueOf(Integer.parseInt(jSONObject.getString("times")) + 1));
                C2922b.m13133a("tb_button_action_scene", C2921a.m13128a(null, false, jSONObject, f9946a), "scene_id = ? and date = ? and action_type = ? and action_code = ? ", new String[]{jSONObject.getString("scene_id"), jSONObject.getString("date"), jSONObject.getString("action_type"), jSONObject.getString("action_code")});
                return 0;
            }
            String a = C3040e.m13603a("yyyyMMdd");
            return C2922b.m13135a("tb_button_action_scene", C2921a.m13130a(null, "scene_id", str, "date", a, "action_code", str2, "times", "1"));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdateParse: " + th.getMessage(), th);
            return -1;
        }
    }

    public static JSONArray m13214a(String str, String str2) {
        Throwable th;
        C2962e a;
        try {
            a = C2922b.m13140a("tb_button_action_scene", f9946a, "scene_id = ? and date = ? ", new String[]{str, str2}, null, null, null, null);
            try {
                JSONArray a2 = C2921a.m13131a(f9946a, a);
                C2962e.m13322a(a, true);
                return a2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C2982a.m13415a("XIAOYUAN", "queryByIdDate: " + th.getMessage(), th);
                    C2962e.m13322a(a, true);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    C2962e.m13322a(a, true);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }

    public static void m13215a() {
        try {
            C2922b.m13134a("tb_button_action_scene", null, null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteAll: " + th.getMessage(), th);
        }
    }

    public static void m13216a(String str) {
        try {
            C2922b.m13134a("tb_button_action_scene", "date < ?", new String[]{str});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteInfoByDate: " + th.getMessage(), th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m13217b() {
        /*
        r9 = 1;
        r8 = 0;
        r0 = "tb_button_action_scene";
        r1 = f9946a;	 Catch:{ Throwable -> 0x0095, all -> 0x008f }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = "action_code";
        r7 = 0;
        r2 = cn.com.xy.sms.sdk.p208d.C2922b.m13140a(r0, r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0095, all -> 0x008f }
        if (r2 != 0) goto L_0x0019;
    L_0x0014:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r9);
        r0 = r8;
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0099, all -> 0x008a }
        r1.<init>();	 Catch:{ Throwable -> 0x0099, all -> 0x008a }
    L_0x001e:
        r0 = r2.m13327b();	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r9);
        r0 = r1;
        goto L_0x0018;
    L_0x0029:
        r0 = 0;
        r3 = r2.m13328c(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = 4;
        r0 = r2.m13328c(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13661l(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = 3;
        r0 = r2.m13328c(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13661l(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = r1.containsKey(r3);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        if (r0 == 0) goto L_0x0086;
    L_0x0046:
        r0 = r1.get(r3);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r6.<init>(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = r6.append(r4);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = r0.append(r5);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        r1.put(r3, r0);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        goto L_0x001e;
    L_0x0065:
        r0 = move-exception;
        r8 = r2;
        r10 = r0;
        r0 = r1;
        r1 = r10;
    L_0x006a:
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0092 }
        r4 = "queryActionRecord: ";
        r3.<init>(r4);	 Catch:{ all -> 0x0092 }
        r4 = r1.getMessage();	 Catch:{ all -> 0x0092 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0092 }
        r3 = r3.toString();	 Catch:{ all -> 0x0092 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r1);	 Catch:{ all -> 0x0092 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r8, r9);
        goto L_0x0018;
    L_0x0086:
        r1.put(r3, r5);	 Catch:{ Throwable -> 0x0065, all -> 0x008a }
        goto L_0x001e;
    L_0x008a:
        r0 = move-exception;
    L_0x008b:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r2, r9);
        throw r0;
    L_0x008f:
        r0 = move-exception;
        r2 = r8;
        goto L_0x008b;
    L_0x0092:
        r0 = move-exception;
        r2 = r8;
        goto L_0x008b;
    L_0x0095:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x006a;
    L_0x0099:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
        r8 = r2;
        goto L_0x006a;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.aa.b():java.util.Map<java.lang.String, java.lang.String>");
    }

    private static JSONObject m13218b(String str, String str2) {
        Throwable th;
        String a = C3040e.m13603a("yyyyMMdd");
        C2962e a2;
        try {
            a2 = C2922b.m13140a("tb_button_action_scene", f9946a, "scene_id = ? and date = ? and (action_type = ? or action_code = ? )", new String[]{str, a, str2, str2}, null, null, null, "1");
            try {
                JSONObject b = C2921a.m13132b(f9946a, a2);
                C2962e.m13322a(a2, true);
                return b;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C2982a.m13415a("XIAOYUAN", "queryInfoBySceneId: " + th.getMessage(), th);
                    C2962e.m13322a(a2, true);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    C2962e.m13322a(a2, true);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            a2 = null;
            C2962e.m13322a(a2, true);
            throw th;
        }
    }
}
