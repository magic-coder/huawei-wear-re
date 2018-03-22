package com.cmb.pboc.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.amap.api.location.LocationManagerProxy;
import com.cmb.pboc.context.ContextHolder;
import com.cmb.pboc.logger.PbocLog;
import java.util.List;

public class DeviceInfo {
    private static final String f13377a = DeviceInfo.class.getSimpleName();
    private static volatile DeviceInfo f13378b;
    private String f13379A = "";
    private String f13380B = "";
    private String f13381C = "";
    private String f13382D = "";
    private String f13383E = "com.richhouse.android.tsm2.service";
    private String f13384F = "";
    private String f13385G = "com.snowballtech.walletservice";
    private String f13386H = "";
    private String f13387I = "";
    private String f13388J = "";
    private String f13389c = "";
    private String f13390d = "";
    private String f13391e = "";
    private String f13392f = "";
    private String f13393g = "";
    private String f13394h = "";
    private String f13395i = "Android";
    private String f13396j = "";
    private String f13397k = "";
    private String f13398l = "";
    private String f13399m = "";
    private String f13400n = "";
    private String f13401o = "";
    private String f13402p = "";
    private String f13403q = "";
    private String f13404r = "";
    private String f13405s = "";
    private String f13406t = "";
    private String f13407u = "";
    private String f13408v = "";
    private String f13409w = "";
    private String f13410x = "";
    private String f13411y = "";
    private String f13412z = "";

    private DeviceInfo() {
        PbocLog.m17738a(f13377a, "Building DeviceInfo.");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("其它信息获取：");
        stringBuffer.append("\n*************************\n");
        Context b = ContextHolder.m17714a().m17716b();
        if (b == null) {
            PbocLog.m17741d(f13377a, "context obj isn't ok!");
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService("phone");
                if (telephonyManager == null) {
                    Log.e(f13377a, "TelephonyManager is null, please check the reason, maybe no privilege!");
                } else {
                    int length;
                    this.f13389c = Build.MANUFACTURER;
                    if (this.f13389c == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal brand failed");
                        this.f13389c = "";
                    }
                    this.f13390d = Build.MODEL;
                    if (this.f13390d == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal model failed");
                        this.f13390d = "";
                    }
                    this.f13391e = Build.SERIAL;
                    if (this.f13391e == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal serial failed");
                        this.f13391e = "";
                    }
                    this.f13392f = telephonyManager.getDeviceId();
                    if (this.f13392f == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal imei failed");
                        this.f13392f = "";
                    }
                    this.f13393g = telephonyManager.getDeviceSoftwareVersion();
                    if (this.f13393g == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal Software Version failed");
                        this.f13393g = "";
                    }
                    this.f13394h = Build.DISPLAY;
                    if (this.f13394h == null) {
                        PbocLog.m17741d(f13377a, "Get Terminal Rom Version failed");
                        this.f13394h = "";
                    }
                    this.f13396j = VERSION.RELEASE;
                    if (this.f13396j == null) {
                        PbocLog.m17741d(f13377a, "Get OS Version failed");
                        this.f13396j = "";
                    }
                    this.f13397k = String.valueOf(VERSION.SDK_INT);
                    if (this.f13397k == null) {
                        PbocLog.m17741d(f13377a, "Get OS API Code failed");
                        this.f13397k = "";
                    }
                    this.f13398l = Build.USER;
                    if (this.f13398l == null) {
                        PbocLog.m17741d(f13377a, "Get OS User failed");
                        this.f13398l = "";
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("BOARD:" + Build.BOARD);
                    stringBuffer2.append("\nBOOTLOADER:" + Build.BOOTLOADER);
                    stringBuffer2.append("\nBRAND:" + Build.BRAND);
                    stringBuffer2.append("\nCPU_ABI:" + Build.CPU_ABI);
                    stringBuffer2.append("\nCPU_ABI2:" + Build.CPU_ABI2);
                    stringBuffer2.append("\nDEVICE:" + Build.DEVICE);
                    stringBuffer2.append("\nDISPLAY:" + Build.DISPLAY);
                    stringBuffer2.append("\nFINGERPRINT:" + Build.FINGERPRINT);
                    stringBuffer2.append("\nHARDWARE:" + Build.HARDWARE);
                    stringBuffer2.append("\nHOST:" + Build.HOST);
                    stringBuffer2.append("\nID:" + Build.ID);
                    stringBuffer2.append("\nMANUFACTURER:" + Build.MANUFACTURER);
                    stringBuffer2.append("\nMODEL:" + Build.MODEL);
                    stringBuffer2.append("\nPRODUCT:" + Build.PRODUCT);
                    stringBuffer2.append("\nRADIO:" + Build.getRadioVersion());
                    stringBuffer2.append("\nSERIAL:" + Build.SERIAL);
                    stringBuffer2.append("\nTAGS:" + Build.TAGS);
                    stringBuffer2.append("\nTIME:" + Build.TIME);
                    stringBuffer2.append("\nTYPE:" + Build.TYPE);
                    stringBuffer2.append("\nUNKNOWN:unknown");
                    stringBuffer2.append("\nUSER:" + Build.USER);
                    stringBuffer2.append("\nVERSION.CODENAME:" + VERSION.CODENAME);
                    stringBuffer2.append("\nVERSION.INCREMENTAL:" + VERSION.INCREMENTAL);
                    stringBuffer2.append("\nVERSION.RELEASE:" + VERSION.RELEASE);
                    stringBuffer2.append("\nVERSION.SDK_INT:" + VERSION.SDK_INT);
                    this.f13399m = Build.HOST;
                    if (this.f13399m == null) {
                        PbocLog.m17741d(f13377a, "Get OS Addition failed");
                        this.f13399m = "";
                    }
                    this.f13400n = telephonyManager.getSubscriberId();
                    if (this.f13400n == null) {
                        PbocLog.m17741d(f13377a, "Get SIM Imsi failed");
                        this.f13400n = "";
                    }
                    this.f13401o = telephonyManager.getLine1Number();
                    if (this.f13401o == null || "".equals(this.f13401o)) {
                        PbocLog.m17740c(f13377a, "Fail to get mobile phone number");
                        this.f13401o = "15015015015";
                    } else {
                        PbocLog.m17739b(f13377a, "Get mobile phone number successfully! Value: " + this.f13401o);
                        length = this.f13401o.length();
                        if (length > 11) {
                            this.f13401o = this.f13401o.substring(length - 11);
                        }
                    }
                    this.f13402p = telephonyManager.getNetworkOperatorName();
                    if (this.f13402p == null) {
                        PbocLog.m17741d(f13377a, "Get SIM operator failed");
                        this.f13402p = "";
                    }
                    switch (telephonyManager.getSimState()) {
                        case 0:
                            PbocLog.m17740c(f13377a, "Get SIM state: SIM_STATE_UNKNOWN");
                            this.f13403q = "SIM_STATE_ABSENT";
                            break;
                        case 1:
                            PbocLog.m17740c(f13377a, "Get SIM state: SIM_STATE_ABSENT");
                            this.f13403q = "SIM_STATE_ABSENT";
                            break;
                        case 2:
                            PbocLog.m17740c(f13377a, "Get SIM state: SIM_STATE_PIN_REQUIRED");
                            this.f13403q = "SIM_STATE_PIN_REQUIRED";
                            break;
                        case 3:
                            PbocLog.m17740c(f13377a, "Get SIM state: SIM_STATE_PUK_REQUIRED");
                            this.f13403q = "SIM_STATE_PUK_REQUIRED";
                            break;
                        case 4:
                            PbocLog.m17740c(f13377a, "Get SIM state: SIM_STATE_NETWORK_LOCKED");
                            this.f13403q = "SIM_STATE_NETWORK_LOCKED";
                            break;
                        case 5:
                            PbocLog.m17739b(f13377a, "Get SIM state: SIM_STATE_READY");
                            this.f13403q = "SIM_STATE_READY";
                            break;
                        default:
                            PbocLog.m17741d(f13377a, "Get SIM state Failed! Other value:");
                            this.f13403q = "ERROR";
                            break;
                    }
                    this.f13404r = telephonyManager.getSimSerialNumber();
                    if (this.f13404r == null) {
                        PbocLog.m17741d(f13377a, "Get SIM Iccid failed");
                        this.f13404r = "";
                    }
                    length = telephonyManager.getNetworkType();
                    switch (length) {
                        case 0:
                            PbocLog.m17740c(f13377a, "Get Network type successfully! NETWORK_TYPE_UNKNOWN");
                            this.f13405s = "UNKNOWN";
                            break;
                        case 1:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_GPRS");
                            this.f13405s = "GPRS";
                            break;
                        case 2:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_EDGE");
                            this.f13405s = "EDGE";
                            break;
                        case 3:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_UMTS");
                            this.f13405s = "UMTS";
                            break;
                        case 4:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_CDMA");
                            this.f13405s = "CDMA";
                            break;
                        case 5:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_EVDO_0");
                            this.f13405s = "EVDO_0";
                            break;
                        case 6:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_EVDO_A");
                            this.f13405s = "EVDO_A";
                            break;
                        case 7:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_1xRTT");
                            this.f13405s = "1xRTT";
                            break;
                        case 8:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_HSDPA");
                            this.f13405s = "HSDPA";
                            break;
                        case 9:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_HSUPA");
                            this.f13405s = "HSUPA";
                            break;
                        case 10:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_HSPA");
                            this.f13405s = "HSPA";
                            break;
                        case 11:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_IDEN");
                            this.f13405s = "IDEN";
                            break;
                        case 12:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_EVDO_B");
                            this.f13405s = "EVDO_B";
                            break;
                        case 13:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_LTE");
                            this.f13405s = "LTE";
                            break;
                        case 14:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_EHRPD");
                            this.f13405s = "EHRPD";
                            break;
                        case 15:
                            PbocLog.m17739b(f13377a, "Get Network type successfully! NETWORK_TYPE_HSPAP");
                            this.f13405s = "HSPAP";
                            break;
                        default:
                            PbocLog.m17741d(f13377a, "Get Network type failed! Value:" + length);
                            this.f13405s = "ERROR";
                            break;
                    }
                    if (telephonyManager.isNetworkRoaming()) {
                        this.f13406t = "Y";
                    } else {
                        this.f13406t = "N";
                    }
                    stringBuffer.append("移动通信类型:");
                    length = telephonyManager.getPhoneType();
                    if (length == 1) {
                        stringBuffer.append("GSM");
                    } else if (length == 2) {
                        stringBuffer.append("CDMA");
                    } else if (length == 3) {
                        stringBuffer.append("SIP");
                    } else if (length == 0) {
                        stringBuffer.append("NONE");
                    } else {
                        stringBuffer.append("null");
                    }
                    stringBuffer.append("\n*************************\n");
                    stringBuffer.append("电信网络国别:");
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (networkCountryIso.equals("") || networkCountryIso == null) {
                        stringBuffer.append("null");
                    } else {
                        stringBuffer.append(networkCountryIso);
                    }
                    stringBuffer.append("\n*************************\n");
                    stringBuffer.append("电信公司代码:");
                    networkCountryIso = telephonyManager.getNetworkOperator();
                    if (networkCountryIso.equals("") || networkCountryIso == null) {
                        stringBuffer.append("null");
                    } else {
                        stringBuffer.append(networkCountryIso);
                    }
                    stringBuffer.append("\n*************************\n");
                    stringBuffer.append("SIM卡国别:");
                    String simCountryIso = telephonyManager.getSimCountryIso();
                    if (simCountryIso.equals("") || simCountryIso == null) {
                        stringBuffer.append("null");
                    } else {
                        stringBuffer.append(simCountryIso);
                    }
                    stringBuffer.append("\n*************************\n");
                }
            } catch (Exception e) {
                Log.e(f13377a, "Get TelephonyManager Failed! Msg:" + e.getMessage());
            }
        }
        b = ContextHolder.m17714a().m17716b();
        if (b == null) {
            PbocLog.m17741d(f13377a, "context obj isn't ok!");
        } else {
            try {
                WifiManager wifiManager = (WifiManager) b.getSystemService("wifi");
                if (wifiManager == null) {
                    PbocLog.m17741d(f13377a, "Do not support Wifi!");
                    this.f13407u = "N";
                } else {
                    PbocLog.m17739b(f13377a, "Support Wifi!");
                    this.f13407u = "Y";
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                switch (wifiManager.getWifiState()) {
                    case 0:
                        PbocLog.m17739b(f13377a, "Wifi state is WIFI_STATE_DISABLING");
                        this.f13408v = "DISABLING";
                        break;
                    case 1:
                        PbocLog.m17739b(f13377a, "Wifi state is WIFI_STATE_DISABLED");
                        this.f13408v = "DISABLED";
                        break;
                    case 2:
                        PbocLog.m17739b(f13377a, "Wifi state is WIFI_STATE_ENABLING");
                        this.f13408v = "ENABLING";
                        break;
                    case 3:
                        PbocLog.m17739b(f13377a, "Wifi state is WIFI_STATE_ENABLED");
                        this.f13408v = "ENABLED";
                        break;
                    case 4:
                        PbocLog.m17740c(f13377a, "Wifi state is WIFI_STATE_UNKNOWN");
                        this.f13408v = "UNKNOWN";
                        break;
                    default:
                        PbocLog.m17741d(f13377a, "Get wifi state error!");
                        this.f13408v = "ERROR";
                        break;
                }
                this.f13409w = connectionInfo.getBSSID();
                if (this.f13409w != null) {
                    PbocLog.m17739b(f13377a, "Wifi router is:" + this.f13409w);
                } else {
                    PbocLog.m17741d(f13377a, "No Wifi router value:" + this.f13409w);
                    this.f13409w = "";
                }
                this.f13410x = connectionInfo.getMacAddress();
                if (this.f13410x != null) {
                    PbocLog.m17739b(f13377a, "The mac is:" + this.f13410x);
                } else {
                    PbocLog.m17741d(f13377a, "Get mac wrong! Value:" + this.f13410x);
                    this.f13410x = "";
                }
                int ipAddress = connectionInfo.getIpAddress();
                if (ipAddress != 0) {
                    this.f13411y = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                    PbocLog.m17739b(f13377a, "The IP Address is:" + this.f13411y);
                } else {
                    PbocLog.m17741d(f13377a, "No IP Address! Value:" + ipAddress);
                }
                this.f13412z = connectionInfo.getSSID();
                if (this.f13412z == null) {
                    PbocLog.m17741d(f13377a, "Get ssid wrong! Value:" + this.f13412z);
                    this.f13412z = "";
                } else if (this.f13412z.equalsIgnoreCase("<unknown ssid>")) {
                    PbocLog.m17741d(f13377a, "No ssid! Value:" + this.f13412z);
                } else if (this.f13412z.equalsIgnoreCase("0x")) {
                    PbocLog.m17741d(f13377a, "No ssid! Value:" + this.f13412z);
                } else {
                    PbocLog.m17739b(f13377a, "The ssid is:" + this.f13412z);
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("其它wifi信息获取：");
                stringBuffer3.append("\n*************************\n");
                stringBuffer3.append("\n Network Id = " + connectionInfo.getNetworkId());
                stringBuffer3.append("\n Link Speed = " + connectionInfo.getLinkSpeed());
                stringBuffer3.append("\n Rssi = " + connectionInfo.getRssi());
                stringBuffer3.append("\n*************************\n");
            } catch (Exception e2) {
                PbocLog.m17741d(f13377a, "Get WifiManager Failed! Msg:" + e2.getMessage());
            }
        }
        b = ContextHolder.m17714a().m17716b();
        if (b == null) {
            PbocLog.m17741d(f13377a, "context obj isn't ok!");
        } else {
            try {
                NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(b);
                if (defaultAdapter == null) {
                    this.f13381C = "N";
                    this.f13382D = "";
                } else {
                    this.f13381C = "Y";
                    if (defaultAdapter.isEnabled()) {
                        this.f13382D = "ON";
                    } else {
                        this.f13382D = "OFF";
                    }
                }
                stringBuffer3 = new StringBuffer();
                stringBuffer3.append("其它NFC信息获取：");
                stringBuffer3.append("\n*************************\n");
            } catch (Exception e22) {
                PbocLog.m17741d(f13377a, "Get NfcAdapter Failed! Msg:" + e22.getMessage());
            }
        }
        b = ContextHolder.m17714a().m17716b();
        if (b == null) {
            PbocLog.m17741d(f13377a, "context obj isn't ok!");
        } else {
            try {
                LocationManager locationManager = (LocationManager) b.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
                if (locationManager == null) {
                    this.f13379A = "N";
                    this.f13380B = "";
                } else {
                    this.f13379A = "Y";
                    if (locationManager.isProviderEnabled("gps")) {
                        this.f13380B = "ON";
                    } else {
                        this.f13380B = "OFF";
                    }
                }
                stringBuffer3 = new StringBuffer();
                stringBuffer3.append("其它Location信息获取：");
                stringBuffer3.append("\n*************************\n");
            } catch (Exception e222) {
                PbocLog.m17741d(f13377a, "Get LocationManager Failed! Msg:" + e222.getMessage());
            }
        }
        m17718o();
    }

    public static DeviceInfo m17717a() {
        if (f13378b == null) {
            synchronized (DeviceInfo.class) {
                if (f13378b == null) {
                    f13378b = new DeviceInfo();
                }
            }
        }
        return f13378b;
    }

    private void m17718o() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("其它服务信息获取：");
        stringBuffer.append("\n*************************\n");
        Context b = ContextHolder.m17714a().m17716b();
        if (b == null) {
            PbocLog.m17741d(f13377a, "context obj isn't ok!");
            return;
        }
        try {
            PackageManager packageManager = b.getPackageManager();
            if (packageManager != null) {
                List installedPackages = packageManager.getInstalledPackages(0);
                for (int i = 0; i < installedPackages.size(); i++) {
                    PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
                    if (this.f13383E.equalsIgnoreCase(packageInfo.packageName)) {
                        this.f13384F = packageInfo.versionName;
                    } else if (this.f13385G.equalsIgnoreCase(packageInfo.packageName)) {
                        this.f13386H = packageInfo.versionName;
                    }
                }
                this.f13387I = b.getPackageName();
                try {
                    this.f13388J = b.getPackageManager().getPackageInfo(b.getPackageName(), 0).versionName;
                } catch (NameNotFoundException e) {
                    PbocLog.m17741d(f13377a, e.getMessage());
                    this.f13388J = "";
                }
            }
        } catch (Exception e2) {
            PbocLog.m17741d(f13377a, "Get PackageManager Failed! Msg:" + e2.getMessage());
        }
    }

    public final String m17719b() {
        return this.f13389c;
    }

    public final String m17720c() {
        return this.f13390d;
    }

    public final String m17721d() {
        return this.f13391e;
    }

    public final String m17722e() {
        return this.f13392f;
    }

    public final String m17723f() {
        return this.f13394h;
    }

    public final String m17724g() {
        return this.f13395i;
    }

    public final String m17725h() {
        return this.f13396j;
    }

    public final String m17726i() {
        return this.f13399m;
    }

    public final String m17727j() {
        return this.f13400n;
    }

    public final String m17728k() {
        return this.f13401o;
    }

    public final String m17729l() {
        return this.f13402p;
    }

    public final String m17730m() {
        return this.f13387I;
    }

    public final String m17731n() {
        return this.f13388J;
    }
}
