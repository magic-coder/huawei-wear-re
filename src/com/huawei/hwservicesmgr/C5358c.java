package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAddDeviceStateAIDLCallback */
class C5358c implements a {
    private IBinder f19104a;

    C5358c(IBinder iBinder) {
        this.f19104a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19104a;
    }

    public void m25815a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IAddDeviceStateAIDLCallback");
            obtain.writeInt(i);
            this.f19104a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
