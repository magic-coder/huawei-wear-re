package com.tencent.map.p535b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: ProGuard */
public final class C6327t {
    private static int f22037a;
    private static int f22038b;
    private static int f22039c;
    private static int f22040d;
    private static int f22041e;
    private static int f22042f;
    private static ArrayList<C6328u> f22043g;
    private static long f22044h;
    private static long f22045i;
    private static long f22046j;
    private static long f22047k;
    private static long f22048l;
    private static long f22049m;
    private static long f22050n;
    private static long f22051o;
    private static long f22052p;
    private static long f22053q;
    private static int f22054r;
    private static int f22055s;
    private static int f22056t;
    private static int f22057u;

    static {
        f22037a = 10000;
        f22038b = 15000;
        f22039c = 5000;
        f22040d = 20000;
        f22041e = 25000;
        f22042f = 15000;
        f22037a = UtilLoggingLevel.FINER_INT;
        f22038b = 20000;
        f22039c = 8000;
        f22040d = 20000;
        f22041e = 25000;
        f22042f = 15000;
        ConnectivityManager connectivityManager = (ConnectivityManager) C6329v.m29015b().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (activeNetworkInfo.isConnected() && type == 0) {
                    String subscriberId = ((TelephonyManager) C6329v.m29015b().getSystemService("phone")).getSubscriberId();
                    if (subscriberId != null && subscriberId.length() > 3 && !subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                        f22037a = 15000;
                        f22038b = 25000;
                        f22039c = 10000;
                        f22040d = 25000;
                        f22041e = 35000;
                        f22042f = 15000;
                    }
                }
            }
        }
    }

    public static int m29004a() {
        int i;
        int i2 = f22037a;
        if (f22046j <= 0 || f22047k <= 0) {
            i = i2;
        } else {
            i = (int) ((Math.max(f22049m, f22046j) + f22047k) - f22048l);
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) C6329v.m29015b().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                    i = f22038b;
                } else if (f22047k > 0 && f22047k < ((long) f22039c)) {
                    i = f22039c;
                }
            }
        }
        i2 = (f22057u * f22039c) + i;
        if (i2 <= f22039c) {
            i2 = f22039c;
        }
        if (((long) i2) <= f22047k) {
            i2 = (int) (f22047k + ((long) f22039c));
        }
        if (i2 >= f22038b) {
            i2 = f22038b;
        }
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b == null) {
            b = C6327t.m29005a(Thread.currentThread().getId());
        }
        if (i2 < b.f22064g + f22039c) {
            i2 = b.f22064g + f22039c;
        }
        b.f22064g = i2;
        return i2;
    }

    public static int m29009b() {
        int i;
        int i2 = f22040d;
        if (f22050n <= 0 || f22051o <= 0) {
            i = i2;
        } else {
            i = (int) ((Math.max(f22053q, f22050n) + f22051o) - f22052p);
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) C6329v.m29015b().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                    i = f22041e;
                } else if (f22051o > 0 && f22051o < ((long) f22042f)) {
                    i = f22042f;
                }
            }
        }
        i2 = (f22057u * f22039c) + i;
        if (i2 <= f22042f) {
            i2 = f22042f;
        }
        if (((long) i2) <= f22051o) {
            i2 = (int) (f22051o + ((long) f22042f));
        }
        if (i2 >= f22041e) {
            i2 = f22041e;
        }
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b != null) {
            if (i2 < b.f22065h + f22042f) {
                i2 = b.f22065h + f22042f;
            }
            if (i2 < b.f22064g + f22042f) {
                i2 = b.f22064g + f22042f;
            }
            b.f22065h = i2;
        }
        return i2;
    }

    public static void m29008a(boolean z) {
        if (!z) {
            f22057u++;
        }
        C6328u c = C6327t.m29011c(Thread.currentThread().getId());
        if (c != null) {
            long j = c.f22059b;
        }
    }

    public static void m29007a(HttpURLConnection httpURLConnection) {
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b == null) {
            b = C6327t.m29005a(Thread.currentThread().getId());
        }
        if (b != null) {
            b.f22059b = System.currentTimeMillis();
        }
    }

    public static void m29012c() {
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b != null) {
            b.f22060c = System.currentTimeMillis() - b.f22059b;
            b.f22059b = System.currentTimeMillis();
            f22049m = b.f22060c;
            f22047k = b.f22060c > f22047k ? b.f22060c : f22047k;
            long j = b.f22060c < f22048l ? b.f22060c : f22048l == 0 ? b.f22060c : f22048l;
            f22048l = j;
            if (f22043g != null) {
                synchronized (f22043g) {
                    Iterator it = f22043g.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        C6328u c6328u = (C6328u) it.next();
                        if (c6328u.f22060c > 0) {
                            f22046j += c6328u.f22060c;
                            i++;
                        }
                    }
                    if (i > 0) {
                        f22046j /= (long) i;
                    }
                }
            }
        }
    }

    public static void m29013d() {
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b != null) {
            long j;
            b.f22061d = System.currentTimeMillis() - b.f22059b;
            b.f22059b = System.currentTimeMillis();
            f22053q = b.f22061d;
            if (b.f22061d > f22051o) {
                j = b.f22061d;
            } else {
                j = f22051o;
            }
            f22051o = j;
            j = b.f22061d < f22052p ? b.f22061d : f22052p == 0 ? b.f22061d : f22052p;
            f22052p = j;
            if (f22043g != null) {
                synchronized (f22043g) {
                    Iterator it = f22043g.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        C6328u c6328u = (C6328u) it.next();
                        if (c6328u.f22061d > 0) {
                            f22050n += c6328u.f22061d;
                            i++;
                        }
                    }
                    if (i > 0) {
                        f22050n /= (long) i;
                    }
                }
            }
        }
    }

    public static void m29006a(int i) {
        C6328u b = C6327t.m29010b(Thread.currentThread().getId());
        if (b != null) {
            b.f22063f = System.currentTimeMillis() - b.f22059b;
            b.f22059b = System.currentTimeMillis();
            b.f22062e = i;
            int i2 = (int) (((long) (i * 1000)) / (b.f22063f == 0 ? 1 : b.f22063f));
            f22056t = i2;
            f22054r = i2 > f22054r ? f22056t : f22054r;
            i2 = f22056t < f22055s ? f22056t : f22055s == 0 ? f22056t : f22055s;
            f22055s = i2;
            if (f22043g != null) {
                synchronized (f22043g) {
                    Iterator it = f22043g.iterator();
                    while (it.hasNext()) {
                        C6328u c6328u = (C6328u) it.next();
                        int i3 = c6328u.f22062e;
                        long j = c6328u.f22063f;
                    }
                }
            }
            if (f22057u > 0 && b.f22060c < ((long) f22039c) && b.f22061d < ((long) f22042f)) {
                f22057u--;
            }
            b.f22064g = (int) b.f22060c;
        }
    }

    private static C6328u m29005a(long j) {
        C6328u c6328u;
        if (f22043g == null) {
            f22043g = new ArrayList();
        }
        synchronized (f22043g) {
            if (f22043g.size() > 20) {
                int size = f22043g.size();
                int i = 0;
                Object obj = null;
                int i2 = 0;
                while (i < size / 2) {
                    Object obj2;
                    int i3;
                    if (((C6328u) f22043g.get(i2)).f22063f > 0 || System.currentTimeMillis() - ((C6328u) f22043g.get(i2)).f22059b > 600000) {
                        f22043g.remove(i2);
                        obj2 = 1;
                        i3 = i2;
                    } else {
                        Object obj3 = obj;
                        i3 = i2 + 1;
                        obj2 = obj3;
                    }
                    i++;
                    i2 = i3;
                    obj = obj2;
                }
                if (obj != null) {
                    f22043g.get(0);
                    f22044h = 0;
                    f22043g.get(0);
                    f22045i = 0;
                    f22047k = ((C6328u) f22043g.get(0)).f22060c;
                    f22048l = ((C6328u) f22043g.get(0)).f22060c;
                    f22051o = ((C6328u) f22043g.get(0)).f22061d;
                    f22052p = ((C6328u) f22043g.get(0)).f22061d;
                    if (((C6328u) f22043g.get(0)).f22063f > 0) {
                        f22054r = (int) (((long) (((C6328u) f22043g.get(0)).f22062e * 1000)) / ((C6328u) f22043g.get(0)).f22063f);
                    }
                    f22055s = f22054r;
                    Iterator it = f22043g.iterator();
                    while (it.hasNext()) {
                        c6328u = (C6328u) it.next();
                        if (0 > f22044h) {
                            f22044h = 0;
                        }
                        if (0 < f22045i) {
                            f22045i = 0;
                        }
                        if (c6328u.f22060c > f22047k) {
                            f22047k = c6328u.f22060c;
                        }
                        if (c6328u.f22060c < f22048l) {
                            f22048l = c6328u.f22060c;
                        }
                        if (c6328u.f22061d > f22051o) {
                            f22051o = c6328u.f22061d;
                        }
                        if (c6328u.f22061d < f22052p) {
                            f22052p = c6328u.f22061d;
                        }
                        if (c6328u.f22063f > 0) {
                            int i4 = (int) (((long) (c6328u.f22062e * 1000)) / c6328u.f22063f);
                            if (i4 > f22054r) {
                                f22054r = i4;
                            }
                            if (i4 < f22055s) {
                                f22055s = i4;
                            }
                        }
                    }
                }
            }
            c6328u = new C6328u();
            c6328u.f22058a = j;
            f22043g.add(c6328u);
        }
        return c6328u;
    }

    private static C6328u m29010b(long j) {
        if (f22043g == null) {
            return null;
        }
        synchronized (f22043g) {
            Iterator it = f22043g.iterator();
            while (it.hasNext()) {
                C6328u c6328u = (C6328u) it.next();
                if (c6328u.f22058a == j) {
                    return c6328u;
                }
            }
            return null;
        }
    }

    private static C6328u m29011c(long j) {
        if (f22043g != null) {
            synchronized (f22043g) {
                for (int size = f22043g.size() - 1; size >= 0; size--) {
                    if (((C6328u) f22043g.get(size)).f22058a == j) {
                        C6328u c6328u = (C6328u) f22043g.remove(size);
                        return c6328u;
                    }
                }
            }
        }
        return null;
    }
}
