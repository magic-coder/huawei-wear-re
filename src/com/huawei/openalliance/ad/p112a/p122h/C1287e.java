package com.huawei.openalliance.ad.p112a.p122h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1287e {
    public static int m5678a(Context context, float f) {
        return (context != null && f > 0.0f) ? (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f) : 0;
    }

    public static int m5679a(Context context, int i) {
        switch (i) {
            case 2:
                return C1289h.m5695a(context).m5730o();
            case 4:
                return C1289h.m5695a(context).m5729n();
            default:
                return 500;
        }
    }

    public static long m5680a() {
        long j = 20971520;
        try {
            j = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        } catch (Exception e) {
            C1336d.m5888c("HiAdTools", "fail to get unUsedMemory");
        }
        C1336d.m5884a("HiAdTools", "unUsedMemory is:", String.valueOf(j));
        return j;
    }

    public static String m5681a(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    public static Date m5682a(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(5, instance.get(5) - i);
        instance.set(11, 24);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static boolean m5683a(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m5684a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m5685a(WebView webView, ProgressBar progressBar) {
        if (webView == null) {
            return false;
        }
        String str = "";
        str = (C1287e.m5687b(webView.getContext(), "hiad_load_fail_page.html") && C1287e.m5687b(webView.getContext(), "ic_hiad_load_fail.png")) ? "file:///android_asset/hiad" + File.separator + "hiad_load_fail_page.html" : "about:blank";
        webView.clearHistory();
        webView.loadUrl(str);
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        return true;
    }

    @SuppressWarnings(justification = "h00193325/从系统进行反射，对各种异常处理方式都一致，所以使用Exception进行异常捕获", value = {"REC_CATCH_EXCEPTION"})
    public static int m5686b() {
        String str = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str2 = "^EmotionUI_[1-9]{1}";
            Matcher matcher = Pattern.compile("^EmotionUI_[1-9]{1}").matcher((String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.version.emui"}));
            String str3 = "";
            if (matcher.find()) {
                int parseInt;
                Object group = matcher.group(0);
                if (!TextUtils.isEmpty(group)) {
                    String[] split = group.split(HwAccountConstants.SPLIIT_UNDERLINE);
                    if (split.length == 2) {
                        try {
                            parseInt = Integer.parseInt(split[1]);
                        } catch (NumberFormatException e) {
                            C1336d.m5888c("HiAdTools", "get emui version error!");
                        }
                        return parseInt;
                    }
                }
                parseInt = 0;
                return parseInt;
            }
            C1336d.m5888c("HiAdTools", "can not find versionName:" + str);
            return 0;
        } catch (ClassNotFoundException e2) {
            C1336d.m5888c("HiAdTools", "ClassNotFoundException get system properties error!");
            return 0;
        } catch (NoSuchMethodException e3) {
            C1336d.m5888c("HiAdTools", "NoSuchMethodException get system properties error!");
            return 0;
        } catch (IllegalAccessException e4) {
            C1336d.m5888c("HiAdTools", "IllegalAccessException get system properties error!");
            return 0;
        } catch (IllegalArgumentException e5) {
            C1336d.m5888c("HiAdTools", "IllegalArgumentException get system properties error!");
            return 0;
        } catch (InvocationTargetException e6) {
            C1336d.m5888c("HiAdTools", "InvocationTargetException get system properties error!");
            return 0;
        } catch (Exception e7) {
            C1336d.m5888c("HiAdTools", "Exception get system properties error!");
            return 0;
        }
    }

    public static boolean m5687b(Context context, String str) {
        boolean z = true;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return false;
        }
        try {
            String[] list = assets.list("hiad");
            if (list == null || list.length <= 0 || !Arrays.asList(list).contains(str)) {
                z = false;
            }
            return z;
        } catch (IOException e) {
            C1336d.m5890d("HiAdTools", "list asset error");
            return false;
        }
    }

    public static boolean m5688c() {
        C1336d.m5886b("HiAdTools", "current api level is:", String.valueOf(VERSION.SDK_INT));
        return VERSION.SDK_INT >= 14;
    }

    public static long m5689d() {
        return System.currentTimeMillis();
    }
}
