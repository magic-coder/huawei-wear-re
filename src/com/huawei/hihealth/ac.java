package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ICommonListener */
class ac implements aa {
    private IBinder f16759a;

    ac(IBinder iBinder) {
        this.f16759a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16759a;
    }

    public void mo4485a(int i, List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.ICommonListener");
            obtain.writeInt(i);
            obtain.writeList(list);
            this.f16759a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4486b(int i, List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.ICommonListener");
            obtain.writeInt(i);
            obtain.writeList(list);
            this.f16759a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
