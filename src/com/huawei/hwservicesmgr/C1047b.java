package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAddDeviceStateAIDLCallback */
public abstract class C1047b extends Binder implements C1046a {
    public C1047b() {
        attachInterface(this, "com.huawei.hwservicesmgr.IAddDeviceStateAIDLCallback");
    }

    public static C1046a m4415a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwservicesmgr.IAddDeviceStateAIDLCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1046a)) {
            return new c(iBinder);
        }
        return (C1046a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IAddDeviceStateAIDLCallback");
                mo2634a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.IAddDeviceStateAIDLCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
