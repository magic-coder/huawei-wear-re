package com.unionpay.p109a.p110a;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: IVendorTsmService */
public interface C1206d extends IInterface {
    void createSSD(C2673a c2673a) throws RemoteException;

    void getCPLC(C2673a c2673a) throws RemoteException;

    void getDefaultCard(C2673a c2673a, String str) throws RemoteException;

    void setDefaultCard(C2673a c2673a, String str, Bundle bundle) throws RemoteException;
}
