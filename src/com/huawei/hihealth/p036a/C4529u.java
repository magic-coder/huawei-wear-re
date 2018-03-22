package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4529u extends ab {
    final /* synthetic */ C4528t f16746a;

    C4529u(C4528t c4528t) {
        this.f16746a = c4528t;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        if (this.f16746a.f16744b != null) {
            this.f16746a.f16744b.mo4331a(i, list.get(0));
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16746a.f16744b != null) {
            this.f16746a.f16744b.mo4332b(i, list.get(0));
        }
    }
}
