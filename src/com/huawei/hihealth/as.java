package com.huawei.hihealth;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ISubscribeListener */
public interface as extends IInterface {
    void mo4487a(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException;

    void mo4488a(List list, List list2) throws RemoteException;
}
