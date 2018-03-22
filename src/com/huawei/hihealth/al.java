package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IDataReadResultListener */
class al implements aj {
    private IBinder f16762a;

    al(IBinder iBinder) {
        this.f16762a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16762a;
    }

    public void mo4492a(List list, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IDataReadResultListener");
            obtain.writeList(list);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f16762a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
