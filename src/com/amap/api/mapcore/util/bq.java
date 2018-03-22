package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: DeviceInfo */
public class bq {
    private static String f11533a = "";
    private static boolean f11534b = false;
    private static String f11535c = "";
    private static String f11536d = "";
    private static String f11537e = "";
    private static String f11538f = "";

    /* compiled from: DeviceInfo */
    class C3296a extends DefaultHandler {
        C3296a() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equals(ResUtil.TYPE_STRING) && "UTDID".equals(attributes.getValue("name"))) {
                bq.f11534b = true;
            }
        }

        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (bq.f11534b) {
                bq.f11533a = new String(cArr, i, i2);
            }
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            bq.f11534b = false;
        }
    }

    static String m15718a(Context context) {
        try {
            return m15743u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    static String m15723b(Context context) {
        String str = "";
        try {
            str = m15745w(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    static int m15725c(Context context) {
        int i = -1;
        try {
            i = m15746x(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    static int m15726d(Context context) {
        int i = -1;
        try {
            i = m15744v(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    static String m15727e(Context context) {
        try {
            return m15742t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void m15721a() {
        try {
            if (VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(40964)});
            }
        } catch (Throwable e) {
            cd.m15825a(e, "DeviceInfo", "setTraficTag");
        } catch (Throwable e2) {
            cd.m15825a(e2, "DeviceInfo", "setTraficTag");
        } catch (Throwable e22) {
            cd.m15825a(e22, "DeviceInfo", "setTraficTag");
        } catch (Throwable e222) {
            cd.m15825a(e222, "DeviceInfo", "setTraficTag");
        } catch (Throwable e2222) {
            cd.m15825a(e2222, "DeviceInfo", "setTraficTag");
        }
    }

    public static String m15728f(Context context) {
        try {
            if (f11533a != null && !"".equals(f11533a)) {
                return f11533a;
            }
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f11533a = System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!(f11533a == null || "".equals(f11533a))) {
                return f11533a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C3296a());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e2) {
                e2.printStackTrace();
            } catch (SAXException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return f11533a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static String m15729g(Context context) {
        if (context != null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        return wifiManager.getConnectionInfo().getBSSID();
                    }
                    return null;
                }
            } catch (Throwable th) {
                cd.m15825a(th, "DeviceInfo", "getWifiMacs");
            }
        }
        return null;
    }

    static String m15730h(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (context != null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        List scanResults = wifiManager.getScanResults();
                        if (scanResults == null || scanResults.size() == 0) {
                            return stringBuilder.toString();
                        }
                        List a = m15720a(scanResults);
                        Object obj = 1;
                        int i = 0;
                        while (i < a.size() && i < 7) {
                            ScanResult scanResult = (ScanResult) a.get(i);
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append(";");
                            }
                            stringBuilder.append(scanResult.BSSID);
                            i++;
                        }
                    }
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                cd.m15825a(th, "DeviceInfo", "getWifiMacs");
            }
        }
        return stringBuilder.toString();
    }

    static String m15731i(Context context) {
        try {
            if (f11535c != null && !"".equals(f11535c)) {
                return f11535c;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
                return f11535c;
            }
            f11535c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f11535c;
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getDeviceMac");
        }
    }

    static String[] m15732j(Context context) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                int cid;
                int lac;
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    cid = gsmCellLocation.getCid();
                    lac = gsmCellLocation.getLac();
                    return new String[]{lac + "||" + cid, "gsm"};
                }
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    cid = cdmaCellLocation.getSystemId();
                    lac = cdmaCellLocation.getNetworkId();
                    int baseStationId = cdmaCellLocation.getBaseStationId();
                    if (cid < 0 || lac < 0 || baseStationId < 0) {
                    }
                    return new String[]{cid + "||" + lac + "||" + baseStationId, "cdma"};
                }
                return new String[]{"", ""};
            }
            return new String[]{"", ""};
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "cellInfo");
        }
    }

    static String m15733k(Context context) {
        String str = "";
        String networkOperator;
        try {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return str;
            }
            networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator) && networkOperator.length() < 3) {
                return str;
            }
            networkOperator = networkOperator.substring(3);
            return networkOperator;
        } catch (Throwable th) {
            th.printStackTrace();
            cd.m15825a(th, "DeviceInfo", "getMNC");
            networkOperator = str;
        }
    }

    public static int m15734l(Context context) {
        int i = -1;
        try {
            i = m15746x(context);
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getNetWorkType");
        }
        return i;
    }

    public static int m15735m(Context context) {
        int i = -1;
        try {
            i = m15744v(context);
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getActiveNetWorkType");
        }
        return i;
    }

    public static NetworkInfo m15736n(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    static String m15737o(Context context) {
        String str = null;
        try {
            NetworkInfo n = m15736n(context);
            if (n != null) {
                str = n.getExtraInfo();
            }
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getNetworkExtraInfo");
        }
        return str;
    }

    static String m15738p(Context context) {
        try {
            if (f11536d != null && !"".equals(f11536d)) {
                return f11536d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f11536d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return f11536d;
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getReslution");
        }
    }

    public static String m15739q(Context context) {
        try {
            if (f11537e != null && !"".equals(f11537e)) {
                return f11537e;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return f11537e;
            }
            f11537e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (f11537e == null) {
                f11537e = "";
            }
            return f11537e;
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getDeviceID");
        }
    }

    public static String m15740r(Context context) {
        String str = "";
        try {
            str = m15742t(context);
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getSubscriberId");
        }
        return str;
    }

    static String m15741s(Context context) {
        try {
            return m15743u(context);
        } catch (Throwable th) {
            cd.m15825a(th, "DeviceInfo", "getNetworkOperatorName");
            return "";
        }
    }

    private static String m15742t(Context context) {
        if (f11538f != null && !"".equals(f11538f)) {
            return f11538f;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return f11538f;
        }
        f11538f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (f11538f == null) {
            f11538f = "";
        }
        return f11538f;
    }

    private static String m15743u(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        CharSequence simOperatorName = telephonyManager.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? telephonyManager.getNetworkOperatorName() : simOperatorName;
    }

    private static int m15744v(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return -1;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static String m15745w(Context context) {
        String str = "";
        String r = m15740r(context);
        if (r == null || r.length() < 5) {
            return str;
        }
        return r.substring(3, 5);
    }

    private static int m15746x(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    private static List<ScanResult> m15720a(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                if (((ScanResult) list.get(i2 - 1)).level > ((ScanResult) list.get(i2)).level) {
                    ScanResult scanResult = (ScanResult) list.get(i2 - 1);
                    list.set(i2 - 1, list.get(i2));
                    list.set(i2, scanResult);
                }
            }
        }
        return list;
    }
}
