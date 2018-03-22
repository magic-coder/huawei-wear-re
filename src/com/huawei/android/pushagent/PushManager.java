package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.c.c.d;
import com.huawei.android.pushagent.p018c.C4120e;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4100f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class PushManager {
    private static Map m19844a(Context context, Map map) {
        Map hashMap = new HashMap();
        h hVar = new h(context, "tags_info");
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (hVar.e(str)) {
                String b = hVar.b(str);
                if (!TextUtils.isEmpty(str2) && str2.equals(b)) {
                    e.a("PushLogAC2712", "tag has reported:" + entry);
                }
            }
            hashMap.put(str, str2);
        }
        return hashMap;
    }

    public static synchronized void deleteTags(Context context, List list) throws PushException {
        synchronized (PushManager.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        JSONArray jSONArray = new JSONArray();
                        h hVar = new h(context, "tags_info");
                        for (String str : list) {
                            if (hVar.e(str)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("tagKey", str);
                                jSONObject.put("opType", 2);
                                if (jSONObject.length() > 0) {
                                    jSONArray.put(jSONObject);
                                }
                            } else {
                                e.a("PushLogAC2712", str + " not exist, need not to remove");
                            }
                        }
                        if (jSONArray.length() > 0) {
                            e.a("PushLogAC2712", "begin to deleTags: " + jSONArray.toString());
                            C4120e.m20163a(context, jSONArray.toString(), 0, 2);
                        } else {
                            e.b("PushLogAC2712", "no tag need to delete");
                        }
                    }
                } catch (Exception e) {
                    e.b("PushLogAC2712", e.toString());
                    throw new PushException("delete tags failed");
                }
            }
        }
    }

    public static final void deregisterToken(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("PushLogAC2712", "token is null, can not deregister token");
            return;
        }
        String str2;
        if (TextUtils.isEmpty(a.r(context))) {
            if (a.o(context)) {
                e.a("PushLogAC2712", "votedPackage is null, deregister token from frameworkPush");
                str2 = "android";
            } else {
                e.a("PushLogAC2712", "votedPackage is null and not exist frameworkPush, can not deregister token");
                return;
            }
        }
        str2 = C4100f.m20113a(context, str);
        Intent intent = new Intent("com.huawei.android.push.intent.DEREGISTER");
        intent.putExtra("pkg_name", context.getPackageName());
        intent.putExtra("device_token", str2);
        intent.putExtra("isTokenEncrypt", true);
        d.a(context, intent);
    }

    public static final void enableReceiveNormalMsg(Context context, boolean z) {
        if (context == null) {
            e.a("PushLogAC2712", "context is null");
        } else {
            new h(context, "push_switch").a("normal_msg_enable", !z);
        }
    }

    public static final void enableReceiveNotifyMsg(Context context, boolean z) {
        if (context == null) {
            e.a("PushLogAC2712", "context is null");
        } else {
            new h(context, "push_switch").a("notify_msg_enable", !z);
        }
    }

    public static synchronized Map getTags(Context context) throws PushException {
        Map b;
        synchronized (PushManager.class) {
            try {
                b = new h(context, "tags_info").b();
            } catch (Exception e) {
                e.b("PushLogAC2712", e.toString());
                throw new PushException("get tags failed");
            }
        }
        return b;
    }

    public static void requestPushState(Context context) {
        PushReceiver.getPushState(context);
    }

    public static void requestToken(Context context) {
        PushReceiver.getToken(context);
    }

    public static synchronized void setTags(Context context, Map map) throws PushException {
        synchronized (PushManager.class) {
            if (map != null) {
                Map a = m19844a(context, map);
                try {
                    h hVar = new h(context, "tags_info");
                    JSONArray jSONArray = new JSONArray();
                    for (Entry entry : a.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tagKey", str);
                        jSONObject.put("tagValue", str2);
                        jSONObject.put("opType", 1);
                        if (jSONObject.length() > 0) {
                            jSONArray.put(jSONObject);
                        }
                        hVar.a(str, str2);
                    }
                    if (jSONArray.length() > 0) {
                        e.a("PushLogAC2712", "begin to setTags: " + jSONArray.toString());
                        C4120e.m20163a(context, jSONArray.toString(), 0, 2);
                    } else {
                        e.b("PushLogAC2712", "no tag need to upload");
                    }
                } catch (Exception e) {
                    e.b("PushLogAC2712", e.toString());
                    throw new PushException("set tags failed");
                }
            }
        }
    }
}
