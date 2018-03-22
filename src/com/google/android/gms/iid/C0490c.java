package com.google.android.gms.iid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class C0490c extends Binder implements C0489b {
    public static C0489b m848a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0489b)) ? new C0491d(iBinder) : (C0489b) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
                mo1794a(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.iid.IMessengerCompat");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
