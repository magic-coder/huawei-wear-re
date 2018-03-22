package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDataClientListener */
public abstract class ae extends Binder implements ad {
    public static ad m21649a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IDataClientListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) {
            return new af(iBinder);
        }
        return (ad) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IDataClientListener");
                mo4494a(parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IDataClientListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
