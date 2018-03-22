package com.amap.api.mapcore;

import com.amap.api.mapcore.util.bn;
import com.amap.api.mapcore.util.bp;
import com.amap.api.mapcore.util.bp.C3294a;
import com.amap.api.mapcore.util.bu;
import com.amap.api.mapcore.util.bv;
import com.amap.api.mapcore.util.bv.C3299a;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.MapsInitializer;

/* compiled from: AMapDelegateImp */
class C3245c extends Thread {
    final /* synthetic */ AMapDelegateImp f11221a;

    C3245c(AMapDelegateImp aMapDelegateImp) {
        this.f11221a = aMapDelegateImp;
    }

    public void run() {
        while (!MapsInitializer.getNetWorkEnable()) {
            try {
                Thread.sleep(5000);
            } catch (Throwable th) {
                interrupt();
                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
                th.printStackTrace();
                return;
            }
        }
        bv a = new C3299a(C3264r.f11366b, "3.2.0.1", C3264r.f11368d).m15789a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore"}).m15790a();
        bn.m15698b(this.f11221a.f10822B, a);
        if (bn.f11512a == 0) {
            this.f11221a.f10858l.sendEmptyMessage(2);
        }
        C3294a a2 = bp.m15710a(this.f11221a.f10822B, a, "common;exception;sdkcoordinate");
        if (a2 != null) {
            if (a2.f11527d != null) {
                a.m15792a(a2.f11527d.f11517a);
            }
            if (a2.f11529f != null) {
                new bu(this.f11221a.f10822B, C3264r.f11366b, a2.f11529f.f11519a, a2.f11529f.f11520b).m15776a();
            }
        }
        C3264r.f11370f = a;
        ca.m15829a(this.f11221a.f10822B, a);
        interrupt();
        this.f11221a.mo3816e(false);
    }
}
