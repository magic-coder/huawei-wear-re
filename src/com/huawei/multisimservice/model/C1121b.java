package com.huawei.multisimservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAttachedDeviceMultiSimCallback */
public abstract class C1121b extends Binder implements C1120a {
    public C1121b() {
        attachInterface(this, "com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
    }

    public static C1120a m5013a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1120a)) {
            return new C1199c(iBinder);
        }
        return (C1120a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                MultiSimDeviceInfo multiSimDeviceInfo;
                parcel.enforceInterface("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
                if (parcel.readInt() != 0) {
                    multiSimDeviceInfo = (MultiSimDeviceInfo) MultiSimDeviceInfo.CREATOR.createFromParcel(parcel);
                } else {
                    multiSimDeviceInfo = null;
                }
                mo2359a(multiSimDeviceInfo);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
                mo2358a(parcel.readInt(), parcel.createTypedArrayList(SimInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
                mo2357a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
