package com.amap.api.services.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
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
public class C3438z {
    private static String f12521a = null;
    private static boolean f12522b = false;
    private static String f12523c = null;
    private static String f12524d = null;
    private static String f12525e = null;
    private static String f12526f = null;

    /* compiled from: DeviceInfo */
    class C3437a extends DefaultHandler {
        C3437a() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equals(ResUtil.TYPE_STRING) && "UTDID".equals(attributes.getValue("name"))) {
                C3438z.f12522b = true;
            }
        }

        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (C3438z.f12522b) {
                C3438z.f12521a = new String(cArr, i, i2);
            }
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            C3438z.f12522b = false;
        }
    }

    public static String m17005a(Context context) {
        try {
            if (f12521a != null && !"".equals(f12521a)) {
                return f12521a;
            }
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f12521a = System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!(f12521a == null || "".equals(f12521a))) {
                return f12521a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C3437a());
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
            return f12521a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static String m17010b(Context context) {
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
                        List a = C3438z.m17007a(scanResults);
                        Object obj = 1;
                        int i = 0;
                        while (i < a.size() && i < 10) {
                            ScanResult scanResult = (ScanResult) a.get(i);
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append("||");
                            }
                            stringBuilder.append(scanResult.BSSID);
                            i++;
                        }
                    }
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                ay.m16709a(th, "DeviceInfo", "getWifiMacs");
                th.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    static String m17011c(Context context) {
        try {
            if (f12523c != null && !"".equals(f12523c)) {
                return f12523c;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
                return f12523c;
            }
            f12523c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f12523c;
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getDeviceMac");
            th.printStackTrace();
        }
    }

    static String m17012d(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return stringBuilder.toString();
            }
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                stringBuilder.append(gsmCellLocation.getLac()).append("||").append(gsmCellLocation.getCid()).append("&bt=gsm");
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int systemId = cdmaCellLocation.getSystemId();
                int networkId = cdmaCellLocation.getNetworkId();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                if (systemId < 0 || networkId < 0 || baseStationId < 0) {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                } else {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "cellInfo");
            th.printStackTrace();
        }
    }

    static String m17013e(Context context) {
        String str = "";
        try {
            str = C3438z.m17030v(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    static int m17014f(Context context) {
        int i = -1;
        try {
            i = C3438z.m17031w(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    public static int m17015g(Context context) {
        int i = -1;
        try {
            i = C3438z.m17029u(context);
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getActiveNetWorkType");
            th.printStackTrace();
        }
        return i;
    }

    static int m17016h(Context context) {
        int i = -1;
        try {
            i = C3438z.m17029u(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    static String m17017i(Context context) {
        String extraInfo;
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            extraInfo = activeNetworkInfo.getExtraInfo();
            return extraInfo;
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getNetworkExtraInfo");
            th.printStackTrace();
            extraInfo = null;
        }
    }

    static String m17018j(Context context) {
        try {
            if (f12524d != null && !"".equals(f12524d)) {
                return f12524d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f12524d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return f12524d;
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getReslution");
            th.printStackTrace();
        }
    }

    static String m17019k(Context context) {
        try {
            return C3438z.m17028t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static String m17020l(Context context) {
        try {
            return C3438z.m17028t(context);
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getActiveNetworkTypeName");
            th.printStackTrace();
            return null;
        }
    }

    static String m17021m(Context context) {
        try {
            if (f12525e != null && !"".equals(f12525e)) {
                return f12525e;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return f12525e;
            }
            f12525e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f12525e;
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getDeviceID");
            th.printStackTrace();
        }
    }

    static String m17022n(Context context) {
        String str = null;
        try {
            str = C3438z.m17026r(context);
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getSubscriberId");
            th.printStackTrace();
        }
        return str;
    }

    static String m17023o(Context context) {
        try {
            return C3438z.m17027s(context);
        } catch (Throwable th) {
            ay.m16709a(th, "DeviceInfo", "getNetworkOperatorName");
            th.printStackTrace();
            return null;
        }
    }

    static String m17024p(Context context) {
        try {
            return C3438z.m17027s(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static String m17025q(Context context) {
        try {
            return C3438z.m17026r(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String m17026r(Context context) {
        if (f12526f != null && !"".equals(f12526f)) {
            return f12526f;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return f12526f;
        }
        f12526f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return f12526f;
    }

    private static String m17027s(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    private static String m17028t(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "";
        }
        return activeNetworkInfo.getTypeName();
    }

    private static int m17029u(Context context) {
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

    private static String m17030v(Context context) {
        String str = "";
        String n = C3438z.m17022n(context);
        if (n == null || n.length() < 5) {
            return str;
        }
        return n.substring(3, 5);
    }

    private static int m17031w(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    private static List<ScanResult> m17007a(List<ScanResult> list) {
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
