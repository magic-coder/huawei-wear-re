package com.huawei.multisimservice;

import android.os.IInterface;
import android.os.RemoteException;
import com.huawei.multisimservice.model.C1120a;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* compiled from: IAttachedDeviceMultiSim */
public interface C1188a extends IInterface {
    void mo2363a() throws RemoteException;

    void mo2364a(int i, String str) throws RemoteException;

    void mo2365a(C1120a c1120a) throws RemoteException;

    void mo2366a(String str) throws RemoteException;

    void mo2367a(List<SimInfo> list) throws RemoteException;

    void mo2368b(C1120a c1120a) throws RemoteException;
}
