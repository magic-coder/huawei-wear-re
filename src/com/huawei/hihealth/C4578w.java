package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IAggregateListenerEx */
class C4578w implements C4576u {
    private IBinder f16783a;

    C4578w(IBinder iBinder) {
        this.f16783a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16783a;
    }

    public void mo4535a(List list, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IAggregateListenerEx");
            obtain.writeList(list);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f16783a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
