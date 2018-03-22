package com.huawei.p464l.p465a;

import android.content.Context;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.p464l.p466b.C5418a;
import com.huawei.p500q.p501a.C5886a;
import java.util.Map;

/* compiled from: BIAnalyticsUtil */
public class C5417c {
    private static C5417c f19234a;

    public static C5417c m26022a() {
        if (f19234a == null) {
            C5418a.m26029a("BIAnalyticsUtil", "getInstance()");
            f19234a = new C5417c();
        }
        return f19234a;
    }

    public void m26026a(String str) {
        if (!i.a(43)) {
            return;
        }
        if (C5886a.m27079a()) {
            C5416b.m26019a(str);
            C5418a.m26029a("BIAnalyticsUtil", "setUserInfo()");
            return;
        }
        C5418a.m26031c("BIAnalyticsUtil", "setUserInfo() AnalyticsStatus is false");
    }

    public void m26025a(C5415a c5415a) {
        if (!i.a(43)) {
            return;
        }
        if (C5886a.m27079a()) {
            C5416b.m26018a(c5415a);
            C5418a.m26029a("BIAnalyticsUtil", "setDeviceInfo()");
            return;
        }
        C5418a.m26031c("BIAnalyticsUtil", "setDeviceInfo() AnalyticsStatus is false");
    }

    public int m26023a(Context context, String str, Map<String, Object> map, int i) {
        if (!i.a(43) || w.b()) {
            C5418a.m26031c("BIAnalyticsUtil", "setEvent() VersionConfig.isFeatureSupport(FeatureId.SUPPORT_BI) = " + i.a(43));
            return -1;
        } else if ("release".equals("release") && i != 0) {
            C5418a.m26029a("BIAnalyticsUtil", "setEvent() level =" + i + " BuildConfig.BUILD_TYPE = " + "release");
            return -1;
        } else if (C5886a.m27079a()) {
            C5418a.m26029a("BIAnalyticsUtil", "setEvent()");
            return C5416b.m26016a(context, str, map);
        } else {
            C5418a.m26031c("BIAnalyticsUtil", "setEvent() AnalyticsStatus is false");
            return -1;
        }
    }

    public void m26024a(Context context) {
        if (i.a(43) && !w.b()) {
            if (C5886a.m27079a()) {
                C5416b.m26017a(context);
            } else {
                C5418a.m26031c("BIAnalyticsUtil", "onReport() AnalyticsStatus is false");
            }
        }
    }

    public void m26027b(Context context) {
        if (i.a(43) && !w.b()) {
            if (C5886a.m27079a()) {
                C5416b.m26020b(context);
            } else {
                C5418a.m26031c("BIAnalyticsUtil", "onResume() AnalyticsStatus is false");
            }
        }
    }

    public void m26028c(Context context) {
        if (i.a(43) && !w.b()) {
            if (C5886a.m27079a()) {
                C5416b.m26021c(context);
            } else {
                C5418a.m26031c("BIAnalyticsUtil", "onPause() AnalyticsStatus is false");
            }
        }
    }
}
