package com.huawei.hwcommonservice.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHWWearCommonCallback */
class C4760f implements d {
    private IBinder f17346a;

    C4760f(IBinder iBinder) {
        this.f17346a = iBinder;
    }

    public IBinder asBinder() {
        return this.f17346a;
    }

    public void m22750a(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwcommonservice.model.IHWWearCommonCallback");
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f17346a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
