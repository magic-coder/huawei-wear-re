package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IDataOperateListener */
class ai implements ag {
    private IBinder f16761a;

    ai(IBinder iBinder) {
        this.f16761a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16761a;
    }

    public void mo4491a(int i, List list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IDataOperateListener");
            obtain.writeInt(i);
            obtain.writeList(list);
            this.f16761a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
