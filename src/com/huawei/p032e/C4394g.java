package com.huawei.p032e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.huawei.e.a;
import com.huawei.e.j;
import com.huawei.hwservicesmgr.datetype.DeviceInfo;
import java.util.List;
import java.util.Map;

/* compiled from: ICallbackInterface */
public interface C4394g extends IInterface {
    Map mo4446a(String str, int i) throws RemoteException;

    void mo4447a(int i, a aVar) throws RemoteException;

    void mo4448a(IBinder iBinder, String str, String str2) throws RemoteException;

    void mo4449a(a aVar) throws RemoteException;

    void mo4450a(j jVar) throws RemoteException;

    void mo4451a(C4398m c4398m) throws RemoteException;

    void mo4452a(String str) throws RemoteException;

    void mo4453a(String str, a aVar) throws RemoteException;

    void mo4454a(List<DeviceInfo> list) throws RemoteException;

    boolean mo4455a(Map map) throws RemoteException;

    void mo4456b(a aVar) throws RemoteException;

    void mo4457b(j jVar) throws RemoteException;

    void mo4458b(C4398m c4398m) throws RemoteException;
}
