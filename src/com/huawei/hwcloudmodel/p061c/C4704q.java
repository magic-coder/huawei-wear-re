package com.huawei.hwcloudmodel.p061c;

import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.p190v.C2538c;
import java.util.Map;

/* compiled from: HWDataRequest */
class C4704q implements Runnable {
    final /* synthetic */ C4706s f17146a;
    final /* synthetic */ String f17147b;
    final /* synthetic */ Map f17148c;
    final /* synthetic */ int f17149d;
    final /* synthetic */ int f17150e;
    final /* synthetic */ C4691b f17151f;
    final /* synthetic */ C4703p f17152g;

    C4704q(C4703p c4703p, C4706s c4706s, String str, Map map, int i, int i2, C4691b c4691b) {
        this.f17152g = c4703p;
        this.f17146a = c4706s;
        this.f17147b = str;
        this.f17148c = map;
        this.f17149d = i;
        this.f17150e = i2;
        this.f17151f = c4691b;
    }

    public void run() {
        try {
            this.f17151f.mo4556a(this.f17146a.m22441a(this.f17147b, this.f17148c, this.f17149d, this.f17150e, 1));
        } catch (Exception e) {
            C2538c.c("HWDataRequest", new Object[]{"NSPException" + e.m27917a() + e.getMessage()});
            this.f17151f.mo4555a(e.m27917a(), e);
        }
    }
}
