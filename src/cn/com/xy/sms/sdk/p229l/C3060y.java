package cn.com.xy.sms.sdk.p229l;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2950q;
import cn.com.xy.sms.sdk.p208d.p211c.C2951r;
import cn.com.xy.sms.sdk.p208d.p211c.C2952s;
import cn.com.xy.sms.sdk.p208d.p211c.aa;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2990h;
import cn.com.xy.sms.sdk.p218i.C3008a;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class C3060y implements C2904g {
    private final /* synthetic */ boolean f10313a;

    C3060y(boolean z) {
        this.f10313a = z;
    }

    public final void execute(Object... objArr) {
        List<C2951r> a;
        Object obj;
        if (objArr != null) {
            if (objArr[0].toString().equals("0") && objArr.length == 2) {
                Map a2 = C2990h.m13437a(objArr[1].toString());
                if (a2 == null) {
                    C2947n.m13274a("JARS_UPDATE_TIME", String.valueOf(System.currentTimeMillis()));
                    aa.m13215a();
                    if (this.f10313a && C2996a.m13492a(2)) {
                        a = C2952s.m13291a();
                        if (a.isEmpty()) {
                            obj = null;
                        } else {
                            obj = null;
                            for (C2951r c2951r : a) {
                                if (!C3049n.m13653e(c2951r.f10019c) && c2951r.f10021e == 0) {
                                    C3059x.m13733a(c2951r, false);
                                    obj = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            C3059x.m13736b();
                            return;
                        }
                        return;
                    }
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Object obj2 = a2.get("updataJars");
                if (obj2 != null) {
                    JSONArray jSONArray = (JSONArray) obj2;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("name");
                        String string2 = jSONObject.getString("version");
                        String string3 = jSONObject.getString("url");
                        long currentTimeMillis2 = System.currentTimeMillis();
                        long j = ((long) jSONObject.getInt("delayStart")) + currentTimeMillis;
                        long j2 = ((long) jSONObject.getInt("delayEnd")) + currentTimeMillis;
                        String optString = jSONObject.optString("pver");
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("version", string2);
                            contentValues.put("url", string3);
                            contentValues.put("status", Integer.valueOf(0));
                            contentValues.put("update_time", new StringBuilder(String.valueOf(currentTimeMillis2)).toString());
                            contentValues.put("delaystart", new StringBuilder(String.valueOf(j)).toString());
                            contentValues.put("delayend", new StringBuilder(String.valueOf(j2)).toString());
                            contentValues.put("pver", optString);
                            C2922b.m13133a("tb_jar_list", contentValues, "name = ? ", new String[]{string});
                        } catch (Throwable th) {
                            try {
                                C2982a.m13415a("XIAOYUAN", "checkJarsUpdate: " + th.getMessage(), th);
                                if (this.f10313a && C2996a.m13492a(2)) {
                                    a = C2952s.m13291a();
                                    if (a.isEmpty()) {
                                        obj = null;
                                    } else {
                                        obj = null;
                                        for (C2951r c2951r2 : a) {
                                            if (!C3049n.m13653e(c2951r2.f10019c) && c2951r2.f10021e == 0) {
                                                C3059x.m13733a(c2951r2, false);
                                                obj = 1;
                                            }
                                        }
                                    }
                                    if (obj != null) {
                                        C3059x.m13736b();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                if (this.f10313a && C2996a.m13492a(2)) {
                                    a = C2952s.m13291a();
                                    if (a.isEmpty()) {
                                        obj = null;
                                    } else {
                                        obj = null;
                                        for (C2951r c2951r22 : a) {
                                            if (!C3049n.m13653e(c2951r22.f10019c) && c2951r22.f10021e == 0) {
                                                C3059x.m13733a(c2951r22, false);
                                                obj = 1;
                                            }
                                        }
                                    }
                                    if (obj != null) {
                                        C3059x.m13736b();
                                    }
                                }
                            }
                        }
                    }
                }
                aa.m13215a();
                if (a2.containsKey("emergencyArray")) {
                    C2950q.m13288a((JSONArray) a2.get("emergencyArray"));
                }
                C3008a.m13531a();
            }
        }
        if (this.f10313a && C2996a.m13492a(2)) {
            a = C2952s.m13291a();
            if (a.isEmpty()) {
                obj = null;
            } else {
                obj = null;
                for (C2951r c2951r222 : a) {
                    if (!C3049n.m13653e(c2951r222.f10019c) && c2951r222.f10021e == 0) {
                        C3059x.m13733a(c2951r222, false);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                C3059x.m13736b();
            }
        }
    }
}
