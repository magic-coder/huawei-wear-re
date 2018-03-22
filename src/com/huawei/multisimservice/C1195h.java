package com.huawei.multisimservice;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IServiceBinder */
class C1195h implements C1193f {
    private IBinder f2614a;

    C1195h(IBinder iBinder) {
        this.f2614a = iBinder;
    }

    public IBinder asBinder() {
        return this.f2614a;
    }

    public IBinder mo2369a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IServiceBinder");
            obtain.writeString(str);
            this.f2614a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
