package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ISupportedTypesListener */
class ax implements av {
    private IBinder f16766a;

    ax(IBinder iBinder) {
        this.f16766a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16766a;
    }

    public void mo4534a(List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.ISupportedTypesListener");
            obtain.writeList(list);
            this.f16766a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
