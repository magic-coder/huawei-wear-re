package com.amap.api.mapcore.util;

import java.util.List;

/* compiled from: ExceptionLogWriter */
class ch extends cl {
    private C3306a f11602a;

    /* compiled from: ExceptionLogWriter */
    class C3306a implements dh {
        final /* synthetic */ ch f11600a;
        private cv f11601b;

        C3306a(ch chVar, cv cvVar) {
            this.f11600a = chVar;
            this.f11601b = cvVar;
        }

        public void mo4023a(String str) {
            try {
                this.f11601b.m15955b(str, this.f11600a.mo4024a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    ch() {
    }

    protected int mo4024a() {
        return 1;
    }

    protected String mo4026a(String str) {
        return bs.m15760c(str);
    }

    protected String mo4028b() {
        return ci.f11610b;
    }

    protected dh mo4025a(cv cvVar) {
        try {
            if (this.f11602a == null) {
                this.f11602a = new C3306a(this, cvVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f11602a;
    }

    protected String mo4027a(List<bv> list) {
        return null;
    }
}
