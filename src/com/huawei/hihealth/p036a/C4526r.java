package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4526r extends ab {
    final /* synthetic */ C4525q f16739a;

    C4526r(C4525q c4525q) {
        this.f16739a = c4525q;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        if (this.f16739a.f16737a != null) {
            this.f16739a.f16737a.mo4331a(i, list);
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16739a.f16737a != null) {
            this.f16739a.f16737a.mo4332b(i, list.get(0));
        }
    }
}
