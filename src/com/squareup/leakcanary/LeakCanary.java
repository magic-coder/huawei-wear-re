package com.squareup.leakcanary;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.squareup.leakcanary.internal.DisplayLeakActivity;
import com.squareup.leakcanary.internal.HeapAnalyzerService;
import com.squareup.leakcanary.internal.LeakCanaryInternals;

public final class LeakCanary {
    public static RefWatcher install(Application application) {
        return ((AndroidRefWatcherBuilder) refWatcher(application).listenerServiceClass(DisplayLeakService.class).excludedRefs(AndroidExcludedRefs.createAppDefaults().build())).buildAndInstall();
    }

    public static AndroidRefWatcherBuilder refWatcher(Context context) {
        return new AndroidRefWatcherBuilder(context);
    }

    public static void enableDisplayLeakActivity(Context context) {
        LeakCanaryInternals.setEnabled(context, DisplayLeakActivity.class, true);
    }

    public static void setDisplayLeakActivityDirectoryProvider(LeakDirectoryProvider leakDirectoryProvider) {
        DisplayLeakActivity.setLeakDirectoryProvider(leakDirectoryProvider);
    }

    public static String leakInfo(Context context, HeapDump heapDump, AnalysisResult analysisResult, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String str = packageInfo.versionName;
            String str2 = "In " + packageName + ":" + str + ":" + packageInfo.versionCode + ".\n";
            packageName = "";
            if (analysisResult.leakFound) {
                if (analysisResult.excludedLeak) {
                    str2 = str2 + "* EXCLUDED LEAK.\n";
                }
                str2 = str2 + "* " + analysisResult.className;
                if (!heapDump.referenceName.equals("")) {
                    str2 = str2 + " (" + heapDump.referenceName + ")";
                }
                str = (str2 + " has leaked:\n" + analysisResult.leakTrace.toString() + "\n") + "* Retaining: " + Formatter.formatShortFileSize(context, analysisResult.retainedHeapSize) + ".\n";
                if (z) {
                    str2 = "\n* Details:\n" + analysisResult.leakTrace.toDetailedString();
                    packageName = str;
                } else {
                    str2 = packageName;
                    packageName = str;
                }
            } else if (analysisResult.failure != null) {
                r5 = packageName;
                packageName = str2 + "* FAILURE in 1.5.1 1be44b3:" + Log.getStackTraceString(analysisResult.failure) + "\n";
                str2 = r5;
            } else {
                r5 = packageName;
                packageName = str2 + "* NO LEAK FOUND.\n\n";
                str2 = r5;
            }
            if (z) {
                str2 = str2 + "* Excluded Refs:\n" + heapDump.excludedRefs;
            }
            return packageName + "* Reference Key: " + heapDump.referenceKey + "\n* Device: " + Build.MANUFACTURER + HwAccountConstants.BLANK + Build.BRAND + HwAccountConstants.BLANK + Build.MODEL + HwAccountConstants.BLANK + Build.PRODUCT + "\n* Android Version: " + VERSION.RELEASE + " API: " + VERSION.SDK_INT + " LeakCanary: " + BuildConfig.LIBRARY_VERSION + HwAccountConstants.BLANK + BuildConfig.GIT_SHA + "\n* Durations: watch=" + heapDump.watchDurationMs + "ms, gc=" + heapDump.gcDurationMs + "ms, heap dump=" + heapDump.heapDumpDurationMs + "ms, analysis=" + analysisResult.analysisDurationMs + "ms\n" + str2;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isInAnalyzerProcess(Context context) {
        return LeakCanaryInternals.isInServiceProcess(context, HeapAnalyzerService.class);
    }

    private LeakCanary() {
        throw new AssertionError();
    }
}
