package com.aps;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C3189a;
import com.amap.api.location.core.C3191c;
import com.amap.api.location.core.C3192d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: APS */
public class ac implements bg {
    private long f12852A = 0;
    private long f12853B = 0;
    private bh f12854C = bh.m17409a();
    private int f12855D = 0;
    private String f12856E = "00:00:00:00:00:00";
    private bz f12857F = null;
    private StringBuilder f12858G = new StringBuilder();
    private long f12859H = 0;
    private aq f12860I = null;
    private CellLocation f12861J = null;
    private boolean f12862K = false;
    at f12863a;
    int f12864b = -1;
    boolean f12865c = false;
    af f12866d = new af(this);
    TimerTask f12867e;
    Timer f12868f;
    C3501k f12869g;
    int f12870h = 0;
    private Context f12871i = null;
    private int f12872j = 9;
    private ConnectivityManager f12873k = null;
    private WifiManager f12874l = null;
    private TelephonyManager f12875m = null;
    private List<as> f12876n = new ArrayList();
    private List<ScanResult> f12877o = new ArrayList();
    private Map<PendingIntent, List<bf>> f12878p = new HashMap();
    private Map<PendingIntent, List<bf>> f12879q = new HashMap();
    private PhoneStateListener f12880r = null;
    private int f12881s = -113;
    private ag f12882t = new ag();
    private WifiInfo f12883u = null;
    private JSONObject f12884v = null;
    private ap f12885w = null;
    private long f12886x = 0;
    private boolean f12887y = false;
    private long f12888z = 0;

    public void mo4142a(Context context) {
        if (context != null && this.f12871i == null) {
            this.f12871i = context.getApplicationContext();
            try {
                if (this.f12863a == null) {
                    this.f12863a = new at(context);
                    this.f12863a.m17348a(this.f12866d);
                }
            } catch (Throwable th) {
            }
            try {
                if (this.f12860I == null) {
                    this.f12860I = new aq(context);
                }
            } catch (Throwable th2) {
            }
            bu.m17451a(this.f12871i, "in debug mode, only for test");
            m17229f();
            m17233h();
            this.f12859H = bu.m17460b();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.aps.ap mo4140a() throws java.lang.Exception {
        /*
        r10 = this;
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = 0;
        r1 = 1;
        r0 = r10.f12871i;
        if (r0 != 0) goto L_0x0011;
    L_0x0008:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "未知的错误";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r0 = com.aps.ax.f12974d;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0019:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key鉴权失败";
        r0.<init>(r1);
        throw r0;
    L_0x0021:
        r0 = com.aps.ax.f12975e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0031;
    L_0x0029:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key鉴权失败";
        r0.<init>(r1);
        throw r0;
    L_0x0031:
        r0 = r10.f12884v;
        r0 = com.aps.bh.m17415a(r0);
        r3 = "false";
        r0 = r0[r2];
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0050;
    L_0x0041:
        r0 = "AuthLocation";
        r1 = "key鉴权失败";
        android.util.Log.e(r0, r1);
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "key鉴权失败";
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r10.m17241l();
        if (r0 == 0) goto L_0x005f;
    L_0x0056:
        r10.m17231g();
        r4 = com.aps.bu.m17460b();
        r10.f12852A = r4;
    L_0x005f:
        r0 = r10.m17242m();
        if (r0 == 0) goto L_0x0068;
    L_0x0065:
        r10.m17245p();
    L_0x0068:
        r0 = r10.f12855D;
        r0 = r0 + 1;
        r10.f12855D = r0;
        r0 = r10.f12855D;
        if (r0 <= r1) goto L_0x0082;
    L_0x0072:
        r10.m17267c();
        r0 = r10.f12865c;
        if (r0 != 0) goto L_0x0082;
    L_0x0079:
        r0 = com.amap.api.location.core.C3189a.m14110b();
        if (r0 == 0) goto L_0x0082;
    L_0x007f:
        r10.m17196A();
    L_0x0082:
        r0 = r10.f12877o;
        if (r0 != 0) goto L_0x008d;
    L_0x0086:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.f12877o = r0;
    L_0x008d:
        r0 = r10.f12855D;
        if (r0 != r1) goto L_0x00b3;
    L_0x0091:
        r0 = r10.f12871i;
        r0 = com.aps.bu.m17455a(r0);
        r10.f12887y = r0;
        r0 = r10.m17249t();
        if (r0 == 0) goto L_0x00b3;
    L_0x009f:
        r0 = r10.f12877o;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x00b3;
    L_0x00a7:
        r0 = r10.f12874l;
        if (r0 == 0) goto L_0x00b3;
    L_0x00ab:
        r0 = r10.f12874l;
        r0 = r0.getScanResults();
        r10.f12877o = r0;
    L_0x00b3:
        r0 = r10.f12855D;
        if (r0 != r1) goto L_0x00d6;
    L_0x00b7:
        r0 = r10.m17249t();
        if (r0 == 0) goto L_0x00d6;
    L_0x00bd:
        r0 = r10.f12877o;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x00d6;
    L_0x00c5:
        r0 = 4;
    L_0x00c6:
        if (r0 <= 0) goto L_0x00d6;
    L_0x00c8:
        r3 = r10.f12877o;
        r3 = r3.size();
        if (r3 != 0) goto L_0x00d6;
    L_0x00d0:
        android.os.SystemClock.sleep(r6);
        r0 = r0 + -1;
        goto L_0x00c6;
    L_0x00d6:
        r4 = r10.f12886x;
        r0 = r10.m17207a(r4);
        if (r0 == 0) goto L_0x00eb;
    L_0x00de:
        r0 = r10.f12885w;
        if (r0 == 0) goto L_0x00eb;
    L_0x00e2:
        r0 = com.aps.bu.m17450a();
        r10.f12886x = r0;
        r0 = r10.f12885w;
    L_0x00ea:
        return r0;
    L_0x00eb:
        r0 = r10.f12861J;	 Catch:{ Throwable -> 0x0125 }
        r10.m17203a(r0);	 Catch:{ Throwable -> 0x0125 }
    L_0x00f0:
        r0 = r10.f12877o;
        r10.m17205a(r0);
        r3 = r10.m17236i();
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0133;
    L_0x00ff:
        r0 = com.amap.api.location.core.C3189a.m14110b();
        if (r0 == 0) goto L_0x012a;
    L_0x0105:
        r0 = r10.f12864b;
        if (r0 == 0) goto L_0x010c;
    L_0x0109:
        android.os.SystemClock.sleep(r6);
    L_0x010c:
        r0 = r10.f12864b;
        if (r0 != 0) goto L_0x012a;
    L_0x0110:
        r0 = r10.f12863a;
        r0 = r0.m17351d();
        r10.f12885w = r0;
        r10.m17247r();
        r10.m17268d();
        r0 = r10.f12885w;
        if (r0 == 0) goto L_0x012a;
    L_0x0122:
        r0 = r10.f12885w;
        goto L_0x00ea;
    L_0x0125:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00f0;
    L_0x012a:
        r0 = new com.amap.api.location.core.AMapLocException;
        r1 = "获取基站/WiFi信息为空或失败";
        r0.<init>(r1);
        throw r0;
    L_0x0133:
        r4 = r10.m17237j();
        r0 = 0;
        r5 = r10.f12860I;	 Catch:{ Throwable -> 0x0182 }
        r6 = "mem";
        r0 = r5.m17336a(r3, r4, r6);	 Catch:{ Throwable -> 0x0182 }
    L_0x0140:
        if (r0 == 0) goto L_0x0184;
    L_0x0142:
        r6 = r0.m17305h();
        r8 = com.aps.bu.m17450a();
        r6 = r8 - r6;
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 <= 0) goto L_0x0184;
    L_0x0153:
        if (r0 == 0) goto L_0x0157;
    L_0x0155:
        if (r1 == 0) goto L_0x017f;
    L_0x0157:
        r0 = r10.m17250u();	 Catch:{ AMapLocException -> 0x017b }
    L_0x015b:
        r10.f12885w = r0;
    L_0x015d:
        r0 = r10.f12860I;
        r1 = r10.f12885w;
        r0.m17338a(r3, r1, r4);
        r0 = r4.length();
        r4.delete(r2, r0);
        r0 = com.aps.bu.m17450a();
        r10.f12886x = r0;
        r10.m17247r();
        r10.m17268d();
        r0 = r10.f12885w;
        goto L_0x00ea;
    L_0x017b:
        r1 = move-exception;
        if (r0 != 0) goto L_0x015b;
    L_0x017e:
        throw r1;
    L_0x017f:
        r10.f12885w = r0;
        goto L_0x015d;
    L_0x0182:
        r5 = move-exception;
        goto L_0x0140;
    L_0x0184:
        r1 = r2;
        goto L_0x0153;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.ac.a():com.aps.ap");
    }

    public void mo4145a(String str) {
        if (str != null && str.indexOf("##") != -1) {
            String[] split = str.split("##");
            if (split.length == 3) {
                ax.m17352a(split[0]);
                if (!ax.f12975e.equals(split[1])) {
                    this.f12860I.m17337a();
                }
                ax.m17354b(split[1]);
                ax.m17355c(split[2]);
            }
        }
    }

    public void mo4146a(JSONObject jSONObject) {
        this.f12884v = jSONObject;
    }

    public void mo4144a(bf bfVar, PendingIntent pendingIntent) {
        if (pendingIntent != null && bfVar != null) {
            long a = bfVar.m17405a();
            if (a != -1 && a < bu.m17460b()) {
                return;
            }
            List list;
            if (this.f12878p.get(pendingIntent) != null) {
                list = (List) this.f12878p.get(pendingIntent);
                list.add(bfVar);
                this.f12878p.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(bfVar);
            this.f12878p.put(pendingIntent, list);
        }
    }

    public void mo4149b(bf bfVar, PendingIntent pendingIntent) {
        if (pendingIntent != null && bfVar != null) {
            long a = bfVar.m17405a();
            if (a != -1 && a < bu.m17460b()) {
                return;
            }
            List list;
            if (this.f12879q.get(pendingIntent) != null) {
                list = (List) this.f12879q.get(pendingIntent);
                list.add(bfVar);
                this.f12879q.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(bfVar);
            this.f12879q.put(pendingIntent, list);
        }
    }

    public void mo4141a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f12878p.remove(pendingIntent);
        }
    }

    public void mo4148b(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f12879q.remove(pendingIntent);
        }
    }

    public void mo4147b() {
        try {
            if (this.f12857F != null) {
                this.f12857F.m17520c();
                this.f12862K = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.f12871i != null) {
                this.f12871i.unregisterReceiver(this.f12882t);
            }
        } catch (Throwable th2) {
            this.f12882t = null;
        }
        this.f12882t = null;
        m17252w();
        try {
            if (!(this.f12875m == null || this.f12880r == null)) {
                this.f12875m.listen(this.f12880r, 0);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (!(this.f12871i == null || this.f12860I == null)) {
            this.f12860I.m17337a();
            this.f12860I.m17340b();
        }
        ax.m17353a(false);
        this.f12886x = 0;
        this.f12876n.clear();
        this.f12878p.clear();
        this.f12879q.clear();
        this.f12881s = -113;
        m17244o();
        this.f12885w = null;
        this.f12871i = null;
        this.f12875m = null;
        try {
            if (this.f12863a != null) {
                if (this.f12864b == 0 && this.f12865c) {
                    this.f12863a.m17347a();
                }
                this.f12864b = -1;
                this.f12865c = false;
                this.f12863a = null;
            }
        } catch (Throwable th4) {
        }
    }

    private void m17229f() {
        this.f12874l = (WifiManager) bu.m17462b(this.f12871i, "wifi");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f12871i.registerReceiver(this.f12882t, intentFilter);
        m17245p();
    }

    private void m17231g() {
        try {
            CellLocation.requestLocationUpdate();
        } catch (Throwable th) {
        }
    }

    private void m17233h() {
        int phoneType;
        this.f12873k = (ConnectivityManager) bu.m17462b(this.f12871i, "connectivity");
        m17231g();
        this.f12852A = bu.m17460b();
        this.f12875m = (TelephonyManager) bu.m17462b(this.f12871i, "phone");
        if (this.f12875m != null) {
            phoneType = this.f12875m.getPhoneType();
        } else {
            phoneType = 9;
        }
        switch (phoneType) {
            case 1:
                this.f12872j = 1;
                break;
            case 2:
                this.f12872j = 2;
                break;
            default:
                this.f12872j = 9;
                break;
        }
        this.f12880r = new ad(this);
        if (bu.m17463c() < 7) {
            phoneType = 2;
        } else {
            phoneType = 256;
        }
        if (phoneType != 0) {
            try {
                if (this.f12875m != null) {
                    this.f12875m.listen(this.f12880r, phoneType | 16);
                }
            } catch (Throwable e) {
                bu.m17452a(e);
            }
        } else if (this.f12875m != null) {
            this.f12875m.listen(this.f12880r, 16);
        }
    }

    private void m17203a(CellLocation cellLocation) {
        CellLocation cellLocation2 = null;
        if (!(this.f12887y || this.f12875m == null || this.f12875m == null)) {
            cellLocation2 = m17255z();
        }
        if (cellLocation2 != null) {
            cellLocation = cellLocation2;
        }
        if (cellLocation != null) {
            switch (bu.m17449a(cellLocation, this.f12871i)) {
                case 1:
                    if (this.f12875m != null) {
                        m17222c(cellLocation);
                        return;
                    }
                    return;
                case 2:
                    m17226d(cellLocation);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean m17207a(long j) {
        long a = bu.m17450a();
        if (a - j >= 300) {
            return false;
        }
        long j2 = 0;
        if (this.f12885w != null) {
            j2 = a - this.f12885w.m17305h();
        }
        if (j2 > 10000) {
            return false;
        }
        return true;
    }

    private String m17236i() {
        m17251v();
        String str = "";
        String str2 = "";
        str2 = LocationManagerProxy.NETWORK_PROVIDER;
        if (m17249t()) {
            this.f12883u = this.f12874l.getConnectionInfo();
        } else {
            m17244o();
        }
        String str3 = "";
        as asVar;
        StringBuilder stringBuilder;
        switch (this.f12872j) {
            case 1:
                if (this.f12876n.size() > 0) {
                    asVar = (as) this.f12876n.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(asVar.f12945a).append("#");
                    stringBuilder.append(asVar.f12946b).append("#");
                    stringBuilder.append(asVar.f12947c).append("#");
                    stringBuilder.append(asVar.f12948d).append("#");
                    stringBuilder.append(str2).append("#");
                    if (this.f12877o.size() > 0) {
                        str = "cellwifi";
                    } else {
                        str = "cell";
                    }
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
                break;
            case 2:
                if (this.f12876n.size() > 0) {
                    asVar = (as) this.f12876n.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(asVar.f12945a).append("#");
                    stringBuilder.append(asVar.f12946b).append("#");
                    stringBuilder.append(asVar.f12951g).append("#");
                    stringBuilder.append(asVar.f12952h).append("#");
                    stringBuilder.append(asVar.f12953i).append("#");
                    stringBuilder.append(str2).append("#");
                    if (this.f12877o.size() > 0) {
                        str = "cellwifi";
                    } else {
                        str = "cell";
                    }
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
                break;
            case 9:
                str2 = String.format("#%s#", new Object[]{str2});
                if ((this.f12877o.size() == 1 && !m17209a(this.f12883u)) || this.f12877o.size() == 0) {
                    return null;
                }
                if (this.f12877o.size() != 1 || !m17209a(this.f12883u)) {
                    return str2 + "wifi";
                }
                ScanResult scanResult = (ScanResult) this.f12877o.get(0);
                if (scanResult == null || !this.f12883u.getBSSID().equals(scanResult.BSSID)) {
                    str = str2;
                } else {
                    str = null;
                }
                return str;
        }
        return str;
    }

    private boolean m17209a(WifiInfo wifiInfo) {
        if (wifiInfo == null || wifiInfo.getBSSID() == null || wifiInfo.getSSID() == null || wifiInfo.getBSSID().equals("00:00:00:00:00:00") || TextUtils.isEmpty(wifiInfo.getSSID())) {
            return false;
        }
        return true;
    }

    private boolean m17208a(ScanResult scanResult) {
        boolean z = false;
        if (scanResult != null) {
            try {
                if (!(TextUtils.isEmpty(scanResult.BSSID) || scanResult.BSSID.equals("00:00:00:00:00:00"))) {
                    z = true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return z;
    }

    private StringBuilder m17237j() {
        m17251v();
        StringBuilder stringBuilder = new StringBuilder(700);
        switch (this.f12872j) {
            case 1:
                for (int i = 0; i < this.f12876n.size(); i++) {
                    if (i != 0) {
                        as asVar = (as) this.f12876n.get(i);
                        stringBuilder.append("#").append(asVar.f12946b);
                        stringBuilder.append("|").append(asVar.f12947c);
                        stringBuilder.append("|").append(asVar.f12948d);
                    }
                }
                break;
        }
        if (this.f12856E == null || this.f12856E.equals("00:00:00:00:00:00")) {
            if (this.f12883u != null) {
                this.f12856E = this.f12883u.getMacAddress();
                if (this.f12856E == null) {
                    this.f12856E = "00:00:00:00:00:00";
                }
            } else if (this.f12874l != null) {
                this.f12883u = this.f12874l.getConnectionInfo();
                if (this.f12883u != null) {
                    this.f12856E = this.f12883u.getMacAddress();
                    if (this.f12856E == null) {
                        this.f12856E = "00:00:00:00:00:00";
                    }
                    this.f12883u = null;
                }
            }
        }
        if (m17249t()) {
            String bssid;
            String str = "";
            if (m17209a(this.f12883u)) {
                bssid = this.f12883u.getBSSID();
            } else {
                bssid = str;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f12877o.size(); i3++) {
                ScanResult scanResult = (ScanResult) this.f12877o.get(i3);
                if (m17208a(scanResult)) {
                    String str2 = scanResult.BSSID;
                    str = "nb";
                    if (bssid.equals(str2)) {
                        str = "access";
                        i2 = 1;
                    }
                    stringBuilder.append(String.format("#%s,%s", new Object[]{str2, str}));
                }
            }
            if (i2 == 0 && bssid.length() > 0) {
                stringBuilder.append("#").append(bssid);
                stringBuilder.append(",access");
            }
        } else {
            m17244o();
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder;
    }

    private synchronized byte[] m17212a(Object obj) {
        bm bmVar;
        String str;
        StringBuilder stringBuilder;
        bmVar = new bm();
        String str2 = "0";
        String str3 = "0";
        String str4 = "0";
        String str5 = "0";
        String str6 = "0";
        String str7 = "";
        ax.f12973c = "";
        String str8 = "";
        str7 = "";
        String str9 = "";
        String str10 = "V1.3.3";
        String a = bz.m17481a("version");
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        if (this.f12872j == 2) {
            str = "1";
        } else {
            str = str2;
        }
        if (this.f12875m != null) {
            if (ax.f12971a == null || "888888888888888".equals(ax.f12971a)) {
                try {
                    ax.f12971a = this.f12875m.getDeviceId();
                    if (ax.f12971a == null) {
                        ax.f12971a = "888888888888888";
                    }
                } catch (SecurityException e) {
                }
            }
            if (ax.f12972b == null || "888888888888888".equals(ax.f12972b)) {
                try {
                    ax.f12972b = this.f12875m.getSubscriberId();
                    if (ax.f12972b == null) {
                        ax.f12972b = "888888888888888";
                    }
                } catch (SecurityException e2) {
                }
            }
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = this.f12873k.getActiveNetworkInfo();
        } catch (SecurityException e3) {
        }
        if (bh.m17408a(networkInfo) != -1) {
            str8 = bh.m17410a(this.f12875m);
            if (m17249t()) {
                if (m17209a(this.f12883u)) {
                    str7 = "2";
                }
            }
            str7 = "1";
            if (!m17249t()) {
                m17244o();
            }
        } else {
            this.f12883u = null;
        }
        str2 = bh.m17415a(this.f12884v)[1];
        bmVar.f13039i = str;
        bmVar.f13040j = str3;
        bmVar.f13041k = str4;
        bmVar.f13042l = str5;
        bmVar.f13043m = str6;
        bmVar.f13033c = ax.f12974d;
        bmVar.f13034d = ax.f12975e;
        bmVar.f13044n = str2;
        bmVar.f13045o = ax.f12971a;
        bmVar.f13048r = ax.f12973c;
        bmVar.f13046p = ax.f12972b;
        bmVar.f13047q = this.f12856E;
        bmVar.f13049s = str8;
        bmVar.f13050t = str7;
        bmVar.f13036f = C3191c.m14128e();
        bmVar.f13037g = "android" + C3191c.m14126d();
        bmVar.f13038h = C3191c.m14129g() + "," + C3191c.m14130h();
        bmVar.f13027B = str10;
        bmVar.f13028C = a;
        try {
            if (this.f12877o != null && this.f12877o.size() > 0) {
                bmVar.f13030E = (bu.m17460b() - this.f12853B) + "";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f12876n.size() > 0) {
            StringBuilder stringBuilder5 = new StringBuilder();
            as asVar;
            switch (this.f12872j) {
                case 1:
                    asVar = (as) this.f12876n.get(0);
                    stringBuilder5.delete(0, stringBuilder5.length());
                    stringBuilder5.append("<mcc>").append(asVar.f12945a).append("</mcc>");
                    stringBuilder5.append("<mnc>").append(asVar.f12946b).append("</mnc>");
                    stringBuilder5.append("<lac>").append(asVar.f12947c).append("</lac>");
                    stringBuilder5.append("<cellid>").append(asVar.f12948d);
                    stringBuilder5.append("</cellid>");
                    stringBuilder5.append("<signal>").append(asVar.f12954j);
                    stringBuilder5.append("</signal>");
                    str9 = stringBuilder5.toString();
                    for (int i = 0; i < this.f12876n.size(); i++) {
                        if (i != 0) {
                            asVar = (as) this.f12876n.get(i);
                            stringBuilder2.append(asVar.f12947c).append(",");
                            stringBuilder2.append(asVar.f12948d).append(",");
                            stringBuilder2.append(asVar.f12954j);
                            if (i != this.f12876n.size() - 1) {
                                stringBuilder2.append("*");
                            }
                        }
                    }
                    str7 = str9;
                    break;
                case 2:
                    asVar = (as) this.f12876n.get(0);
                    stringBuilder5.delete(0, stringBuilder5.length());
                    stringBuilder5.append("<mcc>").append(asVar.f12945a).append("</mcc>");
                    stringBuilder5.append("<sid>").append(asVar.f12951g).append("</sid>");
                    stringBuilder5.append("<nid>").append(asVar.f12952h).append("</nid>");
                    stringBuilder5.append("<bid>").append(asVar.f12953i).append("</bid>");
                    if (asVar.f12950f > 0 && asVar.f12949e > 0) {
                        stringBuilder5.append("<lon>").append(asVar.f12950f).append("</lon>");
                        stringBuilder5.append("<lat>").append(asVar.f12949e).append("</lat>");
                    }
                    stringBuilder5.append("<signal>").append(asVar.f12954j).append("</signal>");
                    str7 = stringBuilder5.toString();
                    break;
                default:
                    str7 = str9;
                    break;
            }
            stringBuilder5.delete(0, stringBuilder5.length());
            str8 = str7;
        } else {
            str8 = str9;
        }
        if (m17249t()) {
            if (m17209a(this.f12883u)) {
                stringBuilder4.append(this.f12883u.getBSSID()).append(",");
                stringBuilder4.append(this.f12883u.getRssi()).append(",");
                stringBuilder4.append(this.f12883u.getSSID().replace("*", "."));
            }
            for (int i2 = 0; i2 < this.f12877o.size(); i2++) {
                ScanResult scanResult = (ScanResult) this.f12877o.get(i2);
                if (m17208a(scanResult)) {
                    stringBuilder3.append(scanResult.BSSID).append(",");
                    stringBuilder3.append(scanResult.level).append(",");
                    stringBuilder3.append(i2).append("*");
                }
            }
        } else {
            m17244o();
        }
        if (stringBuilder3.length() > 0) {
            stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
        }
        if (stringBuilder3.length() == 0) {
            stringBuilder = stringBuilder4;
        } else {
            stringBuilder = stringBuilder3;
        }
        bmVar.f13052v = str8;
        bmVar.f13053w = stringBuilder2.toString();
        bmVar.f13054x = stringBuilder4.toString();
        bmVar.f13055y = stringBuilder.toString();
        bmVar.f13051u = String.valueOf(this.f12872j);
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder4.delete(0, stringBuilder4.length());
        return bmVar.m17427a();
    }

    private synchronized void m17205a(List<ScanResult> list) {
        if (list != null) {
            if (list.size() >= 1) {
                Object hashMap = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (list.size() <= 20 || m17206a(scanResult.level)) {
                        if (scanResult.SSID != null) {
                            scanResult.SSID = scanResult.SSID.replace("*", ".");
                        } else {
                            scanResult.SSID = "null";
                        }
                        hashMap.put(Integer.valueOf((scanResult.level * 30) + i), scanResult);
                    }
                }
                TreeMap treeMap = new TreeMap(Collections.reverseOrder());
                treeMap.putAll(hashMap);
                list.clear();
                for (Entry value : treeMap.entrySet()) {
                    list.add(value.getValue());
                    if (list.size() > 29) {
                        break;
                    }
                }
                hashMap.clear();
                treeMap.clear();
            }
        }
    }

    private boolean m17206a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (Throwable e) {
            bu.m17452a(e);
        }
        if (i2 >= 1) {
            return true;
        }
        return false;
    }

    private synchronized byte[] m17240k() {
        if (m17241l()) {
            m17231g();
            this.f12852A = bu.m17460b();
        }
        if (m17242m()) {
            m17245p();
        }
        return m17212a(null);
    }

    private boolean m17241l() {
        if (this.f12887y || this.f12852A == 0 || bu.m17460b() - this.f12852A < ax.f12980j) {
            return false;
        }
        return true;
    }

    private boolean m17242m() {
        if (m17249t() && this.f12853B != 0 && bu.m17460b() - this.f12853B >= ax.f12979i) {
            return true;
        }
        return false;
    }

    private boolean m17243n() {
        if (this.f12874l == null || !m17249t()) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            if (this.f12873k != null) {
                networkInfo = this.f12873k.getActiveNetworkInfo();
            }
            if (bh.m17408a(networkInfo) == -1 || !m17209a(this.f12874l.getConnectionInfo())) {
                return false;
            }
            return true;
        } catch (SecurityException e) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private ap m17199a(byte[] bArr, boolean z) throws Exception {
        if (this.f12871i == null) {
            return null;
        }
        bi biVar = new bi();
        bu.m17460b();
        String a = this.f12854C.m17419a(bArr, this.f12871i, this.f12884v);
        bu.m17460b();
        try {
            C3192d.m14143a(a);
        } catch (AMapLocException e) {
            throw e;
        } catch (Exception e2) {
        }
        String str = "";
        ap a2 = biVar.m17420a(a);
        if (bu.m17456a(a2)) {
            return a2.m17327t() != null ? a2 : a2;
        } else {
            throw new AMapLocException("未知的错误");
        }
    }

    private void m17218b(int i) {
        if (i == -113) {
            this.f12881s = -113;
            return;
        }
        this.f12881s = i;
        switch (this.f12872j) {
            case 1:
            case 2:
                if (this.f12876n.size() > 0) {
                    ((as) this.f12876n.get(0)).f12954j = this.f12881s;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private as m17217b(CellLocation cellLocation) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        as asVar = new as();
        String[] a = bu.m17459a(this.f12875m);
        asVar.f12945a = a[0];
        asVar.f12946b = a[1];
        asVar.f12947c = gsmCellLocation.getLac();
        asVar.f12948d = gsmCellLocation.getCid();
        asVar.f12954j = this.f12881s;
        return asVar;
    }

    private as m17200a(NeighboringCellInfo neighboringCellInfo) {
        if (bu.m17463c() < 5) {
            return null;
        }
        try {
            as asVar = new as();
            String[] a = bu.m17459a(this.f12875m);
            asVar.f12945a = a[0];
            asVar.f12946b = a[1];
            asVar.f12947c = neighboringCellInfo.getLac();
            asVar.f12948d = neighboringCellInfo.getCid();
            asVar.f12954j = bu.m17448a(neighboringCellInfo.getRssi());
            return asVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void m17222c(CellLocation cellLocation) {
        if (this.f12876n != null && cellLocation != null && this.f12875m != null) {
            int i;
            this.f12876n.clear();
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getLac() == -1) {
                i = 0;
            } else if (gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == SupportMenu.USER_MASK || gsmCellLocation.getCid() >= 268435455) {
                i = 0;
            } else if (gsmCellLocation.getLac() == 0) {
                i = 0;
            } else if (gsmCellLocation.getLac() > SupportMenu.USER_MASK) {
                i = 0;
            } else if (gsmCellLocation.getCid() == 0) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                this.f12872j = 9;
                bu.m17454a("case 2,gsm illegal");
                return;
            }
            this.f12872j = 1;
            List list = null;
            this.f12876n.add(m17217b(cellLocation));
            if (this.f12875m != null) {
                list = this.f12875m.getNeighboringCellInfo();
            }
            if (r0 != null) {
                for (NeighboringCellInfo neighboringCellInfo : r0) {
                    if (neighboringCellInfo.getCid() != -1) {
                        int i2;
                        if (neighboringCellInfo.getLac() == -1) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getLac() == 0) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getLac() > SupportMenu.USER_MASK) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getCid() == -1) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getCid() == 0) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getCid() == SupportMenu.USER_MASK) {
                            i2 = 0;
                        } else if (neighboringCellInfo.getCid() >= 268435455) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            as a = m17200a(neighboringCellInfo);
                            if (a != null) {
                                this.f12876n.add(a);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m17226d(CellLocation cellLocation) {
        this.f12876n.clear();
        if (bu.m17463c() >= 5) {
            try {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                if (cdmaCellLocation.getSystemId() <= 0) {
                    this.f12872j = 9;
                    bu.m17454a("cdma illegal");
                } else if (cdmaCellLocation.getNetworkId() < 0) {
                    this.f12872j = 9;
                    bu.m17454a("cdma illegal");
                } else if (cdmaCellLocation.getBaseStationId() < 0) {
                    this.f12872j = 9;
                    bu.m17454a("cdma illegal");
                } else {
                    this.f12872j = 2;
                    String[] a = bu.m17459a(this.f12875m);
                    as asVar = new as();
                    asVar.f12945a = a[0];
                    asVar.f12946b = a[1];
                    asVar.f12951g = cdmaCellLocation.getSystemId();
                    asVar.f12952h = cdmaCellLocation.getNetworkId();
                    asVar.f12953i = cdmaCellLocation.getBaseStationId();
                    asVar.f12954j = this.f12881s;
                    asVar.f12949e = cdmaCellLocation.getBaseStationLatitude();
                    asVar.f12950f = cdmaCellLocation.getBaseStationLongitude();
                    this.f12876n.add(asVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void m17244o() {
        this.f12877o.clear();
        this.f12883u = null;
    }

    private void m17245p() {
        if (m17249t()) {
            try {
                this.f12874l.startScan();
                this.f12853B = bu.m17460b();
            } catch (SecurityException e) {
            }
        }
    }

    private boolean m17246q() {
        if (this.f12888z != 0 && bu.m17460b() - this.f12888z < 2000) {
            return true;
        }
        return false;
    }

    public void m17267c() {
        try {
            if (this.f12857F == null) {
                this.f12857F = bz.m17479a(this.f12871i);
                this.f12857F.m17517a(256);
            }
            if (!this.f12862K) {
                this.f12862K = true;
                this.f12857F.m17516a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m17247r() {
        if (this.f12885w != null && this.f12878p.size() >= 1) {
            Iterator it = this.f12878p.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<bf> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (bf bfVar : list) {
                    long a = bfVar.m17405a();
                    if (a == -1 || a >= bu.m17460b()) {
                        float a2 = bu.m17447a(new double[]{bfVar.f13019b, bfVar.f13018a, this.f12885w.m17301f(), this.f12885w.m17299e()});
                        if (a2 < bfVar.f13020c) {
                            bundle.putFloat("distance", a2);
                            bundle.putString("fence", bfVar.m17407b());
                            intent.putExtras(bundle);
                            try {
                                pendingIntent.send(this.f12871i, 0, intent);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void m17268d() {
        if (this.f12885w != null && this.f12879q.size() >= 1) {
            Iterator it = this.f12879q.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<bf> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (bf bfVar : list) {
                    long a = bfVar.m17405a();
                    if (a == -1 || a >= bu.m17460b()) {
                        float a2 = bu.m17447a(new double[]{bfVar.f13019b, bfVar.f13018a, this.f12885w.m17301f(), this.f12885w.m17299e()});
                        if (a2 >= bfVar.f13020c) {
                            if (bfVar.f13021d != 0) {
                                bfVar.f13021d = 0;
                            }
                        }
                        if (a2 < bfVar.f13020c) {
                            if (bfVar.f13021d != 1) {
                                bfVar.f13021d = 1;
                            }
                        }
                        bundle.putFloat("distance", a2);
                        bundle.putString("fence", bfVar.m17407b());
                        bundle.putInt("status", bfVar.f13021d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(this.f12871i, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void mo4143a(Context context, AMapLocation aMapLocation) {
        if (aMapLocation != null && this.f12879q.size() >= 1) {
            Iterator it = this.f12879q.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<bf> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (bf bfVar : list) {
                    long a = bfVar.m17405a();
                    if (a == -1 || a >= bu.m17460b()) {
                        float a2 = bu.m17447a(new double[]{bfVar.f13019b, bfVar.f13018a, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                        if (a2 >= bfVar.f13020c) {
                            if (bfVar.f13021d != 0) {
                                bfVar.f13021d = 0;
                            }
                        }
                        if (a2 < bfVar.f13020c) {
                            if (bfVar.f13021d != 1) {
                                bfVar.f13021d = 1;
                            }
                        }
                        bundle.putFloat("distance", a2);
                        bundle.putString("fence", bfVar.m17407b());
                        bundle.putInt("status", bfVar.f13021d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(context, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void m17248s() {
        switch (this.f12872j) {
            case 1:
                if (this.f12876n.size() == 0) {
                    this.f12872j = 9;
                    return;
                }
                return;
            case 2:
                if (this.f12876n.size() == 0) {
                    this.f12872j = 9;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean m17249t() {
        boolean z = false;
        if (this.f12874l != null) {
            try {
                z = this.f12874l.isWifiEnabled();
            } catch (Exception e) {
            }
            if (!z && bu.m17463c() > 17) {
                try {
                    z = String.valueOf(bl.m17421a(this.f12874l, "isScanAlwaysAvailable", new Object[0])).equals("true");
                } catch (Exception e2) {
                }
            }
        }
        return z;
    }

    private ap m17250u() throws Exception {
        return m17199a(m17240k(), false);
    }

    private void m17251v() {
        if (this.f12887y) {
            this.f12872j = 9;
            this.f12876n.clear();
            return;
        }
        m17248s();
    }

    public int m17256a(boolean z, int i) {
        if (z) {
            m17221c(i);
        } else {
            m17252w();
        }
        return m17269e() ? this.f12857F.m17523f() : -1;
    }

    private void m17221c(int i) {
        try {
            if (bu.m17460b() - this.f12859H < 45000 || !m17269e()) {
                return;
            }
            if (!m17269e() || this.f12857F.m17523f() >= 20) {
                m17254y();
                if (this.f12867e == null) {
                    this.f12867e = new ae(this, i);
                }
                if (this.f12868f == null) {
                    this.f12868f = new Timer(false);
                    this.f12868f.schedule(this.f12867e, 3000, 3000);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m17252w() {
        if (this.f12868f != null) {
            this.f12868f.cancel();
            this.f12868f = null;
        }
        if (this.f12867e != null) {
            this.f12867e.cancel();
            this.f12867e = null;
        }
    }

    private void m17253x() {
        if (m17269e()) {
            try {
                this.f12857F.m17517a(768);
            } catch (Throwable th) {
                th.printStackTrace();
                bu.m17452a(th);
            }
        }
    }

    private void m17225d(int i) {
        int i2 = 70254591;
        if (m17269e()) {
            try {
                m17253x();
                switch (i) {
                    case 1:
                        i2 = 674234367;
                        break;
                    case 2:
                        if (!m17243n()) {
                            i2 = 674234367;
                            break;
                        } else {
                            i2 = 2083520511;
                            break;
                        }
                }
                this.f12857F.m17518a(null, m17201a(1, i2, 1));
                this.f12869g = this.f12857F.m17521d();
                if (this.f12869g != null) {
                    Object a = this.f12854C.m17418a(this.f12869g.m17532a(), this.f12871i);
                    if (m17269e()) {
                        if (TextUtils.isEmpty(a) || !a.equals("true")) {
                            this.f12870h++;
                            this.f12857F.m17518a(this.f12869g, m17201a(1, i2, 0));
                        } else {
                            this.f12857F.m17518a(this.f12869g, m17201a(1, i2, 1));
                        }
                    }
                }
                m17254y();
                if (m17269e() && this.f12857F.m17523f() == 0) {
                    m17252w();
                } else if (this.f12870h >= 3) {
                    m17252w();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    boolean m17269e() {
        if (this.f12857F == null) {
            return false;
        }
        return true;
    }

    private void m17254y() {
        if (m17269e() && this.f12857F.m17523f() <= 0) {
            try {
                if (!this.f12857F.m17522e()) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private String m17201a(int i, int i2, int i3) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("e", i);
        jSONObject.put("d", i2);
        jSONObject.put("u", i3);
        return jSONObject.toString();
    }

    private CellLocation m17255z() {
        CellLocation cellLocation = null;
        if (this.f12875m == null) {
            return cellLocation;
        }
        CellLocation cellLocation2;
        try {
            cellLocation2 = this.f12875m.getCellLocation();
        } catch (Exception e) {
            cellLocation2 = cellLocation;
        }
        if (m17228e(cellLocation2)) {
            return cellLocation2;
        }
        try {
            cellLocation2 = m17216b((List) bl.m17421a(this.f12875m, "getAllCellInfo", new Object[0]));
        } catch (NoSuchMethodException e2) {
        } catch (Exception e3) {
        }
        return m17228e(cellLocation2) ? cellLocation2 : cellLocation2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m17228e(android.telephony.CellLocation r6) {
        /*
        r5 = this;
        r4 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r3 = -1;
        r0 = 0;
        if (r6 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = 1;
        r2 = r5.f12871i;
        r2 = com.aps.bu.m17449a(r6, r2);
        switch(r2) {
            case 1: goto L_0x0016;
            case 2: goto L_0x0046;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r1;
    L_0x0013:
        if (r0 != 0) goto L_0x0007;
    L_0x0015:
        goto L_0x0007;
    L_0x0016:
        r6 = (android.telephony.gsm.GsmCellLocation) r6;
        r2 = r6.getLac();
        if (r2 == r3) goto L_0x0013;
    L_0x001e:
        r2 = r6.getLac();
        if (r2 == 0) goto L_0x0013;
    L_0x0024:
        r2 = r6.getLac();
        if (r2 > r4) goto L_0x0013;
    L_0x002a:
        r2 = r6.getCid();
        if (r2 == r3) goto L_0x0013;
    L_0x0030:
        r2 = r6.getCid();
        if (r2 == 0) goto L_0x0013;
    L_0x0036:
        r2 = r6.getCid();
        if (r2 == r4) goto L_0x0013;
    L_0x003c:
        r2 = r6.getCid();
        r3 = 268435455; // 0xfffffff float:2.5243547E-29 double:1.326247364E-315;
        if (r2 < r3) goto L_0x0012;
    L_0x0045:
        goto L_0x0013;
    L_0x0046:
        r2 = "getSystemId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0068 }
        r2 = com.aps.bl.m17422b(r6, r2, r3);	 Catch:{ Exception -> 0x0068 }
        if (r2 <= 0) goto L_0x0013;
    L_0x0051:
        r2 = "getNetworkId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0068 }
        r2 = com.aps.bl.m17422b(r6, r2, r3);	 Catch:{ Exception -> 0x0068 }
        if (r2 < 0) goto L_0x0013;
    L_0x005c:
        r2 = "getBaseStationId";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0068 }
        r2 = com.aps.bl.m17422b(r6, r2, r3);	 Catch:{ Exception -> 0x0068 }
        if (r2 >= 0) goto L_0x0012;
    L_0x0067:
        goto L_0x0013;
    L_0x0068:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.ac.e(android.telephony.CellLocation):boolean");
    }

    private CellLocation m17216b(List<?> list) {
        CellLocation cdmaCellLocation;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        CellLocation cellLocation = null;
        int i2 = 0;
        CellLocation cellLocation2 = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj != null) {
                try {
                    Class loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    if (loadClass.isInstance(obj)) {
                        i = 1;
                    } else if (loadClass2.isInstance(obj)) {
                        i = 2;
                    } else if (loadClass3.isInstance(obj)) {
                        i = 3;
                    } else if (loadClass4.isInstance(obj)) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    if (i > 0) {
                        Object obj2 = null;
                        if (i == 1) {
                            try {
                                obj2 = loadClass.cast(obj);
                            } catch (Exception e) {
                                i2 = i;
                            }
                        } else if (i == 2) {
                            obj2 = loadClass2.cast(obj);
                        } else if (i == 3) {
                            obj2 = loadClass3.cast(obj);
                        } else if (i == 4) {
                            obj2 = loadClass4.cast(obj);
                        }
                        obj = bl.m17421a(obj2, "getCellIdentity", new Object[0]);
                        if (obj == null) {
                            i2 = i;
                        } else if (i == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                int b = bl.m17422b(obj, "getSystemId", new Object[0]);
                                int b2 = bl.m17422b(obj, "getNetworkId", new Object[0]);
                                cdmaCellLocation.setCellLocationData(bl.m17422b(obj, "getBasestationId", new Object[0]), bl.m17422b(obj, "getLatitude", new Object[0]), bl.m17422b(obj, "getLongitude", new Object[0]), b, b2);
                                cellLocation2 = cellLocation;
                                break;
                            } catch (Exception e2) {
                                cellLocation2 = cdmaCellLocation;
                                i2 = i;
                            }
                        } else if (i == 3) {
                            r3 = bl.m17422b(obj, "getTac", new Object[0]);
                            r2 = bl.m17422b(obj, "getCi", new Object[0]);
                            cdmaCellLocation = new GsmCellLocation();
                            try {
                                cdmaCellLocation.setLacAndCid(r3, r2);
                                r12 = cellLocation2;
                                cellLocation2 = cdmaCellLocation;
                                cdmaCellLocation = r12;
                                break;
                            } catch (Exception e3) {
                                cellLocation = cdmaCellLocation;
                                i2 = i;
                            }
                        } else {
                            r3 = bl.m17422b(obj, "getLac", new Object[0]);
                            r2 = bl.m17422b(obj, "getCid", new Object[0]);
                            cdmaCellLocation = new GsmCellLocation();
                            try {
                                cdmaCellLocation.setLacAndCid(r3, r2);
                                r12 = cellLocation2;
                                cellLocation2 = cdmaCellLocation;
                                cdmaCellLocation = r12;
                                break;
                            } catch (Exception e4) {
                                cellLocation = cdmaCellLocation;
                                i2 = i;
                            }
                        }
                    } else {
                        i2 = i;
                    }
                } catch (Exception e5) {
                }
            }
        }
        i = i2;
        cdmaCellLocation = cellLocation2;
        cellLocation2 = cellLocation;
        if (i != 4) {
            return cellLocation2;
        }
        return cdmaCellLocation;
    }

    private void m17196A() {
        try {
            if (!this.f12865c && C3189a.m14110b() && this.f12863a != null) {
                this.f12863a.m17349b();
                this.f12865c = true;
            }
        } catch (Throwable th) {
            this.f12865c = true;
        }
    }
}
