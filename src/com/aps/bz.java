package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.amap.api.location.LocationManagerProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

public class bz {
    private static float f13090P = 1.1f;
    private static float f13091Q = 2.2f;
    private static float f13092R = 2.3f;
    private static float f13093S = 3.8f;
    private static int f13094T = 3;
    private static int f13095U = 10;
    private static int f13096V = 2;
    private static int f13097W = 7;
    private static int f13098X = 20;
    private static int f13099Y = 70;
    private static int f13100Z = 120;
    protected static boolean f13101a = false;
    protected static boolean f13102b = true;
    private static int f13103c = 10;
    private static int f13104d = 2;
    private static int f13105e = 10;
    private static int f13106f = 10;
    private static int f13107g = 50;
    private static int f13108h = 200;
    private static Object f13109i = new Object();
    private static bz f13110j;
    private Thread f13111A = null;
    private Looper f13112B = null;
    private C3515y f13113C = null;
    private Location f13114D = null;
    private C3514x f13115E = null;
    private Handler f13116F = null;
    private C3516z f13117G = new C3516z(this);
    private LocationListener f13118H = new C3511u(this);
    private BroadcastReceiver f13119I = new C3512v(this);
    private GpsStatus f13120J = null;
    private int f13121K = 0;
    private int f13122L = 0;
    private HashMap f13123M = null;
    private int f13124N = 0;
    private int f13125O = 0;
    private boolean f13126k = false;
    private boolean f13127l = false;
    private int f13128m = -1;
    private int f13129n = 0;
    private int f13130o = 0;
    private int f13131p = 10000;
    private long f13132q = 0;
    private Context f13133r;
    private LocationManager f13134s;
    private C3505o f13135t;
    private ab f13136u;
    private an f13137v;
    private C3502l f13138w;
    private am f13139x;
    private aa f13140y;
    private C3496f f13141z;

    private bz(Context context) {
        this.f13133r = context;
        this.f13135t = C3505o.m17563a(context);
        this.f13141z = new C3496f();
        this.f13136u = new ab(this.f13135t);
        this.f13138w = new C3502l(context);
        this.f13137v = new an(this.f13138w);
        this.f13139x = new am(this.f13138w);
        this.f13134s = (LocationManager) this.f13133r.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        this.f13140y = aa.m17165a(this.f13133r);
        this.f13140y.m17172a(this.f13117G);
        m17513n();
        List allProviders = this.f13134s.getAllProviders();
        boolean z = allProviders != null && allProviders.contains("gps") && allProviders.contains("passive");
        this.f13127l = z;
        ao.m17283a(context);
    }

    static /* synthetic */ int m17472a(bz bzVar, bx bxVar, int i) {
        if (bzVar.f13124N >= f13095U) {
            return 1;
        }
        if (bzVar.f13124N <= f13094T) {
            return 4;
        }
        double c = bxVar.m17470c();
        if (c <= ((double) f13090P)) {
            return 1;
        }
        if (c >= ((double) f13091Q)) {
            return 4;
        }
        c = bxVar.m17469b();
        return c > ((double) f13092R) ? c >= ((double) f13093S) ? 4 : i < f13097W ? i <= f13096V ? 4 : bzVar.f13123M != null ? bzVar.m17473a(bzVar.f13123M) : 3 : 1 : 1;
    }

    private int m17473a(HashMap hashMap) {
        if (this.f13121K > 4) {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i2 = 0;
            for (Entry value : hashMap.entrySet()) {
                List list = (List) value.getValue();
                if (list != null) {
                    Object a = m17486a(list);
                    if (a != null) {
                        arrayList.add(a);
                        i = i2 + 1;
                        arrayList2.add(Integer.valueOf(i2));
                        i2 = i;
                    }
                }
                i = i2;
                i2 = i;
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    double[] dArr2 = (double[]) arrayList.get(i3);
                    i = ((Integer) arrayList2.get(i3)).intValue();
                    dArr2[0] = dArr2[0] * ((double) i);
                    dArr2[1] = dArr2[1] * ((double) i);
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr[1] + dArr2[1];
                }
                dArr[0] = dArr[0] / ((double) size);
                dArr[1] = dArr[1] / ((double) size);
                double d = dArr[0];
                double d2 = dArr[1];
                double toDegrees = d2 == 0.0d ? d > 0.0d ? 90.0d : d < 0.0d ? 270.0d : 0.0d : Math.toDegrees(Math.atan(d / d2));
                double[] dArr3 = new double[]{Math.sqrt((d * d) + (d2 * d2)), toDegrees};
                String.format(Locale.CHINA, "%d,%d,%d,%d", new Object[]{Long.valueOf(Math.round(dArr[0] * 100.0d)), Long.valueOf(Math.round(dArr[1] * 100.0d)), Long.valueOf(Math.round(dArr3[0] * 100.0d)), Long.valueOf(Math.round(dArr3[1] * 100.0d))});
                if (dArr3[0] <= ((double) f13099Y)) {
                    return 1;
                }
                if (dArr3[0] >= ((double) f13100Z)) {
                    return 4;
                }
            }
        }
        return 3;
    }

    public static bz m17479a(Context context) {
        if (f13110j == null) {
            synchronized (f13109i) {
                if (f13110j == null) {
                    f13110j = new bz(context);
                }
            }
        }
        return f13110j;
    }

    public static String m17481a(String str) {
        return str.equals("version") ? "COL.14.1126r" : null;
    }

    static /* synthetic */ void m17484a(bz bzVar, Location location, int i, long j) {
        boolean z;
        Location location2;
        C3495e a;
        Long valueOf;
        System.currentTimeMillis();
        boolean a2 = bzVar.f13136u.m17184a(location);
        if (a2) {
            bzVar.f13136u.f12850b.f12895b = new Location(location);
        }
        boolean b = bzVar.f13136u.m17185b(location);
        if (b) {
            bzVar.f13136u.f12849a.f12903b = new Location(location);
        }
        int i2 = 0;
        if (i == 1) {
            z = true;
            a2 = true;
            location2 = bzVar.f13114D;
        } else if (i == 2) {
            z = false;
            a2 = true;
            location2 = bzVar.f13114D;
        } else {
            z = a2;
            a2 = b;
            location2 = location;
        }
        if (z) {
            i2 = 1;
            if (a2) {
                i2 = 3;
            }
        } else if (a2) {
            i2 = 2;
        }
        try {
            C3496f c3496f = bzVar.f13141z;
            a = C3496f.m17528a(location2, bzVar.f13135t, i2, (byte) bzVar.f13125O, j, false);
        } catch (Exception e) {
            a = null;
        }
        if (!(a == null || bzVar.f13135t == null)) {
            List n = bzVar.f13135t.m17618n();
            valueOf = Long.valueOf(0);
            if (n != null && n.size() > 0) {
                valueOf = (Long) n.get(0);
            }
            bzVar.f13137v.m17281a(valueOf.longValue(), a.m17527a());
        }
        if (bzVar.f13133r != null && bzVar.f13141z != null) {
            SharedPreferences sharedPreferences = bzVar.f13133r.getSharedPreferences("app_pref", 0);
            if (!sharedPreferences.getString("get_sensor", "").equals("true")) {
                try {
                    C3496f c3496f2 = bzVar.f13141z;
                    a = C3496f.m17528a(null, bzVar.f13135t, i2, (byte) bzVar.f13125O, j, true);
                } catch (Exception e2) {
                    a = null;
                }
                if (a != null && bzVar.f13135t != null) {
                    List n2 = bzVar.f13135t.m17618n();
                    valueOf = Long.valueOf(0);
                    if (n2 != null && n2.size() > 0) {
                        valueOf = (Long) n2.get(0);
                    }
                    bzVar.f13137v.m17281a(valueOf.longValue(), a.m17527a());
                    sharedPreferences.edit().putString("get_sensor", "true").commit();
                }
            }
        }
    }

    private double[] m17486a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        for (GpsSatellite gpsSatellite : list) {
            if (gpsSatellite != null) {
                double elevation = (double) (90.0f - gpsSatellite.getElevation());
                double azimuth = (double) gpsSatellite.getAzimuth();
                double[] dArr2 = new double[]{Math.sin(Math.toRadians(azimuth)) * elevation, elevation * Math.cos(Math.toRadians(azimuth))};
                dArr[0] = dArr[0] + dArr2[0];
                dArr[1] = dArr[1] + dArr2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / ((double) size);
        dArr[1] = dArr[1] / ((double) size);
        return dArr;
    }

    static /* synthetic */ String m17490b(bz bzVar, String str) {
        return str;
    }

    private void m17513n() {
        this.f13129n = this.f13140y.m17175b() * 1000;
        this.f13130o = this.f13140y.m17177c();
        ab abVar = this.f13136u;
        int i = this.f13129n;
        i = this.f13130o;
        ab.m17181a();
    }

    public void m17516a() {
        al.f12904a = true;
        if (this.f13127l && this.f13135t != null && !f13101a) {
            IntentFilter intentFilter = new IntentFilter("android.location.GPS_ENABLED_CHANGE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            f13102b = true;
            this.f13133r.registerReceiver(this.f13119I, intentFilter);
            String str = "";
            this.f13134s.removeUpdates(this.f13118H);
            if (this.f13112B != null) {
                this.f13112B.quit();
                this.f13112B = null;
            }
            if (this.f13111A != null) {
                this.f13111A.interrupt();
                this.f13111A = null;
            }
            this.f13111A = new C3513w(this, str);
            this.f13111A.start();
            this.f13135t.m17597a();
            f13101a = true;
        }
    }

    public void m17517a(int i) {
        if (i == 256 || i == 8736 || i == 768) {
            this.f13138w.m17552a(i);
            return;
        }
        throw new RuntimeException("invalid Size! must be COLLECTOR_SMALL_SIZE or COLLECTOR_BIG_SIZE or COLLECTOR_MEDIUM_SIZE");
    }

    public void m17518a(C3501k c3501k, String str) {
        boolean a = this.f13140y.m17174a(str);
        if (c3501k != null) {
            byte[] a2 = c3501k.m17532a();
            if (a && a2 != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13133r.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        this.f13140y.m17171a(a2.length + this.f13140y.m17179e());
                    } else {
                        this.f13140y.m17176b(a2.length + this.f13140y.m17180f());
                    }
                }
            }
            c3501k.m17531a(a);
            this.f13139x.m17280a(c3501k);
        }
    }

    public void m17519b() {
        al.f12904a = false;
        if (this.f13127l && this.f13135t != null && f13101a) {
            if (this.f13119I != null) {
                try {
                    this.f13133r.unregisterReceiver(this.f13119I);
                } catch (Exception e) {
                }
            }
            if (this.f13135t != null) {
                this.f13135t.m17627w();
            }
            this.f13134s.removeGpsStatusListener(this.f13115E);
            this.f13134s.removeNmeaListener(this.f13115E);
            this.f13115E = null;
            this.f13134s.removeUpdates(this.f13118H);
            if (this.f13112B != null) {
                this.f13112B.quit();
                this.f13112B = null;
            }
            if (this.f13111A != null) {
                this.f13111A.interrupt();
                this.f13111A = null;
            }
            if (this.f13113C != null) {
                this.f13126k = false;
                this.f13113C.interrupt();
                this.f13113C = null;
            }
            this.f13135t.m17600b();
            f13101a = false;
        }
    }

    public void m17520c() {
        if (this.f13127l) {
            m17519b();
        }
    }

    public C3501k m17521d() {
        if (this.f13139x == null) {
            return null;
        }
        m17522e();
        return this.f13140y.m17173a() ? this.f13139x.m17279a(this.f13140y.m17178d()) : null;
    }

    public boolean m17522e() {
        if (this.f13135t == null) {
            return false;
        }
        List n = this.f13135t.m17618n();
        return (n == null || n.size() <= 0) ? false : this.f13138w.m17554b(((Long) n.get(0)).longValue());
    }

    public int m17523f() {
        return this.f13139x != null ? this.f13139x.m17278a() : 0;
    }
}
