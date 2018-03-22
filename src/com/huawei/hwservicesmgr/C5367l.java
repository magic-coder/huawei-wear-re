package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOTAResultAIDLCallback */
class C5367l implements j {
    private IBinder f19120a;

    C5367l(IBinder iBinder) {
        this.f19120a = iBinder;
    }

    public IBinder asBinder() {
        return this.f19120a;
    }

    public void m25846a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
            obtain.writeInt(i);
            this.f19120a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m25847a(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f19120a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m25848b(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
            obtain.writeInt(i);
            this.f19120a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
