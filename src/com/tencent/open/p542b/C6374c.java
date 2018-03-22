package com.tencent.open.p542b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p541a.C6367n;
import java.util.Locale;

/* compiled from: ProGuard */
public class C6374c {
    static String f22172a = null;
    static String f22173b = null;
    static String f22174c = null;
    private static String f22175d;
    private static String f22176e = null;

    public static String m29137a() {
        try {
            Context a = C6395h.m29184a();
            if (a == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            return connectionInfo.getMacAddress();
        } catch (Throwable e) {
            C6367n.m29108b("MobileInfoUtil", "getLocalMacAddress>>>", e);
            return "";
        }
    }

    public static String m29138a(Context context) {
        if (!TextUtils.isEmpty(f22175d)) {
            return f22175d;
        }
        if (context == null) {
            return "";
        }
        f22175d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            f22175d = width + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f22175d;
    }

    public static String m29139b() {
        return Locale.getDefault().getLanguage();
    }

    public static String m29140b(Context context) {
        if (f22172a != null && f22172a.length() > 0) {
            return f22172a;
        }
        if (context == null) {
            return "";
        }
        try {
            f22172a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f22172a;
        } catch (Exception e) {
            return "";
        }
    }

    public static String m29141c(Context context) {
        if (f22173b != null && f22173b.length() > 0) {
            return f22173b;
        }
        if (context == null) {
            return "";
        }
        try {
            f22173b = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            return f22173b;
        } catch (Exception e) {
            return "";
        }
    }

    public static String m29142d(Context context) {
        if (f22174c != null && f22174c.length() > 0) {
            return f22174c;
        }
        if (context == null) {
            return "";
        }
        try {
            f22174c = Secure.getString(context.getContentResolver(), "android_id");
            return f22174c;
        } catch (Exception e) {
            return "";
        }
    }

    public static String m29143e(Context context) {
        try {
            if (f22176e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("imei=").append(C6374c.m29140b(context)).append('&');
                stringBuilder.append("model=").append(Build.MODEL).append('&');
                stringBuilder.append("os=").append(VERSION.RELEASE).append('&');
                stringBuilder.append("apilevel=").append(VERSION.SDK_INT).append('&');
                String b = C6372a.m29133b(context);
                if (b == null) {
                    b = "";
                }
                stringBuilder.append("network=").append(b).append('&');
                stringBuilder.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
                stringBuilder.append("display=").append(displayMetrics.widthPixels).append('*').append(displayMetrics.heightPixels).append('&');
                stringBuilder.append("manu=").append(Build.MANUFACTURER).append(SNBConstant.FILTER);
                stringBuilder.append("wifi=").append(C6372a.m29136e(context));
                f22176e = stringBuilder.toString();
            }
            return f22176e;
        } catch (Exception e) {
            return null;
        }
    }
}
