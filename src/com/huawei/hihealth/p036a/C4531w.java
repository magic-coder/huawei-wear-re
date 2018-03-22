package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4531w extends ab {
    final /* synthetic */ C4530v f16749a;

    C4531w(C4530v c4530v) {
        this.f16749a = c4530v;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        if (this.f16749a.f16747a != null) {
            this.f16749a.f16747a.mo4331a(i, list.get(0));
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16749a.f16747a != null) {
            this.f16749a.f16747a.mo4332b(i, list.get(0));
        }
    }
}
