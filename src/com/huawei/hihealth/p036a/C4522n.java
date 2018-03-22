package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.aq;

/* compiled from: HiHealthNativeAPI */
class C4522n extends aq {
    final /* synthetic */ C4521m f16732a;

    C4522n(C4521m c4521m) {
        this.f16732a = c4521m;
    }

    public void mo4493a(HiHealthClient hiHealthClient) throws RemoteException {
        if (this.f16732a.f16730c != null) {
            this.f16732a.f16730c.mo4609a(hiHealthClient);
        }
    }
}
