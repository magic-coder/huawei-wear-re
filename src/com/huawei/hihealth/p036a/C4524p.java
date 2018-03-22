package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4524p extends ab {
    final /* synthetic */ C4523o f16736a;

    C4524p(C4523o c4523o) {
        this.f16736a = c4523o;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        Object obj = list.get(0);
        if (this.f16736a.f16734b != null) {
            this.f16736a.f16734b.mo4331a(i, obj);
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16736a.f16734b != null) {
            this.f16736a.f16734b.mo4332b(i, list.get(0));
        }
    }
}
