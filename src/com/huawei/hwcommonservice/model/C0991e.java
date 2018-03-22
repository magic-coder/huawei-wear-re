package com.huawei.hwcommonservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHWWearCommonCallback */
public abstract class C0991e extends Binder implements C0990d {
    public static C0990d m3603a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwcommonservice.model.IHWWearCommonCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C0990d)) {
            return new f(iBinder);
        }
        return (C0990d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwcommonservice.model.IHWWearCommonCallback");
                m3602a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwcommonservice.model.IHWWearCommonCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
