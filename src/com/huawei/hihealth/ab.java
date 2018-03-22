package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICommonListener */
public abstract class ab extends Binder implements aa {
    public ab() {
        attachInterface(this, "com.huawei.hihealth.ICommonListener");
    }

    public static aa m21585a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.ICommonListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof aa)) {
            return new ac(iBinder);
        }
        return (aa) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.ICommonListener");
                mo4485a(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hihealth.ICommonListener");
                mo4486b(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.ICommonListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
