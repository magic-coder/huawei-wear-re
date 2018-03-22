package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface dr extends IInterface {
    void mo1823a(ConnectionResult connectionResult, zzbak com_google_android_gms_internal_zzbak) throws RemoteException;

    void mo1824a(Status status) throws RemoteException;

    void mo1825a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void mo1826a(zzbaw com_google_android_gms_internal_zzbaw) throws RemoteException;

    void mo1827b(Status status) throws RemoteException;
}
