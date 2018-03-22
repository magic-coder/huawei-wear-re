package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: IDeviceStateAIDLCallback */
class C5365f implements d {
    private IBinder f19118a;

    C5365f(IBinder iBinder) {
        this.f19118a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19118a;
    }

    public void m25843a(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
            if (deviceInfo != null) {
                obtain.writeInt(1);
                deviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            this.f19118a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m25844b(DeviceInfo deviceInfo, int i, byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
            if (deviceInfo != null) {
                obtain.writeInt(1);
                deviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            this.f19118a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m25842a(DeviceInfo deviceInfo, int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IDeviceStateAIDLCallback");
            if (deviceInfo != null) {
                obtain.writeInt(1);
                deviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f19118a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
