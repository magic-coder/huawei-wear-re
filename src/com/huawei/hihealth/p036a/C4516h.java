package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.C4515s;
import com.huawei.hihealth.p394c.C4541c;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4516h extends C4515s {
    final /* synthetic */ List f16712a;
    final /* synthetic */ C4513g f16713b;

    C4516h(C4513g c4513g, List list) {
        this.f16713b = c4513g;
        this.f16712a = list;
    }

    public void mo4490a(List list, int i, int i2) throws RemoteException {
        if (this.f16713b.f16710b != null && C4541c.m21771a(list, i2, this.f16712a)) {
            this.f16713b.f16710b.mo5128a(this.f16712a.isEmpty() ? null : this.f16712a, i, i2);
        }
    }
}
