package com.huawei.hwservicesmgr;

import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C1024b;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneService */
class C1060u implements C1024b {
    final /* synthetic */ PhoneService f2081a;

    C1060u(PhoneService phoneService) {
        this.f2081a = phoneService;
    }

    public void mo2340a(DeviceInfo deviceInfo, int i, byte[] bArr) {
        IParser iParser = null;
        if (bArr != null) {
            if (PhoneService.f1934k == null) {
                C2538c.m12680e("PhoneService", "managerMap is null");
                return;
            }
            this.f2081a.m4199a(bArr);
            if ((byte) 10 == bArr[0]) {
                iParser = (IParser) PhoneService.f1934k.get(Integer.valueOf(1014));
            } else {
                iParser = (IParser) PhoneService.f1934k.get(Integer.valueOf(bArr[0]));
            }
        }
        if (PhoneService.f1932b != null) {
            try {
                PhoneService.f1932b.m4417a(deviceInfo, i, bArr);
            } catch (RemoteException e) {
                C2538c.m12680e("PhoneService", "onDataReceived remoteException:" + e.getMessage());
            } catch (Exception e2) {
                C2538c.m12680e("PhoneService", "onDataReceived Exception:" + e2.getMessage());
            }
        }
        if (iParser != null) {
            C2538c.m12677c("PhoneService", "the manager is " + iParser.getClass().getSimpleName());
            iParser.getResult(bArr);
        }
    }

    public void mo2339a(DeviceInfo deviceInfo, int i, String str) {
        C2538c.m12680e("PhoneService", "onDatasReceived remoteException:" + str);
        if (PhoneService.f1932b != null) {
            try {
                PhoneService.f1932b.m4416a(deviceInfo, i, str);
            } catch (RemoteException e) {
                C2538c.m12680e("PhoneService", "onDataReceived remoteException:" + e.getMessage());
            }
        }
    }
}
