package com.huawei.ai;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAuthenticationClient */
class C4018i implements C4012g {
    private IBinder f15304a;

    C4018i(IBinder iBinder) {
        this.f15304a = iBinder;
    }

    public IBinder asBinder() {
        return this.f15304a;
    }

    public void mo4334a(int i, int i2, int i3, byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationClient");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            obtain.writeByteArray(bArr);
            this.f15304a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
