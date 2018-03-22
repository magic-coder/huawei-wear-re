package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDataReadResultListener */
public abstract class ak extends Binder implements aj {
    public ak() {
        attachInterface(this, "com.huawei.hihealth.IDataReadResultListener");
    }

    public static aj m21629a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IDataReadResultListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof aj)) {
            return new al(iBinder);
        }
        return (aj) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IDataReadResultListener");
                mo4492a(parcel.readArrayList(getClass().getClassLoader()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IDataReadResultListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
