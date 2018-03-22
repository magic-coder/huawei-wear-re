package com.huawei.hwcommonservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHWSleepDataCallback */
public abstract class C0989b extends Binder implements C0988a {
    public static C0988a m3601a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwcommonservice.model.IHWSleepDataCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C0988a)) {
            return new c(iBinder);
        }
        return (C0988a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwcommonservice.model.IHWSleepDataCallback");
                m3600a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwcommonservice.model.IHWSleepDataCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
