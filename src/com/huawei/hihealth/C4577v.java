package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAggregateListenerEx */
public abstract class C4577v extends Binder implements C4576u {
    public static C4576u m21844a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IAggregateListenerEx");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4576u)) {
            return new C4578w(iBinder);
        }
        return (C4576u) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IAggregateListenerEx");
                mo4535a(parcel.readArrayList(getClass().getClassLoader()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IAggregateListenerEx");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
