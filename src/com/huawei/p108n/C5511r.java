package com.huawei.p108n;

import android.os.RemoteException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.e;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5511r extends e {
    final /* synthetic */ c f19418a;

    C5511r(c cVar) {
        this.f19418a = cVar;
    }

    public void m26275a(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException {
        C2538c.c("HWDeviceConfigManager", new Object[]{"onDataReceived() Received data = " + C0973a.a(bArr)});
        switch (bArr[0]) {
            case (byte) 1:
                c.b(this.f19418a, bArr);
                return;
            default:
                IBaseResponseCallback iBaseResponseCallback = null;
                synchronized (c.n()) {
                    if (c.o() == null || !c.o().containsKey(Integer.valueOf(bArr[0]))) {
                        C2538c.e("HWDeviceConfigManager", new Object[]{"onDataReceived() serviceCallback aaa is null"});
                    } else {
                        iBaseResponseCallback = (IBaseResponseCallback) c.o().get(Integer.valueOf(bArr[0]));
                    }
                }
                if (iBaseResponseCallback != null) {
                    iBaseResponseCallback.onResponse(0, bArr);
                    return;
                }
                C2538c.e("HWDeviceConfigManager", new Object[]{"onDataReceived() callback aaa is null"});
                return;
        }
    }

    public void m26276b(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException {
    }

    public void m26274a(DeviceInfo deviceInfo, int i, String str) {
        C2538c.c("HWDeviceConfigManager", new Object[]{"onDataReceived() Received model = " + i + "data " + str});
        IBaseResponseCallback iBaseResponseCallback = null;
        synchronized (c.n()) {
            if (c.o().containsKey(Integer.valueOf(i))) {
                iBaseResponseCallback = (IBaseResponseCallback) c.o().get(Integer.valueOf(i));
            }
        }
        if (iBaseResponseCallback != null) {
            iBaseResponseCallback.onResponse(0, str);
        }
    }
}
