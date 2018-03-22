package org.simalliance.openmobileapi.service;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceSession */
public interface C6668n extends IInterface {
    C6662h mo5548a(C6652e c6652e, SmartcardError smartcardError) throws RemoteException;

    C6662h mo5549a(byte[] bArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException;

    C6665k mo5550a() throws RemoteException;

    void mo5551a(SmartcardError smartcardError) throws RemoteException;

    C6662h mo5552b(byte[] bArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException;

    void mo5553b(SmartcardError smartcardError) throws RemoteException;

    byte[] mo5554b() throws RemoteException;

    boolean mo5555c() throws RemoteException;
}
