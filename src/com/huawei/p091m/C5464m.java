package com.huawei.p091m;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.m.d;
import java.util.ArrayList;

/* compiled from: HwCoreSleepMgr */
class C5464m implements Runnable {
    IBaseResponseCallback f19312a;
    ArrayList<byte[]> f19313b = new ArrayList();
    ArrayList<byte[]> f19314c = new ArrayList();
    final /* synthetic */ d f19315d;

    C5464m(d dVar, ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2, IBaseResponseCallback iBaseResponseCallback) {
        int i = 0;
        this.f19315d = dVar;
        this.f19312a = iBaseResponseCallback;
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.f19313b.add(i2, arrayList.get(i2));
            }
        }
        if (arrayList2.size() > 0) {
            while (i < arrayList2.size()) {
                this.f19314c.add(i, arrayList2.get(i));
                i++;
            }
        }
    }

    public void run() {
        d.a(this.f19315d, this.f19313b, this.f19314c, this.f19312a);
    }
}
