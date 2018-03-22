package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.p014a.C0340a;

public interface cz extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException;

    int getIntFlagValue(String str, int i, int i2) throws RemoteException;

    long getLongFlagValue(String str, long j, int i) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i) throws RemoteException;

    void init(C0340a c0340a) throws RemoteException;
}
