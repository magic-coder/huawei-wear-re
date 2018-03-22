package com.huawei.wallet.logic.bi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.wallet.utils.PackageUtil;
import com.huawei.wallet.utils.TimeUtil;
import com.huawei.wallet.utils.log.LogC;

public class AppStartHianalytics {
    private static long f21197a;
    private static boolean f21198b = true;

    final class C61461 implements Runnable {
        final /* synthetic */ Context f21196a;

        C61461(Context context) {
            this.f21196a = context;
        }

        public void run() {
            AppStartHianalytics.m27963d(this.f21196a);
        }
    }

    public static void m27958a() {
        f21197a = System.currentTimeMillis();
        LogC.m28530b("onPause,   begin timing.", false);
    }

    public static void m27959a(Context context) {
        if (f21198b) {
            f21198b = false;
            LogC.m28530b("onResume,  first onReport", false);
            m27962c(context);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f21197a;
        LogC.m28530b("onResume,   end timing. continueMillis is " + currentTimeMillis, false);
        if (currentTimeMillis >= 180000) {
            m27962c(context);
        }
    }

    private static void m27962c(Context context) {
        new Thread(new C61461(context), "AppStartReportThread").start();
    }

    private static void m27963d(Context context) {
        if (context == null) {
            LogC.m28534d("onReport,context is null.", false);
        } else if (!HiAnalyticsManager.m27965a(context)) {
            String a = TimeUtil.m28480a("yyyy-MM-dd HH:mm:ss");
            String str = Build.MODEL;
            String str2 = Build.DISPLAY;
            String str3 = VERSION.RELEASE;
            String a2 = PackageUtil.m28460a(context);
            String c = PackageUtil.m28464c(context);
            String b = m27960b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            stringBuilder.append("|");
            stringBuilder.append(str3);
            stringBuilder.append("|");
            stringBuilder.append(a2);
            stringBuilder.append("|");
            stringBuilder.append(b);
            stringBuilder.append("|");
            stringBuilder.append(c);
            LogC.m28530b("wallet app start report bi success.", false);
            HiAnalyticsManager.m27964a(context, "WALLET_BASIC", stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    private static String m27960b() {
        return "";
    }
}
