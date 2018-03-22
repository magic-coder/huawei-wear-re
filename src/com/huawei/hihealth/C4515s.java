package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAggregateListener */
public abstract class C4515s extends Binder implements C4514r {
    public C4515s() {
        attachInterface(this, "com.huawei.hihealth.IAggregateListener");
    }

    public static C4514r m21623a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IAggregateListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4514r)) {
            return new C4575t(iBinder);
        }
        return (C4514r) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IAggregateListener");
                mo4490a(parcel.readArrayList(getClass().getClassLoader()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IAggregateListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
