package com.huawei.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IServiceBinder */
public abstract class C1194g extends Binder implements C1193f {
    public C1194g() {
        attachInterface(this, "com.huawei.multisimservice.IServiceBinder");
    }

    public static C1193f m5328a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multisimservice.IServiceBinder");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1193f)) {
            return new C1195h(iBinder);
        }
        return (C1193f) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.multisimservice.IServiceBinder");
                IBinder a = mo2369a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.multisimservice.IServiceBinder");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
