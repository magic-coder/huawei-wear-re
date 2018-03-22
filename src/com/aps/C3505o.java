package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GpsStatus.NmeaListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.internal.view.SupportMenu;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.amap.api.location.LocationManagerProxy;
import com.android.volley.DefaultRetryPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TreeMap;

public final class C3505o {
    private static int f13203D = 10000;
    private static C3505o f13204u = null;
    private Timer f13205A = null;
    private Thread f13206B = null;
    private Looper f13207C = null;
    private Context f13208a = null;
    private TelephonyManager f13209b = null;
    private LocationManager f13210c = null;
    private WifiManager f13211d = null;
    private SensorManager f13212e = null;
    private String f13213f = "";
    private String f13214g = "";
    private String f13215h = "";
    private boolean f13216i = false;
    private int f13217j = 0;
    private boolean f13218k = false;
    private long f13219l = -1;
    private String f13220m = "";
    private String f13221n = "";
    private int f13222o = 0;
    private int f13223p = 0;
    private int f13224q = 0;
    private String f13225r = "";
    private long f13226s = 0;
    private long f13227t = 0;
    private C3507q f13228v = null;
    private C3508r f13229w = null;
    private CellLocation f13230x = null;
    private C3509s f13231y = null;
    private List f13232z = new ArrayList();

    private C3505o(Context context) {
        if (context != null) {
            this.f13208a = context;
            this.f13213f = Build.MODEL;
            this.f13209b = (TelephonyManager) context.getSystemService("phone");
            this.f13210c = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            this.f13211d = (WifiManager) context.getSystemService("wifi");
            this.f13212e = (SensorManager) context.getSystemService("sensor");
            if (this.f13209b != null && this.f13211d != null) {
                try {
                    this.f13214g = this.f13209b.getDeviceId();
                } catch (Exception e) {
                }
                this.f13215h = this.f13209b.getSubscriberId();
                if (this.f13211d.getConnectionInfo() != null) {
                    this.f13221n = this.f13211d.getConnectionInfo().getMacAddress();
                    if (this.f13221n != null && this.f13221n.length() > 0) {
                        this.f13221n = this.f13221n.replace(":", "");
                    }
                }
                String[] b = C3505o.m17584b(this.f13209b);
                this.f13222o = Integer.parseInt(b[0]);
                this.f13223p = Integer.parseInt(b[1]);
                this.f13224q = this.f13209b.getNetworkType();
                this.f13225r = context.getPackageName();
                this.f13216i = this.f13209b.getPhoneType() == 2;
            }
        }
    }

    private void m17556A() {
        if (this.f13211d != null) {
            try {
                if (al.f12904a) {
                    this.f13211d.startScan();
                }
            } catch (Exception e) {
            }
        }
    }

    private CellLocation m17557B() {
        if (this.f13209b == null) {
            return null;
        }
        CellLocation b;
        try {
            b = C3505o.m17580b((List) C3502l.m17538a(this.f13209b, "getAllCellInfo", new Object[0]));
        } catch (NoSuchMethodException e) {
            b = null;
        } catch (Exception e2) {
            b = null;
        }
        return b;
    }

    private static int m17558a(CellLocation cellLocation, Context context) {
        if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 || cellLocation == null) {
            return 9;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Exception e) {
            return 9;
        }
    }

    protected static C3505o m17563a(Context context) {
        if (f13204u == null && C3505o.m17588c(context)) {
            Object obj;
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            if (locationManager != null) {
                for (String str : locationManager.getAllProviders()) {
                    if (!str.equals("passive")) {
                        if (str.equals("gps")) {
                        }
                    }
                    obj = 1;
                }
            }
            obj = null;
            if (obj != null) {
                f13204u = new C3505o(context);
            }
        }
        return f13204u;
    }

    private void m17569a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.f13208a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.f13208a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    static /* synthetic */ void m17570a(C3505o c3505o, NmeaListener nmeaListener) {
        if (c3505o.f13210c != null && nmeaListener != null) {
            c3505o.f13210c.addNmeaListener(nmeaListener);
        }
    }

    static /* synthetic */ void m17571a(C3505o c3505o, PhoneStateListener phoneStateListener) {
        if (c3505o.f13209b != null) {
            c3505o.f13209b.listen(phoneStateListener, 273);
        }
    }

    private static void m17572a(List list) {
        if (list != null && list.size() > 0) {
            Object hashMap = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                ScanResult scanResult = (ScanResult) list.get(i);
                if (scanResult.SSID == null) {
                    scanResult.SSID = "null";
                }
                hashMap.put(Integer.valueOf(scanResult.level), scanResult);
            }
            TreeMap treeMap = new TreeMap(Collections.reverseOrder());
            treeMap.putAll(hashMap);
            list.clear();
            for (Integer num : treeMap.keySet()) {
                list.add(treeMap.get(num));
            }
            hashMap.clear();
            treeMap.clear();
        }
    }

    private boolean m17573a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        switch (C3505o.m17558a(cellLocation, this.f13208a)) {
            case 1:
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                if (gsmCellLocation.getLac() == -1 || gsmCellLocation.getLac() == 0 || gsmCellLocation.getLac() > SupportMenu.USER_MASK || gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == 0 || gsmCellLocation.getCid() == SupportMenu.USER_MASK) {
                    return false;
                }
                if (gsmCellLocation.getCid() >= 268435455) {
                    return false;
                }
                break;
            case 2:
                try {
                    if (C3502l.m17543b(cellLocation, "getSystemId", new Object[0]) <= 0 || C3502l.m17543b(cellLocation, "getNetworkId", new Object[0]) < 0) {
                        return false;
                    }
                    if (C3502l.m17543b(cellLocation, "getBaseStationId", new Object[0]) < 0) {
                        return false;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
        }
        return true;
    }

    private static boolean m17575a(Object obj) {
        try {
            Method declaredMethod = WifiManager.class.getDeclaredMethod("isScanAlwaysAvailable", null);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(obj, null)).booleanValue();
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static int m17578b(Object obj) {
        try {
            Method declaredMethod = Sensor.class.getDeclaredMethod("getMinDelay", null);
            if (declaredMethod != null) {
                return ((Integer) declaredMethod.invoke(obj, null)).intValue();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    private static CellLocation m17580b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i;
        CellLocation cellLocation;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        CellLocation cellLocation2 = null;
        int i2 = 0;
        int i3 = 0;
        CellLocation cellLocation3 = null;
        while (i2 < list.size()) {
            CellLocation cellLocation4;
            Object obj = list.get(i2);
            if (obj != null) {
                try {
                    Class loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    i = loadClass.isInstance(obj) ? 1 : loadClass2.isInstance(obj) ? 2 : loadClass3.isInstance(obj) ? 3 : loadClass4.isInstance(obj) ? 4 : 0;
                    if (i > 0) {
                        Object obj2 = null;
                        if (i == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Exception e) {
                                i3 = i;
                                cellLocation4 = cellLocation2;
                            }
                        } else if (i == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (i == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (i == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        obj = C3502l.m17538a(obj2, "getCellIdentity", new Object[0]);
                        if (obj != null) {
                            if (i != 4) {
                                int b;
                                if (i != 3) {
                                    i3 = C3502l.m17543b(obj, "getLac", new Object[0]);
                                    b = C3502l.m17543b(obj, "getCid", new Object[0]);
                                    cellLocation4 = new GsmCellLocation();
                                    cellLocation4.setLacAndCid(i3, b);
                                    cellLocation = cellLocation3;
                                    cellLocation3 = cellLocation4;
                                    break;
                                }
                                i3 = C3502l.m17543b(obj, "getTac", new Object[0]);
                                b = C3502l.m17543b(obj, "getCi", new Object[0]);
                                cellLocation4 = new GsmCellLocation();
                                try {
                                    cellLocation4.setLacAndCid(i3, b);
                                    cellLocation = cellLocation3;
                                    cellLocation3 = cellLocation4;
                                    break;
                                } catch (Exception e2) {
                                    i3 = i;
                                }
                            } else {
                                cellLocation = new CdmaCellLocation();
                                try {
                                    cellLocation.setCellLocationData(C3502l.m17543b(obj, "getBasestationId", new Object[0]), C3502l.m17543b(obj, "getLatitude", new Object[0]), C3502l.m17543b(obj, "getLongitude", new Object[0]), C3502l.m17543b(obj, "getSystemId", new Object[0]), C3502l.m17543b(obj, "getNetworkId", new Object[0]));
                                    cellLocation3 = cellLocation2;
                                    break;
                                } catch (Exception e3) {
                                    cellLocation3 = cellLocation;
                                    cellLocation4 = cellLocation2;
                                    i3 = i;
                                }
                            }
                        } else {
                            i3 = i;
                            cellLocation4 = cellLocation2;
                        }
                    } else {
                        i3 = i;
                        cellLocation4 = cellLocation2;
                    }
                } catch (Exception e4) {
                    cellLocation4 = cellLocation2;
                }
            } else {
                cellLocation4 = cellLocation2;
            }
            i2++;
            cellLocation2 = cellLocation4;
        }
        i = i3;
        cellLocation = cellLocation3;
        cellLocation3 = cellLocation2;
        return i != 4 ? cellLocation3 : cellLocation;
    }

    private void m17582b(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.f13208a != null) {
            try {
                this.f13208a.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    protected static boolean m17583b(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (!Secure.getString(context.getContentResolver(), "mock_location").equals("0")) {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
            String str = "android.permission.ACCESS_MOCK_LOCATION";
            String packageName = context.getPackageName();
            z = false;
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (z) {
                    break;
                }
                boolean z2;
                try {
                    String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            if (!strArr[i].equals(str)) {
                                i++;
                            } else if (!applicationInfo.packageName.equals(packageName)) {
                                z2 = true;
                                z = z2;
                            }
                        }
                    }
                } catch (Exception e) {
                    z2 = z;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private static String[] m17584b(TelephonyManager telephonyManager) {
        int i = 0;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = new String[]{"0", "0"};
        if (TextUtils.isDigitsOnly(str) && str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] toCharArray = str.substring(3).toCharArray();
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = str.substring(3, i + 3);
        }
        return strArr;
    }

    private static boolean m17588c(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (String a : al.f12905b) {
                if (!al.m17272a(strArr, a)) {
                    return false;
                }
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    protected final String m17595a(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return "null";
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getName() == null || ((Sensor) sensorList.get(i)).getName().length() <= 0) ? "null" : ((Sensor) sensorList.get(i)).getName();
    }

    protected final List m17596a(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        if (m17602c()) {
            CellLocation cellLocation = (CellLocation) m17614j().get(1);
            if (cellLocation != null && (cellLocation instanceof GsmCellLocation)) {
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getLac()));
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getCid()));
                if (((double) (currentTimeMillis - ((Long) m17614j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    protected final void m17597a() {
        String str = "";
        m17600b();
        if (this.f13207C != null) {
            this.f13207C.quit();
            this.f13207C = null;
        }
        if (this.f13206B != null) {
            this.f13206B.interrupt();
            this.f13206B = null;
        }
        this.f13206B = new C3506p(this, str);
        this.f13206B.start();
    }

    protected final double m17598b(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return 0.0d;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0.0d : (double) ((Sensor) sensorList.get(i)).getMaximumRange();
    }

    protected final List m17599b(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        if (m17602c()) {
            CellLocation cellLocation = (CellLocation) m17614j().get(1);
            if (cellLocation != null && (cellLocation instanceof CdmaCellLocation)) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                arrayList.add(Integer.valueOf(cdmaCellLocation.getSystemId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getNetworkId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLongitude()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                if (((double) (currentTimeMillis - ((Long) m17614j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    protected final void m17600b() {
        if (this.f13228v != null) {
            PhoneStateListener phoneStateListener = this.f13228v;
            if (this.f13209b != null) {
                this.f13209b.listen(phoneStateListener, 0);
            }
            this.f13228v = null;
        }
        if (this.f13229w != null) {
            NmeaListener nmeaListener = this.f13229w;
            if (!(this.f13210c == null || nmeaListener == null)) {
                this.f13210c.removeNmeaListener(nmeaListener);
            }
            this.f13229w = null;
        }
        if (this.f13205A != null) {
            this.f13205A.cancel();
            this.f13205A = null;
        }
        if (this.f13207C != null) {
            this.f13207C.quit();
            this.f13207C = null;
        }
        if (this.f13206B != null) {
            this.f13206B.interrupt();
            this.f13206B = null;
        }
    }

    protected final int m17601c(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return 0;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0 : C3505o.m17578b(sensorList.get(i));
    }

    protected final boolean m17602c() {
        CellLocation cellLocation = null;
        if (this.f13209b != null && this.f13209b.getSimState() == 5 && this.f13218k) {
            return true;
        }
        if (this.f13209b != null) {
            try {
                cellLocation = this.f13209b.getCellLocation();
            } catch (Exception e) {
            }
            if (cellLocation != null) {
                this.f13227t = System.currentTimeMillis();
                this.f13230x = cellLocation;
                return true;
            }
        }
        return false;
    }

    protected final int m17603d(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return 0;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0 : (int) (((double) ((Sensor) sensorList.get(i)).getPower()) * 100.0d);
    }

    protected final boolean m17604d() {
        return this.f13211d != null && (this.f13211d.isWifiEnabled() || C3505o.m17575a(this.f13211d));
    }

    protected final double m17605e(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return 0.0d;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null) ? 0.0d : (double) ((Sensor) sensorList.get(i)).getResolution();
    }

    protected final boolean m17606e() {
        try {
            if (this.f13210c != null && this.f13210c.isProviderEnabled("gps")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    protected final byte m17607f(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return TagName.ELECTRONIC_PUBLISH_START_TIME;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getType() > 127) ? TagName.ELECTRONIC_PUBLISH_START_TIME : (byte) ((Sensor) sensorList.get(i)).getType();
    }

    protected final String m17608f() {
        if (this.f13213f == null) {
            this.f13213f = Build.MODEL;
        }
        return this.f13213f != null ? this.f13213f : "";
    }

    protected final String m17609g() {
        if (this.f13214g == null && this.f13208a != null) {
            this.f13209b = (TelephonyManager) this.f13208a.getSystemService("phone");
            if (this.f13209b != null) {
                try {
                    this.f13214g = this.f13209b.getDeviceId();
                } catch (Exception e) {
                }
            }
        }
        return this.f13214g != null ? this.f13214g : "";
    }

    protected final String m17610g(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return "null";
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getVendor() == null || ((Sensor) sensorList.get(i)).getVendor().length() <= 0) ? "null" : ((Sensor) sensorList.get(i)).getVendor();
    }

    protected final byte m17611h(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return TagName.ELECTRONIC_PUBLISH_START_TIME;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return (sensorList == null || sensorList.get(i) == null || ((Sensor) sensorList.get(i)).getType() > 127) ? TagName.ELECTRONIC_PUBLISH_START_TIME : (byte) ((Sensor) sensorList.get(i)).getVersion();
    }

    protected final String m17612h() {
        if (this.f13215h == null && this.f13208a != null) {
            this.f13209b = (TelephonyManager) this.f13208a.getSystemService("phone");
            if (this.f13209b != null) {
                this.f13215h = this.f13209b.getSubscriberId();
            }
        }
        return this.f13215h != null ? this.f13215h : "";
    }

    protected final boolean m17613i() {
        return this.f13216i;
    }

    protected final List m17614j() {
        if (System.getInt(this.f13208a.getContentResolver(), "airplane_mode_on", 0) == 1) {
            return new ArrayList();
        }
        if (!m17602c()) {
            return new ArrayList();
        }
        Object B;
        List arrayList = new ArrayList();
        if (!m17573a(this.f13230x)) {
            B = m17557B();
            if (m17573a((CellLocation) B)) {
                this.f13227t = System.currentTimeMillis();
                arrayList.add(Long.valueOf(this.f13227t));
                arrayList.add(B);
                return arrayList;
            }
        }
        B = this.f13230x;
        arrayList.add(Long.valueOf(this.f13227t));
        arrayList.add(B);
        return arrayList;
    }

    protected final List m17615k() {
        int i = 0;
        List arrayList = new ArrayList();
        if (!m17604d()) {
            return new ArrayList();
        }
        List arrayList2 = new ArrayList();
        synchronized (this) {
            if ((System.currentTimeMillis() - this.f13226s < 3500 ? 1 : 0) != 0) {
                arrayList2.add(Long.valueOf(this.f13226s));
                while (i < this.f13232z.size()) {
                    arrayList.add(this.f13232z.get(i));
                    i++;
                }
                arrayList2.add(arrayList);
            }
        }
        return arrayList2;
    }

    protected final byte m17616l() {
        return m17602c() ? (byte) this.f13217j : Byte.MIN_VALUE;
    }

    protected final List m17617m() {
        List arrayList = new ArrayList();
        if (this.f13209b == null) {
            return arrayList;
        }
        if (!m17602c()) {
            return arrayList;
        }
        if (this.f13209b.getSimState() == 1) {
            return arrayList;
        }
        int i = 0;
        for (NeighboringCellInfo neighboringCellInfo : this.f13209b.getNeighboringCellInfo()) {
            if (i > 15) {
                break;
            } else if (!(neighboringCellInfo.getLac() == 0 || neighboringCellInfo.getLac() == SupportMenu.USER_MASK || neighboringCellInfo.getCid() == SupportMenu.USER_MASK || neighboringCellInfo.getCid() == 268435455)) {
                arrayList.add(neighboringCellInfo);
                i++;
            }
        }
        return arrayList;
    }

    protected final List m17618n() {
        long j;
        Object obj;
        List arrayList = new ArrayList();
        String str = "";
        if (m17606e()) {
            long j2 = this.f13219l;
            j = j2;
            obj = this.f13220m;
        } else {
            String str2 = str;
            j = -1;
            String str3 = str2;
        }
        if (j <= 0) {
            j = System.currentTimeMillis() / 1000;
        }
        if (j > 2147483647L) {
            j /= 1000;
        }
        arrayList.add(Long.valueOf(j));
        arrayList.add(obj);
        return arrayList;
    }

    protected final long m17619o() {
        long j = 0;
        long j2 = this.f13219l;
        if (j2 > 0) {
            j = j2;
            int length = String.valueOf(j2).length();
            while (length != 13) {
                j = length > 13 ? j / 10 : j * 10;
                length = String.valueOf(j).length();
            }
        }
        return j;
    }

    protected final String m17620p() {
        if (this.f13221n == null && this.f13208a != null) {
            this.f13211d = (WifiManager) this.f13208a.getSystemService("wifi");
            if (!(this.f13211d == null || this.f13211d.getConnectionInfo() == null)) {
                this.f13221n = this.f13211d.getConnectionInfo().getMacAddress();
                if (this.f13221n != null && this.f13221n.length() > 0) {
                    this.f13221n = this.f13221n.replace(":", "");
                }
            }
        }
        return this.f13221n != null ? this.f13221n : "";
    }

    protected final int m17621q() {
        return this.f13222o;
    }

    protected final int m17622r() {
        return this.f13223p;
    }

    protected final int m17623s() {
        return this.f13224q;
    }

    protected final String m17624t() {
        if (this.f13225r == null && this.f13208a != null) {
            this.f13225r = this.f13208a.getPackageName();
        }
        return this.f13225r != null ? this.f13225r : "";
    }

    protected final List m17625u() {
        int i = 0;
        List arrayList = new ArrayList();
        if (m17604d()) {
            List k = m17615k();
            List list = (List) k.get(1);
            long longValue = ((Long) k.get(0)).longValue();
            C3505o.m17572a(list);
            arrayList.add(Long.valueOf(longValue));
            if (list != null && list.size() > 0) {
                while (i < list.size()) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (arrayList.size() - 1 >= 40) {
                        break;
                    }
                    if (scanResult != null) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(scanResult.BSSID.replace(":", ""));
                        arrayList2.add(Integer.valueOf(scanResult.level));
                        arrayList2.add(scanResult.SSID);
                        arrayList.add(arrayList2);
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    protected final void m17626v() {
        synchronized (this) {
            this.f13232z.clear();
        }
        if (this.f13231y != null) {
            m17582b(this.f13231y);
            this.f13231y = null;
        }
        if (this.f13205A != null) {
            this.f13205A.cancel();
            this.f13205A = null;
        }
        this.f13205A = new Timer();
        this.f13231y = new C3509s();
        m17569a(this.f13231y);
        m17556A();
    }

    protected final void m17627w() {
        synchronized (this) {
            this.f13232z.clear();
        }
        if (this.f13231y != null) {
            m17582b(this.f13231y);
            this.f13231y = null;
        }
        if (this.f13205A != null) {
            this.f13205A.cancel();
            this.f13205A = null;
        }
    }

    protected final byte m17628x() {
        ArrayList arrayList = new ArrayList();
        if (this.f13212e == null) {
            return (byte) 0;
        }
        List sensorList = this.f13212e.getSensorList(-1);
        return sensorList != null ? (byte) sensorList.size() : (byte) 0;
    }

    protected final Context m17629y() {
        return this.f13208a;
    }
}
