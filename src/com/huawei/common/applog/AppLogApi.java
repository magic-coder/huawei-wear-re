package com.huawei.common.applog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.v4.view.GravityCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.common.applog.bean.Event;
import com.huawei.common.applog.bean.a;
import com.huawei.feedback.C0809b;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.C0821e;
import com.huawei.feedback.bean.C0810a;
import com.huawei.feedback.component.AutoUploadService;
import com.huawei.feedback.logic.CrashHandler;
import com.huawei.feedback.p033a.p034a.C0806a;
import com.huawei.feedback.p033a.p034a.C0807b;
import com.huawei.feedback.p033a.p035b.C0808a;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.phoneserviceuni.common.d.b;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.C1371b;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLogApi {
    private static final String TAG = "AppLogApi";
    private static List<C0810a> autonologlist = null;
    private static List<C0810a> autouploadloglist = new ArrayList();
    private static long firstTime = 0;
    private static boolean isHttpProtocol = true;
    private static String key = "";
    private static String logSubversion = "1";
    private static String logVersion = "1";
    private static String logfilePath = "";
    private static Context mContext = null;
    private static Bundle mMetaData = null;
    private static boolean mUploadFile = false;
    private static Handler myHandler = new 1(Looper.getMainLooper());
    private static int reportCycle;
    private static Handler reportHandler = new 3(Looper.getMainLooper());
    private static int sysLevel = 2;

    public static List<C0810a> getAutonologlist() {
        return autonologlist;
    }

    public static List<C0810a> getAutouploadloglist() {
        return autouploadloglist;
    }

    public static void init(Context context, Param param) {
        int i;
        int i2 = 1024;
        int i3 = -1;
        new CrashHandler().init(context);
        String str = "";
        boolean z = false;
        if (param != null) {
            int logLevel = param.getLogLevel();
            if (logLevel != -1) {
                sysLevel = logLevel;
            }
            logLevel = param.getPerFileSize();
            if (logLevel > 0) {
                if (logLevel <= 1024) {
                    i2 = logLevel;
                }
                logLevel = i2 * 1024;
            }
            i3 = param.getLogFileMaxnum();
            str = param.getLogWritePath();
            z = param.getShutdown_Immediate();
            reportCycle = d.a(param.getReportCycle());
            C1373c.m6141d("ReportApi", "init reportCycle==" + reportCycle);
            isHttpProtocol = param.getHttpProtocol();
            i = logLevel;
        } else {
            i = -1;
        }
        if (context != null) {
            mContext = context;
        }
        if (sysLevel < 5) {
            a.a().a(context, i, str, i3, z);
        }
    }

    public static void setAutoUploadFlag(Context context, boolean z) {
        C0808a.m2700a().m2706a(context, z);
    }

    public static void setAutoUploadFlag(Context context, int i) {
        if (i == 1) {
            C1373c.m6139b(TAG, "setAutoUploadFlag flag 1");
            C0808a.m2700a().m2706a(context, true);
            Process.setThreadPriority(10);
            C0808a.m2700a().m2712b(context, true);
            return;
        }
        C1373c.m6139b(TAG, "setAutoUploadFlag flag default");
        C0808a.m2700a().m2706a(context, false);
        C0808a.m2700a().m2712b(context, false);
    }

    public static void setImmediateUploadFlag(Context context, boolean z) {
        C0808a.m2700a().m2716c(context, z);
    }

    public static void m2654d(String str, String str2) {
        if (isLoggable(1)) {
            a.a().a(new a("D", str + "(" + Process.myTid() + ")", str2));
        }
    }

    public static void m2658i(String str, String str2) {
        if (isLoggable(2)) {
            a.a().a(new a("I", str + "(" + Process.myTid() + ")", str2));
        }
    }

    public static void m2660w(String str, String str2) {
        if (isLoggable(3)) {
            a.a().a(new a("W", str + "(" + Process.myTid() + ")", str2));
        }
    }

    public static void m2659v(String str, String str2) {
        if (isLoggable(0)) {
            a.a().a(new a("V", str + "(" + Process.myTid() + ")", str2));
        }
    }

    public static void m2655e(String str, String str2) {
        if (isLoggable(4)) {
            a.a().a(new a("E", str + "(" + Process.myTid() + ")", str2));
        }
    }

    public static void m2656e(String str, String str2, Bundle bundle, Boolean bool, String str3, Context context) {
        if (context == null || bundle == null) {
            C1373c.m6141d(TAG, "null==context fail!");
            return;
        }
        mContext = context;
        Object string = bundle.getString("MetaData");
        if (!TextUtils.isEmpty(string)) {
            str3 = str3 + string;
        }
        m2655e(str, str3);
        if (C0811c.m2805l(context) && isTimeCanPackage()) {
            mUploadFile = bool.booleanValue();
            bundle.putString("LogVersion", logVersion);
            bundle.putString("LogSubversion", logSubversion);
            bundle.putString("ProductName", Build.MODEL);
            bundle.putString("ProductVersion", Build.DISPLAY);
            String l = C1372a.m6127l();
            String q = C0811c.m2810q(context);
            if (TextUtils.isEmpty(q)) {
                q = l;
            }
            bundle.putString("SN", l);
            bundle.putString("IMEI", q);
            bundle.putString("Eventid", str2);
            bundle.putString("HappenTime", "" + System.currentTimeMillis());
            mMetaData = bundle;
            if (bool.booleanValue()) {
                C1373c.m6141d(TAG, "need upload file ,begin package small to SD!");
                packageToSDcard(context, str2, mMetaData, myHandler);
                return;
            }
            C1373c.m6141d(TAG, "no need upload file!");
            myHandler.sendEmptyMessage(1);
            return;
        }
        C1373c.m6141d(TAG, "isAllowUpload denied!");
    }

    public static void m2657e(String str, String str2, Bundle bundle, Boolean bool, String str3, String str4, Context context) {
        if (context == null || bundle == null) {
            C1373c.m6141d(TAG, "out logPath null==context fail!");
            return;
        }
        mContext = context;
        if (C0811c.m2805l(context) && isTimeCanPackage()) {
            mUploadFile = bool.booleanValue();
            bundle.putString("LogVersion", logVersion);
            bundle.putString("LogSubversion", logSubversion);
            bundle.putString("ProductName", Build.MODEL);
            bundle.putString("ProductVersion", Build.DISPLAY);
            String l = C1372a.m6127l();
            String q = C0811c.m2810q(context);
            if (TextUtils.isEmpty(q)) {
                q = l;
            }
            bundle.putString("SN", l);
            bundle.putString("IMEI", q);
            bundle.putString("Eventid", str2);
            bundle.putString("HappenTime", "" + System.currentTimeMillis());
            mMetaData = bundle;
            if (bool.booleanValue()) {
                key = str4;
                logfilePath = str3;
            }
            myHandler.sendEmptyMessage(1);
            return;
        }
        C1373c.m6141d(TAG, "isAllowUpload denied!");
    }

    public static void packageToSDcard(Context context, String str, Bundle bundle, Handler handler) {
        String string = bundle.getString("logwritePath");
        ArrayList stringArrayList = bundle.getStringArrayList("logwritePathList");
        if (TextUtils.isEmpty(string)) {
            string = context.getFilesDir().getPath() + File.separator + "feedbacklogs";
        }
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String a = C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US));
        String str4 = "/Eventid_" + str2 + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str + LightCloudConstants.ZIP_POSTFIX;
        format = string + ("/temp_Eventid_" + str2 + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str + LightCloudConstants.ZIP_POSTFIX);
        logfilePath = context.getFilesDir().getPath() + File.separator + "feedbackuploadlogs" + str4;
        byte[] bArr = new byte[16];
        C0821e.m2884a(bArr);
        key = Base64.encodeToString(bArr, 2);
        new Thread(new com.huawei.feedback.logic.a(logfilePath, format, string, key, bundle, stringArrayList, handler, context, false)).start();
    }

    public static void checkUploadlog(Context context) {
        if (context == null || !C0811c.m2805l(context)) {
            C1373c.m6141d(TAG, "checkUploadlog isAllowUpload false");
        } else {
            new Handler().postDelayed(new 2(context), 15000);
        }
    }

    public static boolean checkTimeOver(Context context) {
        boolean z = false;
        if (context == null) {
            C1373c.m6141d(TAG, "checkTimeOver context null,false!");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            C1373c.m6141d(TAG, "currentTimeMillis!" + currentTimeMillis);
            long b = C0808a.m2700a().m2708b(context);
            C1373c.m6141d(TAG, "beforeTimeMillis!" + b);
            if (-1 == b || (currentTimeMillis - b > 600000 && C0811c.m2809p(context))) {
                C0808a.m2700a().m2711b(context, currentTimeMillis);
                C1373c.m6141d(TAG, "setTenMinAutoCheckTime!");
                z = true;
            }
            C1373c.m6141d(TAG, "checkTimeOver " + z);
        }
        return z;
    }

    public static int getremainUploadSize(int i, Context context) {
        int i2 = 0;
        if (context == null) {
            C1373c.m6141d(TAG, "getremainUploadSize context null,false!");
        } else {
            int i3 = Calendar.getInstance().get(2) + 1;
            if (i3 != C0808a.m2700a().m2713c(context)) {
                C0808a.m2700a().m2702a(context, i3);
                C0808a.m2700a().m2710b(context, 0);
                C0808a.m2700a().m2715c(context, 0);
                C0808a.m2700a().m2722e(context, 0);
                C0808a.m2700a().m2719d(context, 0);
            }
            int f;
            if (i == 1) {
                if (!context.getPackageName().equalsIgnoreCase("com.huawei.phoneservice")) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    i2 = 2097152 - C0808a.m2700a().m2717d(context);
                } else {
                    i2 = 5242880 - C0808a.m2700a().m2717d(context);
                }
                f = GravityCompat.RELATIVE_LAYOUT_DIRECTION - C0808a.m2700a().m2723f(context);
                if (i2 >= f) {
                    i2 = f;
                }
            } else if (i == 2) {
                i2 = 1048576 - C0808a.m2700a().m2720e(context);
                f = 1572864 - C0808a.m2700a().m2726g(context);
                if (i2 >= f) {
                    i2 = f;
                }
            }
            C1373c.m6141d(TAG, "remainsize " + i2);
        }
        return i2;
    }

    public static boolean checkPolicyOver(Context context) {
        boolean z = true;
        if (context == null) {
            C1373c.m6141d(TAG, "checkPolicyOver context null,false!");
            return false;
        }
        long nextInt = (long) new SecureRandom().nextInt(3600000);
        long currentTimeMillis = System.currentTimeMillis();
        long a = C0808a.m2700a().m2701a(context);
        C1373c.m6141d(TAG, "checkPolicyOver beforeTimeMillis" + a);
        if (-1 == a) {
            C1373c.m6141d(TAG, "checkPolicyOver -1==beforeTimeMillis!");
            C0808a.m2700a().m2703a(context, currentTimeMillis);
        } else {
            int h = C0808a.m2700a().m2727h(context);
            long j = 86400000 * ((long) h);
            C1373c.m6141d(TAG, "checkPolicyOver policy" + h);
            if (-1 == h) {
                C0808a.m2700a().m2725f(context, 1);
            } else if (currentTimeMillis - a > j + nextInt) {
                C1373c.m6141d(TAG, "checkPolicyOver currentTimeMillis-beforeTimeMillis" + (currentTimeMillis - a));
                C1373c.m6141d(TAG, "checkPolicyOver (policymillis+randommillis)" + (nextInt + j));
            } else {
                z = false;
            }
        }
        C1373c.m6141d(TAG, "checkPolicyOver " + z);
        return z;
    }

    public static void deleteOverTimeLog(Context context) {
        C1373c.m6141d(TAG, "deleteOverTimeLog ");
        C0806a c0806a = new C0806a(context);
        synchronized (C0809b.f1237b) {
            C1373c.m6141d(TAG, "deleteOverTimeLog selectall ");
            List a = C0807b.m2692a(c0806a);
        }
        if (a.size() > 0) {
            int size = a.size();
            C1373c.m6141d(TAG, "deleteOverTimeLog " + size);
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                if (currentTimeMillis - Long.parseLong(((C0810a) a.get(i)).m2748e()) >= 259200000) {
                    C1373c.m6141d(TAG, "000deleteOverTimeLog " + i);
                    C0810a c0810a = (C0810a) a.get(i);
                    synchronized (C0809b.f1237b) {
                        C1373c.m6141d(TAG, "deleteOverTimeLog delete ");
                        C0807b.m2699b(c0806a, c0810a);
                    }
                    Object c = c0810a.m2745c();
                    C1373c.m6141d(TAG, "deleteOverTimeLog filepath" + c);
                    if (!TextUtils.isEmpty(c)) {
                        C0811c.m2783b(new File(c));
                    }
                }
            }
        }
    }

    public static String createBiglogzip(Context context, long j, Bundle bundle, boolean z) {
        if (context == null) {
            return "";
        }
        C1373c.m6141d(TAG, "begin to createBiglogzip!");
        autouploadloglist.clear();
        if (j > 0 || z) {
            List a;
            C0806a c0806a = new C0806a(context);
            synchronized (C0809b.f1237b) {
                a = C0807b.m2694a(c0806a, true);
                C1373c.m6141d(TAG, "autohasloglist" + a.size());
            }
            if (a.size() > 0) {
                int size = a.size();
                long j2 = 0;
                long remainMaxSize = getRemainMaxSize(j, context);
                for (int i = 0; i < size; i++) {
                    j2 += ((C0810a) a.get(i)).m2747d();
                    if (j2 > remainMaxSize && !z) {
                        break;
                    }
                    autouploadloglist.add(a.get(i));
                }
            }
            synchronized (C0809b.f1237b) {
                autonologlist = C0807b.m2694a(c0806a, false);
            }
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.addAll(autouploadloglist);
            arrayList2.addAll(autonologlist);
            String packageBigLogFile = packageBigLogFile(arrayList, arrayList2, context, bundle);
            C1373c.m6141d(TAG, "Biglogzip path" + packageBigLogFile);
            return packageBigLogFile;
        }
        C1373c.m6141d(TAG, "no remain size !");
        context.stopService(new Intent(context, AutoUploadService.class));
        return "";
    }

    private static String packageBigLogFile(List<C0810a> list, List<C0810a> list2, Context context, Bundle bundle) {
        int i;
        String path = context.getFilesDir().getPath();
        String str = Build.MODEL;
        String str2 = Build.DISPLAY;
        String str3 = "/Eventid_" + str + HwAccountConstants.SPLIIT_UNDERLINE + str2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_ALL.zip";
        int size = list.size();
        C1373c.m6139b(TAG, "hasloglistsize" + size);
        File creatEventlogzip = creatEventlogzip(list2, bundle, path);
        if (creatEventlogzip != null) {
            i = size + 1;
        } else {
            i = size;
        }
        if (i == 0) {
            C1373c.m6141d(TAG, "no hasloglistsize,stop!");
            return "";
        }
        File[] fileArr = new File[i];
        for (int i2 = 0; i2 < list.size(); i2++) {
            C1373c.m6141d(TAG, UploadFile.FILE_NAME + i2 + ((C0810a) list.get(i2)).m2745c());
            fileArr[i2] = new File(((C0810a) list.get(i2)).m2745c());
        }
        if (creatEventlogzip != null) {
            fileArr[i - 1] = creatEventlogzip;
        }
        str = path + str3;
        File file = new File(str);
        C1373c.m6141d(TAG, "no aes zip logzipPath fileName" + str);
        boolean a = C0811c.m2775a(fileArr, file, context);
        C0811c.m2783b(creatEventlogzip);
        if (a) {
            C1373c.m6141d(TAG, "packageBigLogFile OK!");
            return str;
        }
        C1373c.m6141d(TAG, "packageBigLogFile fail!");
        return "";
    }

    private static File creatEventlogzip(List<C0810a> list, Bundle bundle, String str) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        FileNotFoundException e;
        BufferedWriter bufferedWriter2;
        FileOutputStream fileOutputStream2;
        File file;
        Throwable th;
        UnsupportedEncodingException e2;
        IOException e3;
        int i = 0;
        OutputStreamWriter outputStreamWriter2 = null;
        C1373c.m6141d(TAG, "begin creatEventlogzip!");
        List arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(((C0810a) list.get(i2)).m2749f());
        }
        String string = bundle.getString("LogVersion");
        String string2 = bundle.getString("LogSubversion");
        String string3 = bundle.getString("ProductName");
        String string4 = bundle.getString("ProductVersion");
        String string5 = bundle.getString("SN");
        String string6 = bundle.getString("IMEI");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("LogVersion", string);
            jSONObject.putOpt("LogSubversion", string2);
            jSONObject.putOpt("ProductName", string3);
            jSONObject.putOpt("ProductVersion", string4);
            jSONObject.putOpt("SN", string5);
            jSONObject.putOpt("IMEI", string6);
        } catch (JSONException e4) {
            C1373c.m6141d(TAG, "JSONException!" + e4.getMessage());
        }
        string = jSONObject.toString();
        File file2 = new File(str, "eventinfo.log");
        C1373c.m6141d(TAG, "Eventlog path" + file2.toString());
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, GameManager.DEFAULT_CHARSET);
                try {
                    bufferedWriter = new BufferedWriter(outputStreamWriter);
                    try {
                        bufferedWriter.append(string + '\n');
                        while (i < arrayList.size()) {
                            bufferedWriter.append(((String) arrayList.get(i)) + '\n');
                            i++;
                        }
                        bufferedWriter.flush();
                        b.a(fileOutputStream, TAG);
                        b.a(outputStreamWriter, TAG);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e5) {
                                C1373c.m6141d(TAG, "shutdown IOException");
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        outputStreamWriter2 = outputStreamWriter;
                        bufferedWriter2 = bufferedWriter;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            C1373c.m6141d(TAG, "creatEventlogzip FileNotFoundException!" + e.getMessage());
                            b.a(fileOutputStream2, TAG);
                            b.a(outputStreamWriter2, TAG);
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e7) {
                                    C1373c.m6141d(TAG, "shutdown IOException");
                                }
                            }
                            string = Build.MODEL;
                            string2 = Build.DISPLAY;
                            file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                            C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                            C0811c.m2784b(file2.getPath(), file.getPath());
                            C0811c.m2783b(file2);
                            return file;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = bufferedWriter2;
                            outputStreamWriter = outputStreamWriter2;
                            b.a(fileOutputStream, TAG);
                            b.a(outputStreamWriter, TAG);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e8) {
                                    C1373c.m6141d(TAG, "shutdown IOException");
                                }
                            }
                            throw th;
                        }
                    } catch (UnsupportedEncodingException e9) {
                        e2 = e9;
                        try {
                            C1373c.m6141d(TAG, "creatEventlogzip UnsupportedEncodingException!" + e2.getMessage());
                            b.a(fileOutputStream, TAG);
                            b.a(outputStreamWriter, TAG);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e10) {
                                    C1373c.m6141d(TAG, "shutdown IOException");
                                }
                            }
                            string = Build.MODEL;
                            string2 = Build.DISPLAY;
                            file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                            C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                            C0811c.m2784b(file2.getPath(), file.getPath());
                            C0811c.m2783b(file2);
                            return file;
                        } catch (Throwable th3) {
                            th = th3;
                            b.a(fileOutputStream, TAG);
                            b.a(outputStreamWriter, TAG);
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            throw th;
                        }
                    } catch (IOException e11) {
                        e3 = e11;
                        C1373c.m6141d(TAG, "creatEventlogzip IOException!" + e3.getMessage());
                        b.a(fileOutputStream, TAG);
                        b.a(outputStreamWriter, TAG);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e12) {
                                C1373c.m6141d(TAG, "shutdown IOException");
                            }
                        }
                        string = Build.MODEL;
                        string2 = Build.DISPLAY;
                        file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                        C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                        C0811c.m2784b(file2.getPath(), file.getPath());
                        C0811c.m2783b(file2);
                        return file;
                    }
                } catch (FileNotFoundException e13) {
                    e = e13;
                    bufferedWriter2 = null;
                    outputStreamWriter2 = outputStreamWriter;
                    fileOutputStream2 = fileOutputStream;
                    C1373c.m6141d(TAG, "creatEventlogzip FileNotFoundException!" + e.getMessage());
                    b.a(fileOutputStream2, TAG);
                    b.a(outputStreamWriter2, TAG);
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    string = Build.MODEL;
                    string2 = Build.DISPLAY;
                    file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                    C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                    C0811c.m2784b(file2.getPath(), file.getPath());
                    C0811c.m2783b(file2);
                    return file;
                } catch (UnsupportedEncodingException e14) {
                    e2 = e14;
                    bufferedWriter = null;
                    C1373c.m6141d(TAG, "creatEventlogzip UnsupportedEncodingException!" + e2.getMessage());
                    b.a(fileOutputStream, TAG);
                    b.a(outputStreamWriter, TAG);
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    string = Build.MODEL;
                    string2 = Build.DISPLAY;
                    file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                    C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                    C0811c.m2784b(file2.getPath(), file.getPath());
                    C0811c.m2783b(file2);
                    return file;
                } catch (IOException e15) {
                    e3 = e15;
                    bufferedWriter = null;
                    C1373c.m6141d(TAG, "creatEventlogzip IOException!" + e3.getMessage());
                    b.a(fileOutputStream, TAG);
                    b.a(outputStreamWriter, TAG);
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    string = Build.MODEL;
                    string2 = Build.DISPLAY;
                    file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                    C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                    C0811c.m2784b(file2.getPath(), file.getPath());
                    C0811c.m2783b(file2);
                    return file;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedWriter = null;
                    b.a(fileOutputStream, TAG);
                    b.a(outputStreamWriter, TAG);
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
                fileOutputStream2 = fileOutputStream;
                bufferedWriter2 = null;
                C1373c.m6141d(TAG, "creatEventlogzip FileNotFoundException!" + e.getMessage());
                b.a(fileOutputStream2, TAG);
                b.a(outputStreamWriter2, TAG);
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                string = Build.MODEL;
                string2 = Build.DISPLAY;
                file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                C0811c.m2784b(file2.getPath(), file.getPath());
                C0811c.m2783b(file2);
                return file;
            } catch (UnsupportedEncodingException e17) {
                e2 = e17;
                outputStreamWriter = null;
                bufferedWriter = null;
                C1373c.m6141d(TAG, "creatEventlogzip UnsupportedEncodingException!" + e2.getMessage());
                b.a(fileOutputStream, TAG);
                b.a(outputStreamWriter, TAG);
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                string = Build.MODEL;
                string2 = Build.DISPLAY;
                file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                C0811c.m2784b(file2.getPath(), file.getPath());
                C0811c.m2783b(file2);
                return file;
            } catch (IOException e18) {
                e3 = e18;
                outputStreamWriter = null;
                bufferedWriter = null;
                C1373c.m6141d(TAG, "creatEventlogzip IOException!" + e3.getMessage());
                b.a(fileOutputStream, TAG);
                b.a(outputStreamWriter, TAG);
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                string = Build.MODEL;
                string2 = Build.DISPLAY;
                file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
                C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
                C0811c.m2784b(file2.getPath(), file.getPath());
                C0811c.m2783b(file2);
                return file;
            } catch (Throwable th5) {
                th = th5;
                outputStreamWriter = null;
                bufferedWriter = null;
                b.a(fileOutputStream, TAG);
                b.a(outputStreamWriter, TAG);
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e19) {
            e = e19;
            fileOutputStream2 = null;
            bufferedWriter2 = null;
            C1373c.m6141d(TAG, "creatEventlogzip FileNotFoundException!" + e.getMessage());
            b.a(fileOutputStream2, TAG);
            b.a(outputStreamWriter2, TAG);
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            string = Build.MODEL;
            string2 = Build.DISPLAY;
            file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
            C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
            C0811c.m2784b(file2.getPath(), file.getPath());
            C0811c.m2783b(file2);
            return file;
        } catch (UnsupportedEncodingException e20) {
            e2 = e20;
            outputStreamWriter = null;
            fileOutputStream = null;
            bufferedWriter = null;
            C1373c.m6141d(TAG, "creatEventlogzip UnsupportedEncodingException!" + e2.getMessage());
            b.a(fileOutputStream, TAG);
            b.a(outputStreamWriter, TAG);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            string = Build.MODEL;
            string2 = Build.DISPLAY;
            file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
            C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
            C0811c.m2784b(file2.getPath(), file.getPath());
            C0811c.m2783b(file2);
            return file;
        } catch (IOException e21) {
            e3 = e21;
            outputStreamWriter = null;
            fileOutputStream = null;
            bufferedWriter = null;
            C1373c.m6141d(TAG, "creatEventlogzip IOException!" + e3.getMessage());
            b.a(fileOutputStream, TAG);
            b.a(outputStreamWriter, TAG);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            string = Build.MODEL;
            string2 = Build.DISPLAY;
            file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
            C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
            C0811c.m2784b(file2.getPath(), file.getPath());
            C0811c.m2783b(file2);
            return file;
        } catch (Throwable th6) {
            th = th6;
            outputStreamWriter = null;
            fileOutputStream = null;
            bufferedWriter = null;
            b.a(fileOutputStream, TAG);
            b.a(outputStreamWriter, TAG);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            throw th;
        }
        string = Build.MODEL;
        string2 = Build.DISPLAY;
        file = new File(str, "Eventid_" + string + HwAccountConstants.SPLIIT_UNDERLINE + string2 + HwAccountConstants.SPLIIT_UNDERLINE + C1371b.m6104a(C1372a.m6127l().toUpperCase(Locale.US)) + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_eventinfo.zip");
        C1373c.m6141d(TAG, "Eventlogzip path" + file.getPath());
        C0811c.m2784b(file2.getPath(), file.getPath());
        C0811c.m2783b(file2);
        return file;
    }

    private static long getRemainMaxSize(long j, Context context) {
        int f = C0811c.m2798f(context);
        if (f == 2) {
            return j < 307200 ? j : 307200;
        } else {
            if (f != 1) {
                return 0;
            }
            if (j >= 716800) {
                return 716800;
            }
            return j;
        }
    }

    public static boolean isLoggable(int i) {
        return i >= sysLevel;
    }

    public static String getEncryImei(String str) {
        return C1371b.m6104a(str);
    }

    private static boolean isTimeCanPackage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (firstTime == 0 || currentTimeMillis - firstTime > 100) {
            firstTime = currentTimeMillis;
            return true;
        }
        C1373c.m6141d(TAG, "it is not time yet!");
        return false;
    }

    public static void setMultiPackageName(Context context, String str) {
        C0808a.m2700a().m2704a(context, str);
    }

    public static void reportEvent(Context context, Event event) {
        if (context == null || event == null) {
            C1373c.m6141d("ReportApi", "context or event is empty!");
            return;
        }
        if (mContext == null) {
            mContext = context;
        }
        d.a(context, event, reportHandler);
    }

    public static void flushReport() {
        d.a(mContext, isHttpProtocol);
    }
}
