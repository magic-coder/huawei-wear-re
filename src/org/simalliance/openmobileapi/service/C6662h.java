package org.simalliance.openmobileapi.service;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceChannel */
public interface C6662h extends IInterface {
    void mo5537a(SmartcardError smartcardError) throws RemoteException;

    boolean mo5538a() throws RemoteException;

    byte[] mo5539a(byte[] bArr, SmartcardError smartcardError) throws RemoteException;

    boolean mo5540b() throws RemoteException;

    boolean mo5541b(SmartcardError smartcardError) throws RemoteException;

    byte[] mo5542c() throws RemoteException;

    C6668n mo5543d() throws RemoteException;
}
