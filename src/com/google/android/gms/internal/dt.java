package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

class dt implements dr {
    private IBinder f702a;

    dt(IBinder iBinder) {
        this.f702a = iBinder;
    }

    public void mo1823a(ConnectionResult connectionResult, zzbak com_google_android_gms_internal_zzbak) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (connectionResult != null) {
                obtain.writeInt(1);
                connectionResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (com_google_android_gms_internal_zzbak != null) {
                obtain.writeInt(1);
                com_google_android_gms_internal_zzbak.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f702a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1824a(Status status) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f702a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1825a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (googleSignInAccount != null) {
                obtain.writeInt(1);
                googleSignInAccount.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f702a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1826a(zzbaw com_google_android_gms_internal_zzbaw) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (com_google_android_gms_internal_zzbaw != null) {
                obtain.writeInt(1);
                com_google_android_gms_internal_zzbaw.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f702a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f702a;
    }

    public void mo1827b(Status status) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f702a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
