package com.huawei.multisimservice.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOpenMultiSimCalbcak */
class C5494f implements d {
    private IBinder f19359a;

    C5494f(IBinder iBinder) {
        this.f19359a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19359a;
    }

    public void m26234a(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.model.IOpenMultiSimCalbcak");
            if (multiSimDeviceInfo != null) {
                obtain.writeInt(1);
                multiSimDeviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f19359a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
