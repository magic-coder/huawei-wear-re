package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IAuthorizationListener */
class C4581z implements C4579x {
    private IBinder f16784a;

    C4581z(IBinder iBinder) {
        this.f16784a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16784a;
    }

    public void mo4536a(List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IAuthorizationListener");
            obtain.writeList(list);
            this.f16784a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
