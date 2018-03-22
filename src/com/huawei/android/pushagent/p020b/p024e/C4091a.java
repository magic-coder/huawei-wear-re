package com.huawei.android.pushagent.p020b.p024e;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.C4043b;
import com.huawei.android.pushagent.p020b.p021a.p324a.p326b.C4073b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C4091a {
    private static C4091a f15486a = null;

    private C4091a() {
    }

    public static synchronized C4091a m20081a() {
        C4091a c4091a;
        synchronized (C4091a.class) {
            if (f15486a != null) {
                c4091a = f15486a;
            } else {
                f15486a = new C4091a();
                c4091a = f15486a;
            }
        }
        return c4091a;
    }

    private void m20082a(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2712", "server command agent to refresh token");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshToken");
        if (jSONObject2.has("pkgs")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("pkgs");
            String[] strArr = new String[jSONArray.length()];
            String str = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                e.a("PushLogAC2712", "package need to refresh token:" + string);
                strArr[i] = string;
            }
            C4092b.m20089a(context, strArr);
            return;
        }
        e.a("PushLogAC2712", "all packages need to refresh token");
        C4092b.m20094c(context);
    }

    private void m20083b(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2712", "server command agent to refresh trs");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshTrs");
        if (jSONObject2.has("belongId")) {
            int i = jSONObject2.getInt("belongId");
            e.a("PushLogAC2712", "need to refresh trs in belongId:" + i);
            if (i >= 0) {
                a.a(context).a("belongId", Integer.valueOf(i));
            }
        }
        a.b(context);
    }

    private void m20084c(JSONObject jSONObject, Context context) throws JSONException {
        e.a("PushLogAC2712", "server command agent to refresh heartbeat");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshHb");
        if (jSONObject2.has("fixedWifiHb")) {
            int i = jSONObject2.getInt("fixedWifiHb");
            e.a("PushLogAC2712", "fixed heartbeat in wifi is " + i);
            if (i > 60) {
                a.a(context).a((long) i);
                a.a(context).b((long) i);
            } else {
                e.a("PushLogAC2712", "fixed heartbeat in wifi is invalid");
            }
        }
        if (jSONObject2.has("fixed3GHb")) {
            int i2 = jSONObject2.getInt("fixed3GHb");
            e.a("PushLogAC2712", "fixed heartbeat in 3g is " + i2);
            if (i2 > 60) {
                a.a(context).c((long) i2);
                a.a(context).d((long) i2);
            } else {
                e.a("PushLogAC2712", "fixed heartbeat in 3g is invalid");
            }
        }
        try {
            e.a("PushLogAC2712", "delete heartbeat files and reload heartbeat");
            com.huawei.android.pushagent.c.a.e(context, new C4073b(context).mo4363c());
            com.huawei.android.pushagent.b.a.a.e().f15412e.mo4365f();
        } catch (Throwable e) {
            e.c("PushLogAC2712", "delete heartbeat files or reload heartbeat error:" + e.getMessage(), e);
        }
    }

    public void m20085a(Context context, C4043b c4043b) {
        try {
            byte a = c4043b.mo4353a();
            if ((byte) -91 == a) {
                e.a("PushLogAC2712", "receive response from server");
            } else if (TagName.OPERATION_ID == a) {
                JSONObject c = c4043b.m19874c();
                if (c.has("refreshHb")) {
                    m20084c(c, context);
                } else if (c.has("refreshToken")) {
                    m20082a(c, context);
                } else if (c.has("refreshTrs")) {
                    m20083b(c, context);
                } else {
                    e.d("PushLogAC2712", "cannot parse the unknown message:" + c.toString());
                }
            }
        } catch (Throwable e) {
            e.c("PushLogAC2712", "parse json error:" + e.getMessage(), e);
        } catch (Throwable e2) {
            e.c("PushLogAC2712", "parse DecoupledPushMessage error: " + e2.getMessage(), e2);
        }
    }
}
