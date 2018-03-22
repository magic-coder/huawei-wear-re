package com.huawei.openalliance.ad.utils.p129b;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;

@SuppressLint({"SimpleDateFormat"})
public class C1341g {
    String f2909a = null;
    String f2910b = "HiAdSDK";
    C1339f f2911c = null;
    long f2912d = 0;
    long f2913e = 0;
    String f2914f = null;
    String f2915g;
    int f2916h;
    int f2917i;
    int f2918j = 0;
    StringBuilder f2919k = null;
    private SimpleDateFormat f2920l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public class C1340a {
        C1341g f2908a;

        public C1340a(String str, C1339f c1339f) {
            this.f2908a = new C1341g(str, c1339f);
        }

        public C1340a m5912a(int i) {
            this.f2908a.f2918j = i;
            return this;
        }

        public C1340a m5913a(String str) {
            this.f2908a.f2909a = str;
            return this;
        }

        public C1341g m5914a() {
            return this.f2908a.m5920a();
        }
    }

    protected C1341g() {
    }

    protected C1341g(String str, C1339f c1339f) {
        if (str != null) {
            this.f2910b = str;
        }
        this.f2911c = c1339f;
    }

    private C1343k m5915a(C1343k c1343k) {
        c1343k.m5930a(this.f2920l.format(Long.valueOf(this.f2912d)));
        c1343k.m5930a(Character.valueOf('[')).m5930a(Integer.valueOf(this.f2916h)).m5930a(Character.valueOf(']'));
        if (this.f2909a != null) {
            c1343k.m5930a(Character.valueOf('[')).m5930a(this.f2909a).m5930a(Character.valueOf(']'));
        }
        c1343k.m5930a(Character.valueOf('[')).m5930a(this.f2910b).m5930a(Character.valueOf(']'));
        c1343k.m5930a(Character.valueOf('[')).m5930a(this.f2911c).m5930a(Character.valueOf(']'));
        return c1343k;
    }

    public static String m5916a(Throwable th) {
        return "";
    }

    public static boolean m5917a(C1341g c1341g) {
        return c1341g == null || c1341g.m5924b();
    }

    private <T> C1341g m5918b(T t) {
        this.f2919k.append(t);
        return this;
    }

    private C1343k m5919b(C1343k c1343k) {
        c1343k.m5930a("[");
        c1343k.m5930a(this.f2914f).m5930a(Character.valueOf('{')).m5930a(Long.valueOf(this.f2913e)).m5930a(Character.valueOf('}'));
        c1343k.m5930a("]");
        c1343k.m5930a(Character.valueOf(' ')).m5930a(this.f2919k.toString());
        if (this.f2911c.m5911a() < C1339f.OUT.m5911a()) {
            c1343k.m5930a(Character.valueOf(' ')).m5930a(Character.valueOf('('));
            c1343k.m5930a(this.f2915g).m5930a(Character.valueOf(':')).m5930a(Integer.valueOf(this.f2917i));
            c1343k.m5930a(Character.valueOf(')'));
        }
        return c1343k;
    }

    protected C1341g m5920a() {
        this.f2912d = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f2913e = currentThread.getId();
        this.f2914f = currentThread.getName();
        this.f2916h = Process.myPid();
        try {
            StackTraceElement stackTraceElement = currentThread.getStackTrace()[this.f2918j + 7];
            this.f2915g = stackTraceElement.getFileName();
            this.f2917i = stackTraceElement.getLineNumber();
        } catch (Exception e) {
            Log.e("HiAdSDK", "create log error");
        }
        this.f2919k = new StringBuilder(32);
        return this;
    }

    public <T> C1341g m5921a(T t) {
        m5918b((Object) t);
        return this;
    }

    public void m5922a(C1332h c1332h) {
        if (this.f2919k != null) {
            c1332h.mo2458a(this);
        }
    }

    public C1341g m5923b(Throwable th) {
        m5918b(Character.valueOf('\n')).m5918b(C1341g.m5916a(th));
        return this;
    }

    public boolean m5924b() {
        return this.f2919k == null;
    }

    public C1341g m5925c() {
        return m5921a(Character.valueOf('\n'));
    }

    public String m5926d() {
        C1343k a = C1343k.m5929a();
        m5915a(a);
        return a.m5932c();
    }

    public String m5927e() {
        C1343k a = C1343k.m5929a();
        m5919b(a);
        return a.m5932c();
    }

    public String toString() {
        C1343k a = C1343k.m5929a();
        m5915a(a);
        m5919b(a);
        return a.m5932c();
    }
}
