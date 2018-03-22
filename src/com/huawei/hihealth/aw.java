package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISupportedTypesListener */
public abstract class aw extends Binder implements av {
    public static av m21736a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.ISupportedTypesListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof av)) {
            return new ax(iBinder);
        }
        return (av) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.ISupportedTypesListener");
                mo4534a(parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.ISupportedTypesListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
