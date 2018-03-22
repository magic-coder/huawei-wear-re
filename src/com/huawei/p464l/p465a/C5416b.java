package com.huawei.p464l.p465a;

import android.content.Context;
import com.c.a.c.a;
import com.huawei.p464l.p466b.C5418a;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BIAnalyticsImpl */
public class C5416b {
    private static JSONObject f19233a = new JSONObject();

    protected static void m26017a(Context context) {
        a.c(context);
        C5418a.m26030b("BIAnalyticsImpl", "onReport() context = " + context);
    }

    protected static void m26020b(Context context) {
        a.a(Long.valueOf(48));
        a.b(context);
        C5418a.m26030b("BIAnalyticsImpl", "onResume() context = " + context);
    }

    protected static void m26021c(Context context) {
        a.a(context);
        C5418a.m26030b("BIAnalyticsImpl", "onPause() context = " + context);
    }

    protected static int m26016a(Context context, String str, Map<String, Object> map) {
        try {
            f19233a.remove("CONTENT");
            if (map == null) {
                f19233a.put("CONTENT", "[]");
            } else {
                f19233a.put("CONTENT", "[" + new JSONObject(map).toString() + "]");
            }
            C5418a.m26030b("BIAnalyticsImpl", f19233a.toString());
            a.a(context, str, f19233a.toString());
            return 0;
        } catch (Exception e) {
            C5418a.m26031c("BIAnalyticsImpl", e.getMessage());
            return -1;
        }
    }

    protected static void m26019a(String str) {
        try {
            f19233a.put("ID", str);
            f19233a.put("DT", "");
            f19233a.put("DID", "");
            f19233a.put("DV", "");
            C5418a.m26030b("BIAnalyticsImpl", "setUserInfo() userInfo = " + str);
        } catch (Exception e) {
            C5418a.m26031c("BIAnalyticsImpl", e.getMessage());
        }
    }

    protected static void m26018a(C5415a c5415a) {
        try {
            f19233a.put("DT", c5415a.m26010a());
            f19233a.put("DID", c5415a.m26012b());
            f19233a.put("DV", c5415a.m26014c());
            C5418a.m26030b("BIAnalyticsImpl", "setDeviceInfo() DT = " + c5415a.m26010a() + " DID = " + c5415a.m26012b() + " DV = " + c5415a.m26014c());
        } catch (Exception e) {
            C5418a.m26031c("BIAnalyticsImpl", e.getMessage());
        }
    }
}
