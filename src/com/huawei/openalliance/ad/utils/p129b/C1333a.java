package com.huawei.openalliance.ad.utils.p129b;

import android.util.Log;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p116b.C1243a.C1242a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class C1333a extends C1332h {
    private static C1330a f2880b = new C1330a();
    private String f2881c;
    private boolean f2882d = false;
    private boolean f2883e = false;
    private boolean f2884f = true;

    public class C1330a extends C1329j {
        private BlockingQueue<C1331b> f2871a = new LinkedBlockingQueue();

        public C1330a() {
            super("logger");
        }

        public void m5859a(C1331b c1331b) {
            boolean offer = this.f2871a.offer(c1331b);
            if (!offer) {
                Log.w("AndroidLogger", "add record to queue result:" + offer);
            }
        }

        protected boolean mo2455a() {
            return true;
        }

        protected boolean mo2456b() {
            try {
                C1331b c1331b = (C1331b) this.f2871a.poll(3, TimeUnit.SECONDS);
                if (c1331b != null) {
                    if (!C1341g.m5917a(c1331b.f2872a)) {
                        c1331b.f2873b.mo2459b(c1331b.f2872a);
                    } else if (c1331b.f2872a != null) {
                        return false;
                    }
                }
            } catch (InterruptedException e) {
            }
            return true;
        }

        protected void mo2457c() {
        }
    }

    public class C1331b {
        C1341g f2872a;
        C1332h f2873b;

        public C1331b(C1341g c1341g, C1332h c1332h) {
            if (c1341g == null && c1332h == null) {
                throw new NullPointerException("record and logger is null");
            }
            this.f2873b = c1332h;
            this.f2872a = c1341g;
        }
    }

    public C1333a(String str, String str2, C1339f c1339f) {
        super(str2, 409600);
        this.a = c1339f;
        this.f2881c = str;
        try {
            C1333a.m5873a();
            m5875c();
        } catch (Throwable e) {
            Log.e("AndroidLogger", "AndroidLogger init error", e);
        }
    }

    public static void m5873a() {
        if (!f2880b.isAlive()) {
            f2880b.start();
        }
    }

    private void m5874b(String str, C1339f c1339f, String str2) {
        if (m5876c(c1339f)) {
            String str3 = this.f2881c + "." + str;
            switch (c1339f.m5911a()) {
                case 2:
                    Log.v(str3, str2);
                    return;
                case 3:
                    Log.d(str3, str2);
                    return;
                case 4:
                    Log.i(str3, str2);
                    return;
                case 5:
                    Log.w(str3, str2);
                    return;
                case 6:
                    Log.e(str3, str2);
                    return;
                default:
                    Log.w(str3, "[" + c1339f.toString() + "] " + str2);
                    return;
            }
        }
    }

    private void m5875c() {
        boolean z = true;
        this.f2882d = C1242a.FORMAL != C1243a.f2653a;
        if (C1242a.FORMAL == C1243a.f2653a) {
            z = false;
        }
        this.f2883e = z;
    }

    private boolean m5876c(C1339f c1339f) {
        switch (c1339f.m5911a()) {
            case 3:
                return this.f2882d;
            case 4:
                return this.f2883e;
            case 5:
            case 6:
                return this.f2884f;
            default:
                return false;
        }
    }

    public void mo2458a(C1341g c1341g) {
        f2880b.m5859a(new C1331b(c1341g, this));
    }

    public boolean m5878a(C1339f c1339f) {
        return this.a.m5911a() <= c1339f.m5911a();
    }

    public void mo2459b(C1341g c1341g) {
        try {
            String e = c1341g.m5927e();
            m5874b(c1341g.f2910b, c1341g.f2911c, e);
            m5867a(c1341g.f2910b, c1341g.f2911c, c1341g.m5926d() + e);
        } catch (OutOfMemoryError e2) {
            Log.e("AndroidLogger", "write error");
        }
    }
}
