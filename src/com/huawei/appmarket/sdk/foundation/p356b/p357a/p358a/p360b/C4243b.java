package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p360b;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p359a.C4240b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class C4243b {
    private static C4246d f15903k;
    private static C4245c f15904l = new C4245c();
    String f15905a = "ECS";
    C4242a f15906b = null;
    long f15907c = 0;
    long f15908d = 0;
    String f15909e = null;
    String f15910f;
    String f15911g;
    String f15912h;
    int f15913i;
    StringBuilder f15914j = null;
    private SimpleDateFormat f15915m = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private C4243b() {
    }

    private C4243b(String str, C4242a c4242a) {
        this.f15905a = str;
        this.f15906b = c4242a;
    }

    public static C4243b m20534a(String str) {
        return C4243b.m20535a(str, C4242a.DEBUG);
    }

    public static C4243b m20535a(String str, C4242a c4242a) {
        if (str == null) {
            str = "ECS";
        }
        C4243b c4243b = new C4243b(str, c4242a);
        if (c4243b.m20546h()) {
            c4243b.f15907c = System.currentTimeMillis();
            Thread currentThread = Thread.currentThread();
            c4243b.f15908d = currentThread.getId();
            c4243b.f15909e = currentThread.getName();
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
            String className = stackTraceElement.getClassName();
            c4243b.f15910f = className.substring(className.lastIndexOf(46) + 1);
            c4243b.f15911g = stackTraceElement.getMethodName();
            c4243b.f15912h = stackTraceElement.getFileName();
            c4243b.f15913i = stackTraceElement.getLineNumber();
            c4243b.f15914j = new StringBuilder(32);
        }
        return c4243b;
    }

    public static String m20536a(boolean z) {
        C4240b a = C4240b.m20525a();
        if (!z) {
            a.m20526a("============================================================================\n");
            a.m20526a("====                     version ").m20526a("3.4.71-00[20131118]").m20526a("                    ====\n");
            a.m20526a("====       MIP(Mobile Interface Protocol) with MTK(Mini Tool Kit)       ====\n");
            a.m20526a("====        Copyright (c) 2011-2013 Huawei Technologies Co., Ltd.       ====\n");
            a.m20526a("============================================================================");
        }
        return a.m20528c();
    }

    public static boolean m20537a(C4243b c4243b) {
        return c4243b == null || c4243b.m20550a();
    }

    private <T> C4243b m20538b(T t) {
        this.f15914j.append(t);
        return this;
    }

    public static C4243b m20539b(String str) {
        return C4243b.m20535a(str, C4242a.ERROR);
    }

    public static synchronized C4246d m20540b() {
        C4246d c4246d;
        synchronized (C4243b.class) {
            c4246d = f15903k;
        }
        return c4246d;
    }

    public static String m20541b(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean m20542b(String str, C4242a c4242a) {
        C4246d b = C4243b.m20540b();
        if (b == null) {
            return true;
        }
        if (str == null) {
            str = "ECS";
        }
        return b.mo4393b(str, c4242a);
    }

    public static C4243b m20543c() {
        return C4243b.m20535a(null, C4242a.INFO);
    }

    public static C4243b m20544d() {
        return C4243b.m20535a(null, C4242a.ERROR);
    }

    public static String m20545g() {
        C4246d b = C4243b.m20540b();
        return b == null ? null : b.mo4392b();
    }

    private boolean m20546h() {
        return C4243b.m20542b(this.f15905a, this.f15906b);
    }

    public C4240b m20547a(C4240b c4240b) {
        c4240b.m20526a(this.f15915m.format(Long.valueOf(this.f15907c)));
        c4240b.m20526a(Character.valueOf('[')).m20526a(this.f15905a).m20526a(Character.valueOf(']'));
        c4240b.m20526a(Character.valueOf('[')).m20526a(this.f15906b).m20526a(Character.valueOf(']'));
        return c4240b;
    }

    public <T> C4243b m20548a(T t) {
        if (m20546h()) {
            m20538b((Object) t);
        }
        return this;
    }

    public C4243b m20549a(Throwable th) {
        if (m20546h()) {
            m20538b(Character.valueOf('\n')).m20538b(C4243b.m20541b(th));
        }
        return this;
    }

    public boolean m20550a() {
        return this.f15914j == null;
    }

    public C4240b m20551b(C4240b c4240b) {
        String g = C4243b.m20545g();
        if (g != null && g.length() > 0) {
            c4240b.m20526a(Character.valueOf('[')).m20526a(g).m20526a(Character.valueOf(']'));
        }
        c4240b.m20526a(this.f15909e).m20526a(Character.valueOf('{')).m20526a(Long.valueOf(this.f15908d)).m20526a(Character.valueOf('}'));
        c4240b.m20526a(Character.valueOf(' ')).m20526a(this.f15910f).m20526a(Character.valueOf('.'));
        c4240b.m20526a(this.f15911g).m20526a(Character.valueOf('('));
        if (this.f15906b == C4242a.ASSERT || this.f15906b == C4242a.ERROR || this.f15906b == C4242a.WARN) {
            c4240b.m20526a(this.f15912h).m20526a(Character.valueOf(':')).m20526a(Integer.valueOf(this.f15913i));
        }
        c4240b.m20526a(Character.valueOf(')'));
        if (this.f15906b == C4242a.ASSERT || this.f15906b == C4242a.ERROR || this.f15906b == C4242a.WARN) {
            c4240b.m20526a(" <<< ").m20526a(this.f15906b).m20526a(" >>>");
        }
        c4240b.m20526a(Character.valueOf(' ')).m20526a(this.f15914j.toString());
        return c4240b;
    }

    public void m20552e() {
        if (this.f15914j != null) {
            f15904l.m20562a(this);
        }
    }

    void m20553f() {
        if (Thread.currentThread().getName().equals("logger")) {
            C4246d b = C4243b.m20540b();
            if (b != null) {
                b.mo4391a(this);
            } else {
                C4247e.m20574c(toString());
            }
        }
    }

    public String toString() {
        C4240b a = C4240b.m20525a();
        m20547a(a);
        m20551b(a);
        return a.m20528c();
    }
}
