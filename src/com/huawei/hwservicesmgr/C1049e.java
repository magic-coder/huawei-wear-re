package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: IDeviceStateAIDLCallback */
public abstract class C1049e extends Binder implements C1048d {
    public C1049e() {
        attachInterface(this, "com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
    }

    public static C1048d m4419a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1048d)) {
            return new f(iBinder);
        }
        return (C1048d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        DeviceInfo deviceInfo = null;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
                if (parcel.readInt() != 0) {
                    deviceInfo = (DeviceInfo) DeviceInfo.CREATOR.createFromParcel(parcel);
                }
                m4417a(deviceInfo, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
                if (parcel.readInt() != 0) {
                    deviceInfo = (DeviceInfo) DeviceInfo.CREATOR.createFromParcel(parcel);
                }
                m4418b(deviceInfo, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
                if (parcel.readInt() != 0) {
                    deviceInfo = (DeviceInfo) DeviceInfo.CREATOR.createFromParcel(parcel);
                }
                m4416a(deviceInfo, parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
