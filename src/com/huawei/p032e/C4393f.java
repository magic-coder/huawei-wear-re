package com.huawei.p032e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBinderInterceptor */
class C4393f implements C4391d {
    private IBinder f16301a;

    C4393f(IBinder iBinder) {
        this.f16301a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16301a;
    }

    public IBinder mo4445a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.IBinderInterceptor");
            obtain.writeString(str);
            this.f16301a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
