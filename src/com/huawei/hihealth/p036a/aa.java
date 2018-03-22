package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ab;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class aa extends ab {
    final /* synthetic */ C4534z f16692a;

    aa(C4534z c4534z) {
        this.f16692a = c4534z;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        if (this.f16692a.f16757c != null) {
            this.f16692a.f16757c.mo4331a(i, list);
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        if (this.f16692a.f16757c != null) {
            this.f16692a.f16757c.mo4332b(i, list.get(0));
        }
    }
}
