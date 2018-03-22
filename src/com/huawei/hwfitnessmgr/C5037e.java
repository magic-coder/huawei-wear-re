package com.huawei.hwfitnessmgr;

import android.content.Context;
import com.huawei.af.C3991a;
import com.huawei.al.C4028a;
import com.huawei.hwdataaccessmodel.a.c;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;

/* compiled from: FitnessMgrSharePreference */
public class C5037e {
    public static long m24291a(q qVar) {
        String sharedPreference = qVar.getSharedPreference("kStorage_FitnessMgr_Long_LastSyncTodayTime");
        if (sharedPreference == null || sharedPreference.isEmpty()) {
            return 0;
        }
        return (long) Integer.parseInt(sharedPreference);
    }

    public static void m24294a(q qVar, long j) {
        c cVar = new c();
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" setLastStatusTime lastTimeStamp=" + j});
        qVar.setSharedPreference("kStorage_FitnessMgr_Long_LastStatusTimeStamp", C4028a.m19823a() + "|" + Long.toString(j), cVar);
    }

    public static long m24296b(q qVar) {
        long j = 0;
        String sharedPreference = qVar.getSharedPreference("kStorage_FitnessMgr_Long_LastStatusTimeStamp");
        if (!(sharedPreference == null || sharedPreference.isEmpty())) {
            String[] split = sharedPreference.split("\\|");
            try {
                if (split.length == 2 && split[0].equals(C4028a.m19823a())) {
                    j = (long) Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                C2538c.c("FitnessMgrSharePreference", new Object[]{" getLastStatusTime error:" + e});
            }
        }
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" getLastStatusTime lastTimeStamp=" + j});
        return j;
    }

    public static boolean m24298c(q qVar) {
        String sharedPreference = qVar.getSharedPreference("kStorage_FitnessMgr_Boolean_ReverseSyncEnable");
        C2538c.c("FitnessMgrSharePreference", new Object[]{" getReverseDataSyncEnable :" + sharedPreference});
        return false;
    }

    public static void m24292a(Context context, int i) {
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" setCoreSleepButtonEnable =" + i});
        String num = Integer.toString(i);
        c cVar = new c();
        cVar.a = 0;
        a.a(context, String.valueOf(30), "kStorage_CoreSleepMgr_Int_ButtonEnable", num, cVar);
        C5037e.m24293a(context, num);
        C3991a a = C3991a.m19745a(context);
        if (a == null) {
            C2538c.e("FitnessMgrSharePreference", new Object[]{"mHwCombineMigrateMgr is null"});
            return;
        }
        a.m19768e(num, false);
    }

    public static int m24290a(Context context) {
        int parseInt;
        String a = a.a(context, String.valueOf(30), "kStorage_CoreSleepMgr_Int_ButtonEnable");
        C2538c.c("FitnessMgrSharePreference", new Object[]{" getCoreSleepButtonEnable str =" + a});
        if (!(a == null || a.isEmpty())) {
            try {
                parseInt = Integer.parseInt(a);
            } catch (Exception e) {
                C2538c.c("FitnessMgrSharePreference", new Object[]{" getCoreSleepButtonEnable error:" + e.getMessage()});
            }
            C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" getCoreSleepButtonEnable enable=" + parseInt});
            return parseInt;
        }
        parseInt = 0;
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" getCoreSleepButtonEnable enable=" + parseInt});
        return parseInt;
    }

    private static void m24293a(Context context, String str) {
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{"setCoreSleepSwitchUpload enter state, mCoreSleepSwitch = " + str});
        new C5038f(str, context).start();
    }

    public static void m24297b(Context context, int i) {
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" setHeartRateButtonEnable =" + i});
        String num = Integer.toString(i);
        c cVar = new c();
        cVar.a = 0;
        a.a(context, String.valueOf(1011), "kStorage_HeartRate_Int_ButtonEnable", num, cVar);
        C3991a a = C3991a.m19745a(context);
        if (a == null) {
            C2538c.e("FitnessMgrSharePreference", new Object[]{"mHwCombineMigrateMgr is null"});
            return;
        }
        a.m19771h(num, false);
    }

    public static int m24295b(Context context) {
        int parseInt;
        String a = a.a(context, String.valueOf(1011), "kStorage_HeartRate_Int_ButtonEnable");
        C2538c.c("FitnessMgrSharePreference", new Object[]{" getHeartRateButtonEnable str =" + a});
        if (!(a == null || a.isEmpty())) {
            try {
                parseInt = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                C2538c.c("FitnessMgrSharePreference", new Object[]{" getHeartRateButtonEnable error:" + e.getMessage()});
            }
            C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" getHeartRateButtonEnable enable=" + parseInt});
            return parseInt;
        }
        parseInt = 0;
        C2538c.a("05", 1, "FitnessMgrSharePreference", new Object[]{" getHeartRateButtonEnable enable=" + parseInt});
        return parseInt;
    }
}
