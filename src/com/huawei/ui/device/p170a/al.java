package com.huawei.ui.device.p170a;

import android.os.RemoteException;
import com.huawei.hwservicesmgr.C1053k;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateInteractors */
class al extends C1053k {
    final /* synthetic */ ah f6887a;

    al(ah ahVar) {
        this.f6887a = ahVar;
    }

    public void mo2630a(int i) throws RemoteException {
    }

    public void mo2631a(int i, String str) throws RemoteException {
        C2538c.m12677c("UpdateInteractors", "autoTransfer: errorCode = " + i + " errorMessage = " + str);
        this.f6887a.f6883s = false;
    }

    public void mo2632b(int i) throws RemoteException {
        C2538c.m12677c("UpdateInteractors", "auto transfer success checkResult" + i);
        if (this.f6887a.f6879n == null) {
            this.f6887a.f6879n = C1071a.m4507a(this.f6887a.f6878m);
        }
        this.f6887a.f6879n.m4525h();
        this.f6887a.f6883s = false;
        if (i != 0) {
            this.f6887a.m10335c(Boolean.valueOf(true));
        }
    }
}
