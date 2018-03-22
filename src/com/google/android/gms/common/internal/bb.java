package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class bb extends Binder implements ba {
    public static ba m641a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ba)) ? new bc(iBinder) : (ba) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                mo1771a(parcel.readInt() != 0 ? (zzaf) zzaf.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
