package com.huawei.common.applog.p380a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.common.applog.bean.C4349b;
import com.huawei.common.applog.bean.Event;
import com.huawei.common.applog.bean.ExtraBundle;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.phoneserviceuni.common.d.a;
import com.huawei.phoneserviceuni.common.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: ReportDataHandle */
public class C4345a {
    private static ExtraBundle f16139a;
    private static String f16140b = "";
    private static String f16141c = "";
    private static String f16142d = "";
    private static String f16143e = "";
    private static String f16144f = "";
    private static String f16145g = "";
    private static String f16146h = "";
    private static String f16147i = "";
    private static String f16148j = "";
    private static String f16149k = "";
    private static String f16150l = "";
    private static String f16151m = "";
    private static String f16152n = "";
    private static String f16153o = "";
    private static String f16154p = "";
    private static String f16155q = "";
    private static String f16156r = "1.1";
    private static String f16157s = "";
    private static String f16158t = "";
    private static String f16159u = "";

    public static synchronized void m20886a(Context context, Handler handler) {
        synchronized (C4345a.class) {
            Event c = C4349b.m20911a().m20915c();
            if (!C4345a.m20888a(c)) {
                c.d("ReportApi/ReportDataHandleTask", "runReportDataHandle param  check fail !");
            } else if (com.huawei.feedback.c.l(context)) {
                C4345a.m20887a(c, context);
                if (f16139a != null) {
                    f16140b = "|" + f16139a.toString();
                } else {
                    f16140b = "";
                }
                String str = f16159u + "|" + f16158t + "|" + f16156r + "|" + f16155q + "|" + f16154p + "|" + f16153o + "|" + f16152n + "|" + f16151m + "|" + f16150l + "|" + f16149k + "|" + f16148j + "|" + f16147i + "|" + f16146h + "|" + f16145g + "|" + f16144f + "|" + f16143e + "|" + f16142d + "|" + f16141c + f16140b;
                HashMap hashMap = new HashMap();
                hashMap.put(SNBConstant.FIELD_PKG, f16157s);
                hashMap.put("msg_value", str);
                if (!C4349b.m20911a().m20913a(hashMap)) {
                    c.d("ReportApi/ReportDataHandleTask", "MessageQueue full,insert fail");
                    HashMap b = C4349b.m20911a().m20914b();
                    c.b("ReportApi/ReportDataHandleTask", "remove pollData = " + b);
                    if (b == null) {
                        c.d("ReportApi/ReportDataHandleTask", "MessageQueue is empty");
                    } else {
                        C4349b.m20911a().m20913a(hashMap);
                        c.c("ReportApi/ReportDataHandleTask", "insert message again");
                    }
                }
                c.b("ReportApi/ReportDataHandleTask", C4349b.m20911a().m20917e());
                handler.sendEmptyMessage(10000);
            } else {
                c.d("ReportApi/ReportDataHandleTask", "runReportDataHandle isallowReprot false or rom is not china !");
            }
        }
    }

    private static boolean m20888a(Event event) {
        if (event == null) {
            c.d("ReportApi/ReportDataHandleTask", "paramCheck event is null");
            return false;
        } else if (TextUtils.isEmpty(event.getResourcePath()) || TextUtils.isEmpty(event.getOperationType())) {
            return false;
        } else {
            if (TextUtils.isEmpty(event.getReturnCode()) && TextUtils.isEmpty(event.getClientErrorCode())) {
                return false;
            }
            return true;
        }
    }

    private static void m20887a(Event event, Context context) {
        f16155q = C4345a.m20883a();
        if (event != null) {
            f16154p = C4345a.m20885a(event.getDomain());
            f16153o = C4345a.m20885a(event.getServerIp());
            f16152n = C4345a.m20885a(event.getDnsTime());
            f16151m = C4345a.m20885a(event.getConnTime());
            f16150l = C4345a.m20885a(event.getPreTranTime());
            f16149k = C4345a.m20885a(event.getStartTranTime());
            f16148j = C4345a.m20885a(event.getTotalTime());
            f16147i = C4345a.m20885a(event.getSizeDownload());
            f16146h = C4345a.m20885a(event.getSizeUpload());
            f16145g = C4345a.m20885a(event.getReturnCode());
            f16144f = C4345a.m20885a(event.getErrorReason());
            f16143e = C4345a.m20885a(event.getClientErrorCode());
            if (TextUtils.isEmpty(f16145g)) {
                f16145g = f16143e;
            }
            f16142d = com.huawei.feedback.c.f(event.getResourcePath());
            f16141c = com.huawei.feedback.c.f(event.getOperationType());
            f16139a = event.getExtraData() != null ? event.getExtraData() : null;
            if (context != null) {
                f16157s = !TextUtils.isEmpty(event.getAppPackageName()) ? event.getAppPackageName() : context.getPackageName();
                f16158t = !TextUtils.isEmpty(event.getAppVersionName()) ? event.getAppVersionName() : C4345a.m20885a(a.b(context.getPackageName(), context));
                f16159u = C4345a.m20884a(context);
            }
        }
    }

    private static String m20884a(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                c.c("ReportApi/ReportDataHandleTask", "Network getSubtypeName : " + subtypeName);
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        subtypeName = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        subtypeName = "3G";
                        break;
                    case 13:
                        subtypeName = "4G";
                        break;
                    default:
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            subtypeName = "3G";
                            break;
                        }
                }
                Object b = C4345a.m20889b(context);
                if (TextUtils.isEmpty(b)) {
                    return subtypeName;
                }
                return subtypeName + "," + b;
            }
        }
        return str;
    }

    private static String m20889b(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        if (C4345a.m20890c(context)) {
            c.d("ReportApi/ReportDataHandleTask", "no have Manifest.permission.READ_PHONE_STATE");
            return str;
        }
        String subscriberId;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            subscriberId = telephonyManager.getSubscriberId();
        } else {
            subscriberId = str;
        }
        if (TextUtils.isEmpty(subscriberId)) {
            c.d("ReportApi/ReportDataHandleTask", "getIMSI isEmpty");
            return "";
        }
        if (subscriberId.length() >= 5) {
            subscriberId = subscriberId.substring(0, 5);
        }
        return subscriberId;
    }

    private static String m20885a(String str) {
        if (str == null) {
            str = "";
        }
        return com.huawei.feedback.c.f(str);
    }

    private static boolean m20890c(Context context) {
        return VERSION.SDK_INT > 22 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0;
    }

    public static String m20883a() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(new Date());
    }
}
