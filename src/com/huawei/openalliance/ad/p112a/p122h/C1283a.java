package com.huawei.openalliance.ad.p112a.p122h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1220f;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1234t;
import com.huawei.openalliance.ad.utils.p127a.p128a.C1324a;
import com.huawei.openalliance.ad.utils.p127a.p128a.C1325b;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class C1283a {
    private static C1283a f2727a;
    private Context f2728b;

    private C1283a(Context context) {
        this.f2728b = context;
    }

    public static synchronized C1283a m5645a(Context context) {
        C1283a c1283a;
        synchronized (C1283a.class) {
            Context applicationContext = context.getApplicationContext();
            if (f2727a == null) {
                f2727a = new C1283a(applicationContext);
            }
            c1283a = f2727a;
        }
        return c1283a;
    }

    private static DisplayMetrics m5646b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return displayMetrics;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return displayMetrics;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
        } catch (ClassNotFoundException e) {
            C1336d.m5890d("AdInfoService", "get full display metrics error, ClassNotFoundException:" + e.toString());
        } catch (NoSuchMethodException e2) {
            C1336d.m5890d("AdInfoService", "get full display metrics error, NoSuchMethodException:" + e2.toString());
        } catch (IllegalAccessException e3) {
            C1336d.m5890d("AdInfoService", "get full display metrics error, IllegalAccessException:" + e3.toString());
        } catch (IllegalArgumentException e4) {
            C1336d.m5890d("AdInfoService", "get full display metrics error, IllegalArgumentException:" + e4.toString());
        } catch (InvocationTargetException e5) {
            C1336d.m5890d("AdInfoService", "get full display metrics error, InvocationTargetException:" + e5.toString());
        }
        return displayMetrics;
    }

    private int m5647c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 5;
            case 13:
                return 6;
            default:
                return 0;
        }
    }

    private int m5648j() {
        return this.f2728b == null ? 0 : C1283a.m5646b(this.f2728b).heightPixels;
    }

    private int m5649k() {
        return this.f2728b == null ? 0 : C1283a.m5646b(this.f2728b).widthPixels;
    }

    public int m5650a() {
        if (this.f2728b == null) {
            return 0;
        }
        C1289h a = C1289h.m5695a(this.f2728b);
        int s = a.m5734s();
        if (s >= 0) {
            return s;
        }
        int j = m5648j();
        s = m5649k();
        if (j <= s) {
            s = j;
        }
        a.m5728m(s);
        return s;
    }

    public int m5651a(int i) {
        return i == 0 ? m5652b() : m5650a();
    }

    public int m5652b() {
        if (this.f2728b == null) {
            return 0;
        }
        C1289h a = C1289h.m5695a(this.f2728b);
        int r = a.m5733r();
        if (r >= 0) {
            return r;
        }
        r = m5648j();
        int k = m5649k();
        if (r <= k) {
            r = k;
        }
        a.m5726l(r);
        return r;
    }

    public int m5653b(int i) {
        return i == 0 ? m5650a() : m5652b();
    }

    public String m5654c() {
        return Locale.getDefault().getLanguage();
    }

    public String m5655d() {
        return Secure.getString(this.f2728b.getContentResolver(), "android_id");
    }

    public String m5656e() {
        CharSequence charSequence;
        String str;
        CharSequence charSequence2 = null;
        try {
            if (C1325b.m5838b()) {
                C1336d.m5886b("AdInfoService", "multicard device");
                C1324a a = C1325b.m5837a();
                charSequence2 = a.mo2454a(0);
                try {
                    if (TextUtils.isEmpty(charSequence2)) {
                        charSequence2 = a.mo2454a(a.mo2453a());
                    }
                } catch (SecurityException e) {
                    charSequence = charSequence2;
                    C1336d.m5888c("AdInfoService", "get info fail");
                    return str;
                } catch (Exception e2) {
                    charSequence = charSequence2;
                    C1336d.m5888c("AdInfoService", "get info fail");
                    return str;
                }
            }
            if (TextUtils.isEmpty(charSequence2)) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f2728b.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getDeviceId();
                }
            }
            return charSequence2;
        } catch (SecurityException e3) {
            str = null;
            C1336d.m5888c("AdInfoService", "get info fail");
            return str;
        } catch (Exception e4) {
            str = null;
            C1336d.m5888c("AdInfoService", "get info fail");
            return str;
        }
    }

    public String m5657f() {
        if (!C1287e.m5684a(this.f2728b, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        WifiManager wifiManager = (WifiManager) this.f2728b.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() == null ? "" : connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            C1336d.m5888c("AdInfoService", "fail to get wifi info");
            return "";
        }
    }

    public int m5658g() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f2728b.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return m5647c(activeNetworkInfo.getSubtype());
                }
                if (9 == type) {
                    return 1;
                }
                if (1 == type) {
                    return 2;
                }
            }
        } catch (Exception e) {
            C1336d.m5888c("AdInfoService", "fail to get network info");
        }
        return 0;
    }

    public C1220f m5659h() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f2728b.getSystemService("phone");
            if (telephonyManager != null) {
                String str;
                String str2;
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator == null || "null".equalsIgnoreCase(networkOperator) || networkOperator.length() <= 3) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = networkOperator.substring(0, 3);
                    str = networkOperator.substring(3);
                }
                return new C1220f(str2, str, telephonyManager.getNetworkType());
            }
        } catch (Exception e) {
            C1336d.m5888c("AdInfoService", "get network fail");
        }
        return null;
    }

    public C1234t m5660i() {
        if (!C1287e.m5684a(this.f2728b, "android.permission.ACCESS_WIFI_STATE")) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) this.f2728b.getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        try {
            C1234t c1234t;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                c1234t = new C1234t();
                c1234t.loadWifiInfo(connectionInfo);
            } else {
                c1234t = null;
            }
            return c1234t;
        } catch (Exception e) {
            C1336d.m5888c("AdInfoService", "get wifi info fail");
            return null;
        }
    }
}
