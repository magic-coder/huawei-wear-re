package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITransferSleepAndDFXFileCallback */
class C5374t implements r {
    private IBinder f19121a;

    C5374t(IBinder iBinder) {
        this.f19121a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19121a;
    }

    public void onSuccess(int i, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.ITransferSleepAndDFXFileCallback");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f19121a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void onFailure(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.ITransferSleepAndDFXFileCallback");
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f19121a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
