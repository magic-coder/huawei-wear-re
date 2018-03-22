package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class ap extends Binder implements ao {
    public static ao m623a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ao)) ? new aq(iBinder) : (ao) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
                Account a = mo1767a();
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IAccountAccessor");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
