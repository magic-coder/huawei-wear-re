package com.huawei.feedback.logic;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.bean.MetadataBundle;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements UncaughtExceptionHandler {
    public static final String TAG = "AppLogApi/CrashHandler";
    private Map<String, String> infos = new HashMap();
    private Context mContext;
    private UncaughtExceptionHandler mDefaultHandler;

    public synchronized void init(Context context) {
        C1373c.m6141d(TAG, "CrashHandler init");
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        if (this.mDefaultHandler != null) {
            C1373c.m6141d(TAG, "uncaughtException");
            if (handleException(th)) {
                onHandlerException(this.mContext, th);
            }
            this.mDefaultHandler.uncaughtException(thread, th);
        }
    }

    private boolean handleException(Throwable th) {
        if (th == null || this.mContext == null) {
            return false;
        }
        collectDeviceInfo(this.mContext);
        collectStackInfo(th);
        String str = (String) this.infos.get("errStack");
        MetadataBundle metadataBundle = new MetadataBundle(907121999, (String) this.infos.get("packageName"), (String) this.infos.get(CloudAccount.KEY_VERSION_NAME));
        metadataBundle.putData("errStack", str);
        metadataBundle.putData(XMLNode.TERMINAL_OS_VERSION, VERSION.RELEASE);
        AppLogApi.m2655e(TAG, metadataBundle.toString());
        Bundle bundle = new Bundle();
        bundle.putString("MetaData", metadataBundle.toString());
        bundle.putString("LogVersion", "1.0");
        bundle.putString("LogSubversion", "1.0");
        bundle.putString("ProductName", Build.MODEL);
        bundle.putString("ProductVersion", Build.DISPLAY);
        String l = C1372a.m6127l();
        String q = C0811c.m2810q(this.mContext);
        if (TextUtils.isEmpty(q)) {
            q = l;
        }
        bundle.putString("SN", l);
        bundle.putString("IMEI", q);
        bundle.putString("Eventid", String.valueOf(907121999));
        bundle.putString("HappenTime", "" + System.currentTimeMillis());
        Intent intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_REQUEST");
        C1373c.m6141d(TAG, "CrashHandler no hasPhoneServiceAutoUpload!");
        intent.setClassName(this.mContext, "com.huawei.feedback.component.AutoUploadService");
        intent.putExtra("uploadFile", false);
        intent.putExtra("metaData", bundle);
        try {
            this.mContext.startService(intent);
        } catch (Exception e) {
            intent.setClassName(this.mContext, "com.huawei.feedback.component.AutoUploadService");
            try {
                this.mContext.startService(intent);
            } catch (Exception e2) {
                C1373c.m6141d(TAG, "CrashHandler start AutoUploadService intent error");
            }
        }
        return true;
    }

    public void onHandlerException(Context context, Throwable th) {
        C1373c.m6141d(TAG, "onHandlerException");
    }

    public Map<String, String> collectDeviceInfo(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            this.infos.put("packageName", context.getPackageName());
            if (packageInfo != null) {
                this.infos.put(CloudAccount.KEY_VERSION_NAME, packageInfo.versionName == null ? "null" : packageInfo.versionName);
            }
        } catch (NameNotFoundException e) {
            C1373c.m6141d(TAG, "an error occured when collect package info" + e.getMessage());
        }
        return this.infos;
    }

    private void collectStackInfo(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        this.infos.put("errStack", stringWriter.toString());
    }
}
