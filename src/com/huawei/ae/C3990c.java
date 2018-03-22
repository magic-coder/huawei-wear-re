package com.huawei.ae;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IWearConnectService */
class C3990c implements C3988a {
    private IBinder f15240a;

    C3990c(IBinder iBinder) {
        this.f15240a = iBinder;
    }

    public IBinder asBinder() {
        return this.f15240a;
    }

    public String mo4333a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.iconnect.IWearConnectService");
            this.f15240a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
