package com.huawei.android.pushagent.p018c;

import android.content.Context;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import java.util.Map;

public class C4123h {
    public static synchronized void m20165a(Context context) {
        synchronized (C4123h.class) {
            h hVar = new h(context, "pushConfig");
            int c = hVar.c("version_config");
            if (c != 2) {
                e.b("PushLogAC2712", "update xml data, old version is " + c + ",new version is " + 2);
                if (c < 2) {
                    C4123h.m20167b(context);
                }
                hVar.a("version_config", Integer.valueOf(2));
            }
        }
    }

    private static void m20166a(Context context, String str) {
        Map b = new h(context, str).b();
        if (b != null && b.size() > 0) {
            h hVar = new h(context, "pclient_request_info");
            for (String str2 : b.keySet()) {
                hVar.a(str2, "true");
                e.a("PushLogAC2712", str2 + " need to register again");
            }
        }
        a.e(context, str);
    }

    private static void m20167b(Context context) {
        new h(context, SdkConstants.DEVICE_INFO).c();
        new h(context, "PushRouteInfo").f("PushID");
        new h(context, "pushConfig").f("selftoken");
        new h(context, "push_client_self_info").f("token_info");
        new h(context, "PushRouteInfo").f("PushID_encrypt");
        new h(context, "pushConfig").f("selftoken_encrypt");
        new h(context, "push_client_self_info").f("token_info_encrypt");
        a.e(context, "pclient_unRegist_info");
        C4123h.m20166a(context, "pclient_info_encrypt");
        C4123h.m20166a(context, "pclient_info");
    }
}
