package com.huawei.multisimservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOpenMultiSimCalbcak */
public abstract class C1201e extends Binder implements C1200d {
    public static C1200d m5345a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multisimservice.model.IOpenMultiSimCalbcak");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1200d)) {
            return new f(iBinder);
        }
        return (C1200d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                MultiSimDeviceInfo multiSimDeviceInfo;
                parcel.enforceInterface("com.huawei.multisimservice.model.IOpenMultiSimCalbcak");
                if (parcel.readInt() != 0) {
                    multiSimDeviceInfo = (MultiSimDeviceInfo) MultiSimDeviceInfo.CREATOR.createFromParcel(parcel);
                } else {
                    multiSimDeviceInfo = null;
                }
                m5344a(multiSimDeviceInfo);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.multisimservice.model.IOpenMultiSimCalbcak");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
