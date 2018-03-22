package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class ak extends Binder implements aj {
    public ak() {
        attachInterface(this, "com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    }

    public static aj m1806a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aj)) ? new al(iBinder) : (aj) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
                mo1952a(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
