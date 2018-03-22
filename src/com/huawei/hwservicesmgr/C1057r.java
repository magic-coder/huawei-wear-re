package com.huawei.hwservicesmgr;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: ITransferSleepAndDFXFileCallback */
public interface C1057r extends IInterface {
    void onFailure(int i, String str) throws RemoteException;

    void onSuccess(int i, String str, String str2) throws RemoteException;
}
