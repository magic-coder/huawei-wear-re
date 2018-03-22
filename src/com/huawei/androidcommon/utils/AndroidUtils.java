package com.huawei.androidcommon.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.log4j.helpers.DateLayout;

public class AndroidUtils {
    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            Log.e(AC.TAG, "[AndroidUtils.getAppVersionName]Error:", e);
            return "";
        }
    }

    public static int getAppVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable e) {
            Log.e(AC.TAG, "[AndroidUtils.getAppVersionCode]Error:", e);
            return i;
        }
    }

    public static String getDeviceFullVersion() {
        if ("MTK_Platform".equals(SystemProperties.get("ro.config.hw_ChipPlatform", ""))) {
            return SystemProperties.get("ro.build.realversion.id", "");
        }
        return getDeviceVersionString();
    }

    public static String getDeviceVersionString() {
        String[] strArr = new String[]{SystemProperties.get("ro.build.realversion.id", DateLayout.NULL_DATE_FORMAT), SystemProperties.get("ro.build.cust.id", DateLayout.NULL_DATE_FORMAT), SystemProperties.get("ro.build.display.id", DateLayout.NULL_DATE_FORMAT)};
        String str = Build.DISPLAY;
        for (String str2 : strArr) {
            if (!DateLayout.NULL_DATE_FORMAT.equals(str2)) {
                return str2;
            }
        }
        return str;
    }

    public static String getDeviceModel() {
        String deviceFullVersion = getDeviceFullVersion();
        int indexOf = deviceFullVersion.indexOf("V100");
        if (indexOf != -1) {
            return deviceFullVersion.substring(0, indexOf);
        }
        try {
            return SystemProperties.get("ro.product.name", DateLayout.NULL_DATE_FORMAT);
        } catch (Exception e) {
            return DateLayout.NULL_DATE_FORMAT;
        }
    }

    public static String getDeviceVersion() {
        String deviceFullVersion = getDeviceFullVersion();
        int indexOf = deviceFullVersion.indexOf("V100");
        if (indexOf == -1) {
            return deviceFullVersion.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
        }
        return deviceFullVersion.substring(indexOf);
    }

    private static boolean isDeviceFullVersionValid(String str) {
        String str2 = "V[0-9]{3}R[0-9]{3}";
        if (str == null || str.isEmpty() || !Pattern.compile(str2).matcher(str).find()) {
            Log.i(AC.TAG, "version:" + str + "is invalid");
            return false;
        }
        Log.i(AC.TAG, "version:" + str + "is valid");
        return true;
    }

    private static String getRealDeviceFullVersion() {
        String str = SystemProperties.get("ro.confg.hw_systemversion", "");
        if (str == null) {
            return DateLayout.NULL_DATE_FORMAT;
        }
        Log.i(AC.TAG, "Real version is:" + str);
        int indexOf = str.indexOf("_SYSTEM");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static String getDeviceId(Context context) {
        try {
            String str = "^[0-9a-zA-Z]+$";
            for (int i = 0; i < 5; i++) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (Pattern.compile(str).matcher(deviceId).matches()) {
                    return deviceId;
                }
            }
        } catch (Throwable e) {
            Log.e(AC.TAG, "[AndroidUtils.getDeviceId]Error:", e);
        }
        return "0";
    }

    public static void killTargetApp(Context context, String str) {
        int i;
        Log.d(AC.TAG, String.format("killTargetApp %s start", new Object[]{str}));
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        for (RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(100)) {
            Log.d(AC.TAG, "running app : " + runningTaskInfo.topActivity.getPackageName());
            if (!runningTaskInfo.topActivity.getPackageName().equals(str)) {
                if (runningTaskInfo.baseActivity.getPackageName().equals(str)) {
                }
            }
            Log.d(AC.TAG, new StringBuilder(String.valueOf(runningTaskInfo.topActivity.getPackageName())).append(" info.baseActivity.getPackageName()=").append(runningTaskInfo.baseActivity.getPackageName()).toString());
            i = 1;
        }
        i = 0;
        if (i == 0) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                Log.d(AC.TAG, "running process : " + runningAppProcessInfo.processName);
                if (runningAppProcessInfo.processName.contains(str)) {
                    try {
                        Process.killProcess(runningAppProcessInfo.pid);
                        break;
                    } catch (Exception e) {
                        Log.d(AC.TAG, "Kill Huawei BOne Error!");
                    }
                }
            }
        }
        Log.d(AC.TAG, String.format("killing %s", new Object[]{str}));
        activityManager.killBackgroundProcesses(str);
    }

    public static Locale getCurrentLocale(Context context) {
        return context.getResources().getConfiguration().locale;
    }

    public static String getWifiMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        String bssid = wifiManager.getConnectionInfo().getBSSID();
        Log.d(AC.TAG, "getBSSID address is " + bssid);
        return bssid;
    }

    public static int getAndroidSDKVersion() {
        return VERSION.SDK_INT;
    }
}
