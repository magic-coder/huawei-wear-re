package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IDataClientListener */
class af implements ad {
    private IBinder f16760a;

    af(IBinder iBinder) {
        this.f16760a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16760a;
    }

    public void mo4494a(List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IDataClientListener");
            obtain.writeList(list);
            this.f16760a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
