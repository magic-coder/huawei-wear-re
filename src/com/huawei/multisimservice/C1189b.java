package com.huawei.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.multisimservice.model.C1121b;
import com.huawei.multisimservice.model.SimInfo;

/* compiled from: IAttachedDeviceMultiSim */
public abstract class C1189b extends Binder implements C1188a {
    public C1189b() {
        attachInterface(this, "com.huawei.multisimservice.IAttachedDeviceMultiSim");
    }

    public static C1188a m5316a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1188a)) {
            return new C1190c(iBinder);
        }
        return (C1188a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2365a(C1121b.m5013a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2368b(C1121b.m5013a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2363a();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2366a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2364a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                mo2367a(parcel.createTypedArrayList(SimInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.multisimservice.IAttachedDeviceMultiSim");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
