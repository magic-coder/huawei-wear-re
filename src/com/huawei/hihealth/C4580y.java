package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAuthorizationListener */
public abstract class C4580y extends Binder implements C4579x {
    public static C4579x m21847a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IAuthorizationListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4579x)) {
            return new C4581z(iBinder);
        }
        return (C4579x) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IAuthorizationListener");
                mo4536a(parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IAuthorizationListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
