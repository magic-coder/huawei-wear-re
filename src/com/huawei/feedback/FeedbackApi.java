package com.huawei.feedback;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.feedback.ui.FeedbackEditActivity;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.phoneserviceuni.common.c.a.a;
import com.huawei.phoneserviceuni.common.d.b;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.C1371b;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a.C1370a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FeedbackApi {
    private static final String TAG = "FeedbackApi";
    private static String aesSecret = "";
    private static String appId_str = "";
    private static Context applicationcontext;
    private static LogCollectManager logCollectManager = null;
    private static String logfilePath = "";
    private static String logsdcardpath = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Huawei/phoneservice");
    private static String logwritePath = "";
    private static String logzipPath = "";

    public static Context getApplicationcontext() {
        return applicationcontext;
    }

    public static void setApplicationcontext(Context context) {
        applicationcontext = context;
    }

    public static LogCollectManager getLogCollectManager() {
        return logCollectManager;
    }

    public static void setLogCollectManager(LogCollectManager logCollectManager) {
        logCollectManager = logCollectManager;
    }

    public static int gotoFeedback(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return 1001;
        }
        setApplicationcontext(context.getApplicationContext());
        a.a().a(context.getApplicationContext());
        appId_str = bundle.getString(AppOpenOrDownHelper.APP_ID_PARAM);
        String string = bundle.getString("questionType");
        logfilePath = bundle.getString("logfilePath");
        aesSecret = bundle.getString("aesSecret");
        logwritePath = bundle.getString("logwritePath");
        String string2 = bundle.getString("packageName");
        String string3 = bundle.getString("packageVersion");
        ArrayList stringArrayList = bundle.getStringArrayList("logwritePathList");
        boolean z = bundle.getBoolean("displayHotline");
        CharSequence g = C0811c.m2800g(getApplicationcontext());
        if (TextUtils.isEmpty(g)) {
            String str = string;
        } else {
            Object obj = g;
        }
        if (TextUtils.isEmpty(appId_str) || TextUtils.isEmpty(obj)) {
            return 1001;
        }
        try {
            int parseInt = Integer.parseInt(appId_str);
            if (!TextUtils.isEmpty(logfilePath) && TextUtils.isEmpty(aesSecret)) {
                return 1001;
            }
            if (TextUtils.isEmpty(logfilePath)) {
                if (TextUtils.isEmpty(logwritePath)) {
                    logwritePath = context.getFilesDir().getPath() + File.separator + "feedbacklogs";
                }
                string = Build.MODEL;
                String str2 = Build.DISPLAY;
                String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String a = C1371b.m6104a(C1372a.m6117c(context).toUpperCase(Locale.US));
                String str3 = "app-" + context.getPackageName();
                String b = C1372a.m6114b(context.getPackageName(), context);
                string = string.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
                str2 = str2.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
                str3 = str3.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
                if (b != null) {
                    b = b.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
                }
                String str4 = "/" + string + HwAccountConstants.SPLIIT_UNDERLINE + str2 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + b + HwAccountConstants.SPLIIT_UNDERLINE + appId_str + LightCloudConstants.ZIP_POSTFIX;
                logzipPath = logwritePath + ("/temp_" + string + HwAccountConstants.SPLIIT_UNDERLINE + str2 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + b + HwAccountConstants.SPLIIT_UNDERLINE + appId_str + LightCloudConstants.ZIP_POSTFIX);
                logfilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Huawei/phoneservice" + str4;
                byte[] bArr = new byte[11];
                C0821e.m2884a(bArr);
                aesSecret = "AESV2" + Base64.encodeToString(bArr, 2);
                if (C0811c.m2806m(context) || C0811c.m2796e()) {
                    new Thread(new com.huawei.feedback.logic.a(logfilePath, logzipPath, logwritePath, aesSecret, appId_str, logsdcardpath, stringArrayList, true, context)).start();
                }
            } else {
                new Thread(new a()).start();
            }
            try {
                setLogCollectManager(new LogCollectManager(context));
            } catch (Exception e) {
                C1373c.m6141d(TAG, "The init of the object logCollectManager is exception!");
            }
            Intent intent = new Intent("com.huawei.phoneservice.FEEDBACK");
            intent.putExtra(AppOpenOrDownHelper.APP_ID_PARAM, parseInt);
            intent.putExtra("questionType", obj);
            intent.putExtra("logfilePath", logfilePath);
            if (!aesSecret.startsWith("AESV2")) {
                aesSecret = "AESV2" + aesSecret;
            }
            intent.putExtra("aesSecret", aesSecret);
            intent.putExtra("packageName", string2);
            intent.putExtra("packageVersion", string3);
            intent.putExtra("displayHotline", z);
            if (1 == parseInt) {
                intent.setPackage(context.getPackageName());
            } else if (C0811c.m2771a(context)) {
                C1373c.m6140c(TAG, "has phoneservice apk");
                intent.setPackage("com.huawei.phoneservice");
            } else {
                C1373c.m6140c(TAG, "not has phoneservice apk");
                intent.setClass(context, FeedbackEditActivity.class);
            }
            try {
                context.startActivity(intent);
            } catch (Exception e2) {
                intent.setClass(context, FeedbackEditActivity.class);
                try {
                    context.startActivity(intent);
                } catch (Exception e3) {
                    C1373c.m6141d(TAG, "start feedback intent error");
                    return 1002;
                }
            }
            return 0;
        } catch (Exception e4) {
            return 1001;
        }
    }

    public static void aesEncryptFile(File file, String str, String str2) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        OutputStream outputStream = null;
        if (TextUtils.isEmpty(str) || file == null || file.getName() == null || TextUtils.isEmpty(str2)) {
            C1373c.m6141d(TAG, "aesEncryptFile input null!");
        } else if (!file.getName().endsWith(LightCloudConstants.ZIP_POSTFIX) || file.length() > 5242880) {
            C1373c.m6141d(TAG, "aesEncryptFile wrong!");
        } else {
            String str3 = "AESV2" + str;
            File file2 = new File(str2);
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                if (!parentFile.exists()) {
                    C1373c.m6139b(TAG, "文件夹不存在，创建文件夹");
                    if (!parentFile.mkdirs()) {
                        C1373c.m6141d(TAG, "文件夹不存在，创建文件夹失败");
                        return;
                    }
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (FileNotFoundException e) {
                        fileOutputStream = null;
                        inputStream = fileInputStream;
                        try {
                            C1373c.m6141d(TAG, "FileNotFound");
                            b.a(inputStream, TAG);
                            b.a(fileOutputStream, TAG);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = inputStream;
                            outputStream = fileOutputStream;
                            th2 = th;
                            b.a(fileInputStream, TAG);
                            b.a(outputStream, TAG);
                            throw th2;
                        }
                    } catch (IOException e2) {
                        fileOutputStream = null;
                        try {
                            C1373c.m6141d(TAG, "IOException");
                            b.a(fileInputStream, TAG);
                            b.a(fileOutputStream, TAG);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            outputStream = fileOutputStream;
                            th2 = th;
                            b.a(fileInputStream, TAG);
                            b.a(outputStream, TAG);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        b.a(fileInputStream, TAG);
                        b.a(outputStream, TAG);
                        throw th2;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                byte[] a = C1370a.m6102a(bArr, 0, read, str3);
                                if (a != null) {
                                    fileOutputStream.write(a, 0, a.length);
                                }
                            } else {
                                b.a(fileInputStream, TAG);
                                b.a(fileOutputStream, TAG);
                                return;
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        inputStream = fileInputStream;
                        C1373c.m6141d(TAG, "FileNotFound");
                        b.a(inputStream, TAG);
                        b.a(fileOutputStream, TAG);
                        return;
                    } catch (IOException e4) {
                        C1373c.m6141d(TAG, "IOException");
                        b.a(fileInputStream, TAG);
                        b.a(fileOutputStream, TAG);
                        return;
                    }
                } catch (FileNotFoundException e5) {
                    fileOutputStream = null;
                    C1373c.m6141d(TAG, "FileNotFound");
                    b.a(inputStream, TAG);
                    b.a(fileOutputStream, TAG);
                    return;
                } catch (IOException e6) {
                    fileOutputStream = null;
                    fileInputStream = null;
                    C1373c.m6141d(TAG, "IOException");
                    b.a(fileInputStream, TAG);
                    b.a(fileOutputStream, TAG);
                    return;
                } catch (Throwable th6) {
                    th2 = th6;
                    fileInputStream = null;
                    b.a(fileInputStream, TAG);
                    b.a(outputStream, TAG);
                    throw th2;
                }
            }
            C1373c.m6141d(TAG, "filelocation null");
        }
    }
}
