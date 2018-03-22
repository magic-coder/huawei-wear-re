package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHeartRateStateAIDLCallback */
class C5366i implements g {
    private IBinder f19119a;

    C5366i(IBinder iBinder) {
        this.f19119a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19119a;
    }

    public void m25845a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback");
            obtain.writeInt(i);
            this.f19119a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
