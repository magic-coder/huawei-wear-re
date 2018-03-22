package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IUnSubscribeListener */
public abstract class az extends Binder implements ay {
    public az() {
        attachInterface(this, "com.huawei.hihealth.IUnSubscribeListener");
    }

    public static ay m21620a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IUnSubscribeListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ay)) {
            return new ba(iBinder);
        }
        return (ay) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.IUnSubscribeListener");
                mo4489a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IUnSubscribeListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
