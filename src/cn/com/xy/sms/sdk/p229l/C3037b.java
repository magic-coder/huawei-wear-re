package cn.com.xy.sms.sdk.p229l;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C3037b {
    private static HashMap<String, C3037b> f10267o = new HashMap();
    public Map<String, JSONObject> f10268a = new HashMap();
    public Map<String, JSONObject> f10269b = new HashMap();
    public Map<String, JSONArray> f10270c = new HashMap();
    public HashSet<String> f10271d = new HashSet();
    public HashSet<String> f10272e = new HashSet();
    public final Map<String, JSONObject> f10273f = new HashMap();
    public final Map<String, JSONObject> f10274g = new HashMap();
    public final HashSet<String> f10275h = new HashSet();
    public final HashSet<String> f10276i = new HashSet();
    public final Map<String, Map<String, Object>> f10277j = new HashMap();
    public final Map<String, JSONObject> f10278k = new HashMap();
    public final Map<String, JSONObject> f10279l = new HashMap();
    public final HashSet<String> f10280m = new HashSet();
    public final HashSet<String> f10281n = new HashSet();

    public static C3037b m13588a(String str) {
        return (C3037b) f10267o.get(str);
    }

    public static C3037b m13589b(String str) {
        C3037b a = C3037b.m13588a(str);
        if (a != null) {
            return a;
        }
        a = new C3037b();
        f10267o.put(str, a);
        return a;
    }

    public static void m13590d(String str) {
        try {
            for (Entry value : f10267o.entrySet()) {
                ((C3037b) value.getValue()).m13591c(str);
            }
        } catch (Throwable th) {
        }
    }

    public final void m13591c(String str) {
        try {
            this.f10273f.remove(str);
            this.f10274g.remove(str);
            this.f10275h.remove(str);
            this.f10276i.remove(str);
            this.f10268a.remove(str);
            this.f10270c.remove(str);
            this.f10272e.remove(str);
            this.f10269b.remove(str);
            this.f10278k.remove(str);
            this.f10279l.remove(str);
            this.f10280m.remove(str);
            this.f10281n.remove(str);
        } catch (Throwable th) {
        }
    }
}
