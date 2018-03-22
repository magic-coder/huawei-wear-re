package com.huawei.hwdevicemgr.p073a;

import com.huawei.p029c.C0669b;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceMgr */
class C4986e implements C0669b {
    final /* synthetic */ C1023c f18069a;

    C4986e(C1023c cVar) {
        this.f18069a = cVar;
    }

    // m23922a
    public void mo2342a(int i) {
        if (i > 100) {
            i = 100;
        }
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"IOTAResultCallback---onFileTransferState percentage------" + i});
        C1023c.d(this.f18069a).a(i);
        if (100 == i) {
            C1023c.a(this.f18069a, false);
        }
    }

    // m23923a
    public void mo2343a(int i, String str) {
        C1023c.d(this.f18069a).a(i, str);
        C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"IOTAResultCallback---onUpgradeFailed errorCode-------" + i});
        C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"IOTAResultCallback---onUpgradeFailed errorMessage----" + str});
        C1023c.a(this.f18069a, false);
    }

    // m23924b
    public void mo2344b(int i) {
        C1023c.d(this.f18069a).b(i);
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"IOTAResultCallback---onFileRespond checkResult------" + i});
        C1023c.a(this.f18069a, false);
    }
}
