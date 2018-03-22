package com.huawei.hwservicesmgr;

import android.os.IInterface;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: IDeviceStateAIDLCallback */
public interface C1048d extends IInterface {
    void m4416a(DeviceInfo deviceInfo, int i, String str) throws RemoteException;

    void m4417a(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException;

    void m4418b(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException;
}
