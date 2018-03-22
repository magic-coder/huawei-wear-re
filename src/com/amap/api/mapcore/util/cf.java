package com.amap.api.mapcore.util;

import java.util.Date;
import java.util.List;

/* compiled from: CrashLogWriter */
class cf extends cl {
    private C3305a f11598a;

    /* compiled from: CrashLogWriter */
    class C3305a implements dh {
        final /* synthetic */ cf f11596a;
        private cv f11597b;

        C3305a(cf cfVar, cv cvVar) {
            this.f11596a = cfVar;
            this.f11597b = cvVar;
        }

        public void mo4023a(String str) {
            try {
                this.f11597b.m15955b(str, this.f11596a.mo4024a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    cf() {
    }

    protected int mo4024a() {
        return 0;
    }

    protected String mo4026a(String str) {
        return bs.m15760c(str + cm.m15909a(new Date().getTime()));
    }

    protected String mo4028b() {
        return ci.f11611c;
    }

    protected dh mo4025a(cv cvVar) {
        try {
            if (this.f11598a == null) {
                this.f11598a = new C3305a(this, cvVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f11598a;
    }

    protected String mo4027a(List<bv> list) {
        return null;
    }
}
