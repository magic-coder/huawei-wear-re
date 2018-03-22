package org.simalliance.openmobileapi.service;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: ISmartcardService */
public interface C6658b extends IInterface {
    C6665k mo5534a(String str, SmartcardError smartcardError) throws RemoteException;

    String[] mo5535a(SmartcardError smartcardError) throws RemoteException;

    boolean[] mo5536a(String str, byte[] bArr, String[] strArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException;
}
