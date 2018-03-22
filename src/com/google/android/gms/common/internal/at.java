package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.p014a.C0340a;

public abstract class at extends Binder implements as {
    public at() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                C0340a a = mo1780a();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                int b = mo1781b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
