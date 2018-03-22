package com.huawei.p032e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.j;

/* compiled from: IGetbindDeviceCommonCallback */
class C4397l implements j {
    private IBinder f16303a;

    C4397l(IBinder iBinder) {
        this.f16303a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16303a;
    }

    public void m21098a(int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.IGetbindDeviceCommonCallback");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f16303a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
