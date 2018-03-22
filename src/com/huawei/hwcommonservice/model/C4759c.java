package com.huawei.hwcommonservice.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHWSleepDataCallback */
class C4759c implements a {
    private IBinder f17345a;

    C4759c(IBinder iBinder) {
        this.f17345a = iBinder;
    }

    public IBinder asBinder() {
        return this.f17345a;
    }

    public void m22749a(int i, int i2, int i3, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwcommonservice.model.IHWSleepDataCallback");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            obtain.writeString(str);
            this.f17345a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
