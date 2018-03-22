package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IUnSubscribeListener */
class ba implements ay {
    private IBinder f16767a;

    ba(IBinder iBinder) {
        this.f16767a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16767a;
    }

    public void mo4489a(boolean z) throws RemoteException {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IUnSubscribeListener");
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.f16767a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
