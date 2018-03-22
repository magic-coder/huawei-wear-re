package com.huawei.hms.support.p043b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.p039c.C0859g;
import com.huawei.hms.support.log.C0887a;
import com.p004c.p005a.p010c.C0316a;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HiAnalyticsUtil */
public class C0881a {
    private static C0881a f1407a;
    private static final Object f1408b = new Object();

    public static C0881a m3076a() {
        C0881a c0881a;
        synchronized (f1408b) {
            if (f1407a == null) {
                f1407a = new C0881a();
            }
            c0881a = f1407a;
        }
        return c0881a;
    }

    public void m3078a(Context context, String str, Map<String, String> map) {
        if (!m3079b()) {
            Object a = m3077a(map);
            if (!TextUtils.isEmpty(a)) {
                C0316a.m155a(context, str, a);
            }
        }
    }

    private String m3077a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            C0887a.m3098d("HiAnalyticsUtil", "AnalyticsHelper create json exception" + e.getMessage());
        }
        return jSONObject.toString();
    }

    public boolean m3079b() {
        if (C0859g.m3028a()) {
            return false;
        }
        C0887a.m3092a("HiAnalyticsUtil", "not ChinaROM ");
        return true;
    }
}
