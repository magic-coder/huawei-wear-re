package com.amap.api.services.core;

import java.util.List;

/* compiled from: ExceptionLogWriter */
class be extends bi {
    private C3398a f12408a;

    /* compiled from: ExceptionLogWriter */
    class C3398a implements bn {
        final /* synthetic */ be f12406a;
        private ak f12407b;

        C3398a(be beVar, ak akVar) {
            this.f12406a = beVar;
            this.f12407b = akVar;
        }

        public void mo4115a(String str) {
            try {
                this.f12407b.m16655b(str, this.f12406a.mo4116a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    be() {
    }

    protected int mo4116a() {
        return 1;
    }

    protected String mo4118a(String str) {
        return ab.m16592b(str);
    }

    protected String mo4120b() {
        return bf.f12416b;
    }

    protected bn mo4117a(ak akVar) {
        try {
            if (this.f12408a == null) {
                this.f12408a = new C3398a(this, akVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f12408a;
    }

    protected String mo4119a(List<ad> list) {
        return null;
    }
}
