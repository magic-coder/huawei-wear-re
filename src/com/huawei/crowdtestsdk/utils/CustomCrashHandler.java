package com.huawei.crowdtestsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.uploadlog.p188c.C2511g;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map.Entry;

public class CustomCrashHandler implements UncaughtExceptionHandler {
    private static CustomCrashHandler mInstance = new CustomCrashHandler();
    private Context mContext;

    private CustomCrashHandler() {
    }

    public static CustomCrashHandler getInstance() {
        return mInstance;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        saveErrorInfoToLog(this.mContext, th);
        Log.e("BETACLUB_SDK", "[CustomCrashHandler.uncaughtException]Throwable : ", th);
        showToast(this.mContext, "很抱歉，程序遭遇异常，即将退出！");
        try {
            Thread.sleep(2000);
        } catch (Throwable e) {
            Log.e("BETACLUB_SDK", "[CustomCrashHandler.uncaughtException]InterruptedException", e);
            C2511g.m12482b("BETACLUB_SDK", "[CustomCrashHandler.uncaughtException]InterruptedException", e);
        }
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager != null) {
            activityManager.forceStopPackage(this.mContext.getPackageName());
        }
    }

    public void setCustomCrashHanler(Context context) {
        this.mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void showToast(final Context context, final String str) {
        new Thread(new Runnable() {
            public void run() {
                Looper.prepare();
                Toast.makeText(context, str, 1).show();
                Looper.loop();
            }
        }).start();
    }

    private HashMap<String, String> obtainSimpleInfo(Context context) {
        PackageInfo packageInfo;
        HashMap<String, String> hashMap = new HashMap();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[CustomCrashHandler.obtainSimpleInfo]NameNotFoundException", e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            hashMap.put(CloudAccount.KEY_VERSION_NAME, packageInfo.versionName);
            hashMap.put("versionCode", "" + packageInfo.versionCode);
        }
        hashMap.put("MODEL", "" + Build.MODEL);
        hashMap.put("SDK_INT", "" + VERSION.SDK_INT);
        hashMap.put("PRODUCT", "" + Build.PRODUCT);
        return hashMap;
    }

    private String obtainExceptionInfo(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        Log.e("BETACLUB_SDK", stringWriter.toString());
        return stringWriter.toString();
    }

    private void saveErrorInfoToLog(Context context, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : obtainSimpleInfo(context).entrySet()) {
            String str = (String) entry.getKey();
            stringBuffer.append(str).append(" = ").append((String) entry.getValue()).append("\n");
        }
        stringBuffer.append(obtainExceptionInfo(th));
        Log.e("BETACLUB_SDK", stringBuffer.toString(), th);
        C2511g.m12482b("BETACLUB_SDK", stringBuffer.toString(), th);
    }
}
