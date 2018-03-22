package com.huawei.multisimservice.model;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IAttachedDeviceMultiSimCallback */
public interface C1120a extends IInterface {
    void mo2357a(int i) throws RemoteException;

    void mo2358a(int i, List<SimInfo> list) throws RemoteException;

    void mo2359a(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException;
}
