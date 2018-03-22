package com.huawei.p032e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: IRemoteProxyCallback */
class C4400o implements C4398m {
    private IBinder f16304a;

    C4400o(IBinder iBinder) {
        this.f16304a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16304a;
    }

    public void requestWearTask(Map map) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.IRemoteProxyCallback");
            obtain.writeMap(map);
            this.f16304a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
