package com.huawei.openalliance.ad.utils.p129b;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.utils.p129b.C1341g.C1340a;
import java.util.HashMap;
import java.util.Map;

public final class C1338e {
    private static Map<String, C1338e> f2889a = new HashMap();
    private static String f2890b = "log.log";
    private static C1339f f2891c = C1339f.INFO;
    private C1333a f2892d = null;
    private String f2893e;
    private final C1342i f2894f = new C1342i();

    public class C1337a {
        private String f2886a;
        private boolean f2887b = false;
        private String f2888c = C1338e.f2890b;

        public C1337a(String str) {
            this.f2886a = str;
        }

        public C1337a m5893a(boolean z) {
            this.f2887b = z;
            return this;
        }

        public C1338e m5894a() {
            C1338e e = C1338e.m5902f(this.f2888c, this.f2886a);
            if (this.f2887b) {
                e.m5900b();
            }
            return e;
        }
    }

    private C1338e() {
    }

    public static void m5897a(C1339f c1339f) {
        f2891c = c1339f;
    }

    public static void m5898a(String str) {
        f2890b = str;
    }

    private void m5899a(String str, String str2, C1339f c1339f, String str3, Throwable th) {
        C1341g a = new C1340a(str, c1339f).m5913a(this.f2893e).m5912a(this.f2894f.m5928a()).m5914a();
        if (!TextUtils.isEmpty(str3)) {
            a.m5921a((Object) "[").m5921a((Object) str3).m5921a((Object) "]");
        }
        a.m5921a((Object) str2);
        if (th != null) {
            a.m5923b(th);
        }
        a.m5922a(this.f2892d);
    }

    private void m5900b() {
        new C1340a(null, C1339f.OUT).m5914a().m5925c().m5921a(C1334b.m5880a()).m5922a(this.f2892d);
    }

    private static synchronized C1338e m5902f(String str, String str2) {
        C1338e c1338e;
        synchronized (C1338e.class) {
            Log.i("LogAdaptor", "createAppLog, file:" + str + ", module:" + str2);
            c1338e = (C1338e) f2889a.get(str2);
            if (c1338e == null) {
                c1338e = new C1338e();
                c1338e.m5903g(str, str2);
                c1338e.m5905b(f2891c);
                f2889a.put(str2, c1338e);
            }
        }
        return c1338e;
    }

    private void m5903g(String str, String str2) {
        this.f2893e = str2;
        this.f2892d = new C1333a(str2, str, C1339f.INFO);
    }

    public void m5904a(String str, String str2) {
        m5899a(str, str2, C1339f.DEBUG, null, null);
    }

    public void m5905b(C1339f c1339f) {
        this.f2892d.m5870b(c1339f);
    }

    public void m5906b(String str, String str2) {
        m5899a(str, str2, C1339f.INFO, null, null);
    }

    public void m5907c(String str, String str2) {
        m5899a(str, str2, C1339f.WARN, null, null);
    }

    public boolean m5908c(C1339f c1339f) {
        return this.f2892d.m5878a(c1339f);
    }

    public void m5909d(String str, String str2) {
        m5899a(str, str2, C1339f.ERROR, null, null);
    }
}
