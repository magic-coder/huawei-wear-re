package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateOModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1390f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1410z;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: CheckUpdateVersionFactory */
public class C1638r {
    private static String f4249a = "CheckUpdateVersionFactory";
    private static C1413d f4250b;
    private static C1624d f4251c;

    public static C1624d m7755a(HomeActivity homeActivity, C1413d c1413d) {
        f4251c = new C1639s(homeActivity, c1413d, homeActivity);
        return f4251c;
    }

    public static void m7758a(Context context, boolean z) {
        C2538c.m12674b(f4249a, "==Enter CheckUpdateVersionFactory getImeiAndCheckNewVersion");
        if (z) {
            if (C1638r.m7765c(context)) {
                C2538c.m12674b(f4249a, "==Enter autoCheck new Version");
                f4251c.m7733a(context, z);
            }
            C2538c.m12674b(f4249a, "==Enter SharedPreferencesUtil.setBoolean = true");
            return;
        }
        f4251c.m7733a(context, z);
    }

    private static boolean m7765c(Context context) {
        C2538c.m12674b(f4249a, "==Enter startCheckNewVersion()");
        C1390f d = C1392h.m6304d(context, C1462f.m6744i(), C1462f.m6746j());
        C2538c.m12674b(f4249a, "==Enter isCheckNewVersion" + C1392h.m6304d(context, C1462f.m6744i(), C1462f.m6746j()));
        if (d == null || d.f3059b <= 0) {
            return true;
        }
        C2538c.m12674b(f4249a, "isCheckNewVersion:" + d.toString());
        if (d.f3059b != C1492l.m6920d(C1462f.m6746j())) {
            return true;
        }
        C2538c.m12674b(f4249a, "isCheckNewVersion:" + Math.abs(System.currentTimeMillis() - C1492l.m6922f(d.f3060c)));
        if (Math.abs(System.currentTimeMillis() - C1492l.m6922f(d.f3060c)) > LightCloudConstants.LightCloud_INTERVAL_TIME) {
            return true;
        }
        return false;
    }

    public static void m7762b(Context context, boolean z) {
        C2538c.m12674b(f4249a, "==autoCheckNewVersion== Enter autoCheckNewVersion");
        f4250b = C1417a.m6594a(context);
        WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
        watchStatusIOModel.deviceCode = C1462f.m6746j();
        C2538c.m12674b(f4249a, "==autoCheckNewVersion== mWatchStatusIOModel " + watchStatusIOModel.toString());
        C2538c.m12674b(f4249a, "==autoCheckNewVersion== entity ==" + f4250b);
        f4250b.mo2505a(watchStatusIOModel, new C1640t(context, z));
    }

    public static void m7764c(Context context, boolean z) {
        C2538c.m12674b(f4249a, "==Enter getStatusToUpdate()");
        CommonStateOModel commonStateOModel = new CommonStateOModel();
        commonStateOModel.type = "1";
        commonStateOModel.deviceCode = C1462f.m6746j();
        f4250b.mo2474a(commonStateOModel, new C1641u(context, z));
    }

    public static void m7757a(Context context) {
        boolean booleanValue = C1491k.m6893a(context, C1462f.m6746j() + "isHaveChangeLog").booleanValue();
        boolean equals = C1491k.m6899b(context, C1462f.m6746j() + "ruleAttr", "").equals("true");
        C2538c.m12674b(f4249a, "==ww===auto===isShowChangeLog" + booleanValue);
        C2538c.m12674b(f4249a, "isForceUpdateOrNot " + equals);
        C2538c.m12674b(f4249a, "ForcedUpdate is :" + C1491k.m6899b(context, C1462f.m6746j() + "ruleAttr", ""));
        if (equals) {
            C2538c.m12674b(f4249a, "Enter k1 force check new version and update");
            if (booleanValue) {
                C2538c.m12674b(f4249a, "==Enter K1 force update in time auto");
                if (C1638r.m7767d(context)) {
                    C2538c.m12674b(f4249a, "==Enter K1 force update in time auto");
                    C1638r.m7762b(context, true);
                    return;
                }
                C1638r.m7769e(context);
                return;
            }
            C1638r.m7762b(context, true);
            C2538c.m12674b(f4249a, "===Enter K1 force update check new Version");
            return;
        }
        C2538c.m12674b(f4249a, "Enter k1 auto check new version and update");
        C1638r.m7762b(context, true);
    }

    private static boolean m7767d(Context context) {
        C2538c.m12674b(f4249a, "==Enter startCheckNewVersion()");
        C1390f d = C1392h.m6304d(context, C1462f.m6744i(), C1462f.m6746j());
        C2538c.m12674b(f4249a, "==Enter isCheckNewVersion" + C1392h.m6304d(context, C1462f.m6744i(), C1462f.m6746j()));
        if (d == null || d.f3059b <= 0) {
            return true;
        }
        C2538c.m12674b(f4249a, "isCheckNewVersion:" + d.toString());
        if (d.f3059b != C1492l.m6920d(C1462f.m6746j())) {
            return true;
        }
        C2538c.m12674b(f4249a, "isCheckNewVersion:" + Math.abs(System.currentTimeMillis() - C1492l.m6922f(d.f3060c)));
        if (Math.abs(System.currentTimeMillis() - C1492l.m6922f(d.f3061d)) > LightCloudConstants.LightCloud_INTERVAL_TIME) {
            return true;
        }
        return false;
    }

    private static void m7769e(Context context) {
        C2538c.m12674b(f4249a, "====forceUpdate=== Enter showForceUpdateDialog");
        String b = C1491k.m6899b(context, C1462f.m6746j() + "kiwatchUpdateVersion", "");
        C2538c.m12674b(f4249a, "====forceUpdate=== afterVersion=" + b);
        C2538c.m12674b(f4249a, "====forceUpdate===KWCache.DEVICE_VERSION=" + C1462f.m6750l());
        if (b.equals(C1462f.m6750l())) {
            f4251c.m7744g();
            return;
        }
        C2538c.m12674b(f4249a, "==www===app version before and after equal");
        f4251c.m7742e();
    }

    public static void m7761b(Context context) {
        C2538c.m12674b(f4249a, "====Enter freshUpdateUI");
        C1410z e = C1392h.m6309e(context, C1462f.m6744i(), C1462f.m6746j());
        if (e != null) {
            C2538c.m12674b(f4249a, "====freshUpdateUI====table1:" + e.toString());
            f4251c.m7739b(true);
            f4251c.m7732a(e.f3211c, false);
        }
    }

    public static void m7759a(HomeActivity homeActivity) {
        C2538c.m12674b(f4249a, "==Enter saveRedPoint");
        boolean booleanValue = C1497q.m6944b(homeActivity, C1462f.m6746j()).booleanValue();
        C2538c.m12674b(f4249a, "==boolean isRed=" + booleanValue);
        if (homeActivity.f4132d.isAdded()) {
            if (!C1497q.m6945b((Context) homeActivity, "sharedpreferences_watch_device_code", C1462f.m6746j()).equals(C1462f.m6746j())) {
                C2538c.m12674b(f4249a, "==Enter saveRedPoint=" + r1);
            } else if (booleanValue) {
                C2538c.m12674b(f4249a, "==Enter saveRedPoint=UI");
                f4251c.m7741d();
            } else {
                C2538c.m12674b(f4249a, "==Enter saveNoRedPoint=");
                f4251c.m7742e();
            }
        }
    }

    public static void m7756a() {
        f4251c.m7737b();
    }

    public static void m7760b() {
        f4251c.m7740c();
    }

    public static void m7763c() {
        if (f4251c.f4204a != null) {
            f4251c.f4204a.dismiss();
        }
    }

    public static String m7766d() {
        return f4251c.m7745h();
    }
}
