package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4533y extends ab {
    final /* synthetic */ C4532x f16754a;

    C4533y(C4532x c4532x) {
        this.f16754a = c4532x;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        if (this.f16754a.f16752c != null) {
            this.f16754a.f16752c.mo4331a(i, list.get(0));
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16754a.f16752c != null) {
            this.f16754a.f16752c.mo4332b(i, list.get(0));
        }
    }
}
