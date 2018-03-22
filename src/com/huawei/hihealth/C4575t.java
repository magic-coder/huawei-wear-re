package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IAggregateListener */
class C4575t implements C4514r {
    private IBinder f16782a;

    C4575t(IBinder iBinder) {
        this.f16782a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16782a;
    }

    public void mo4490a(List list, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IAggregateListener");
            obtain.writeList(list);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f16782a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
