package com.huawei.hwcommonservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IServiceBinder */
public abstract class C0982g extends Binder implements C0981f {
    public C0982g() {
        attachInterface(this, "com.huawei.hwcommonservice.IServiceBinder");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwcommonservice.IServiceBinder");
                IBinder a = mo2306a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwcommonservice.IServiceBinder");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
