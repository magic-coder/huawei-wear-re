package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IRegisterClientListener */
class ar implements ap {
    private IBinder f16764a;

    ar(IBinder iBinder) {
        this.f16764a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16764a;
    }

    public void mo4493a(HiHealthClient hiHealthClient) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IRegisterClientListener");
            if (hiHealthClient != null) {
                obtain.writeInt(1);
                hiHealthClient.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f16764a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
