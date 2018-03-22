package com.amap.api.services.core;

import java.util.Date;
import java.util.List;

/* compiled from: CrashLogWriter */
class bc extends bi {
    private C3397a f12404a;

    /* compiled from: CrashLogWriter */
    class C3397a implements bn {
        final /* synthetic */ bc f12402a;
        private ak f12403b;

        C3397a(bc bcVar, ak akVar) {
            this.f12402a = bcVar;
            this.f12403b = akVar;
        }

        public void mo4115a(String str) {
            try {
                this.f12403b.m16655b(str, this.f12402a.mo4116a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bc() {
    }

    protected int mo4116a() {
        return 0;
    }

    protected String mo4118a(String str) {
        return ab.m16592b(str + bj.m16789a(new Date().getTime()));
    }

    protected String mo4120b() {
        return bf.f12417c;
    }

    protected bn mo4117a(ak akVar) {
        try {
            if (this.f12404a == null) {
                this.f12404a = new C3397a(this, akVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f12404a;
    }

    protected String mo4119a(List<ad> list) {
        return null;
    }
}
