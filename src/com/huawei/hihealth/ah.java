package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDataOperateListener */
public abstract class ah extends Binder implements ag {
    public ah() {
        attachInterface(this, "com.huawei.hihealth.IDataOperateListener");
    }

    public static ag m21626a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IDataOperateListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ag)) {
            return new ai(iBinder);
        }
        return (ag) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IDataOperateListener");
                mo4491a(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IDataOperateListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
