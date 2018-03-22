package com.huawei.p032e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.a;

/* compiled from: IBaseCommonCallback */
class C4390c implements a {
    private IBinder f16300a;

    C4390c(IBinder iBinder) {
        this.f16300a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16300a;
    }

    public void m21067a(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.IBaseCommonCallback");
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f16300a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
