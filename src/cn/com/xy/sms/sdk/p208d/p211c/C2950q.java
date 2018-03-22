package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C2950q {
    public static JSONObject m13287a() {
        Throwable th;
        C2962e c2962e;
        C2962e c2962e2 = null;
        try {
            String[] strArr = new String[]{"id", "emVersion", "emContent"};
            C2962e a = C2922b.m13140a("tb_emergency_queue", strArr, null, null, null, null, " emVersion asc", "1");
            try {
                JSONObject b = C2921a.m13132b(strArr, a);
                C2962e.m13322a(a, true);
                return b;
            } catch (Throwable th2) {
                th = th2;
                c2962e2 = a;
                C2962e.m13322a(c2962e2, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C2962e.m13322a(c2962e2, true);
            throw th;
        }
    }

    public static void m13288a(JSONArray jSONArray) {
        Throwable th;
        C2962e c2962e;
        C2962e c2962e2 = null;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    C2962e.m13322a(null, true);
                } else {
                    try {
                        String str = (String) C3045j.m13620a(optJSONObject, "emContent");
                        String str2 = (String) C3045j.m13620a(optJSONObject, "emVersion");
                        if (C3049n.m13653e(str2) || C3049n.m13653e(str)) {
                            C2962e.m13322a(null, true);
                        } else {
                            C2962e a = C2922b.m13139a("tb_emergency_queue", new String[]{"emVersion"}, "emVersion = ?", new String[]{new StringBuilder(String.valueOf(str2)).toString()});
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("emVersion", str2);
                                contentValues.put("emContent", str);
                                if (a == null || a.m13323a() <= 0) {
                                    C2922b.m13135a("tb_emergency_queue", contentValues);
                                } else {
                                    C2922b.m13133a("tb_emergency_queue", contentValues, "emVersion = ? ", new String[]{new StringBuilder(String.valueOf(str2)).toString()});
                                }
                                C2962e.m13322a(a, true);
                            } catch (Throwable th2) {
                                th = th2;
                                c2962e2 = a;
                            }
                        }
                    } catch (Throwable th3) {
                        C2982a.m13415a("XIAOYUAN", "insertOrUpdateEmergency " + th3.getLocalizedMessage(), th3);
                        return;
                    }
                }
            }
            return;
        }
        return;
        C2962e.m13322a(c2962e2, true);
        throw th3;
    }
}
