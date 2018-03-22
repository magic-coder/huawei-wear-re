package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ISubscribeListener */
class au implements as {
    private IBinder f16765a;

    au(IBinder iBinder) {
        this.f16765a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16765a;
    }

    public void mo4488a(List list, List list2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.ISubscribeListener");
            obtain.writeList(list);
            obtain.writeList(list2);
            this.f16765a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4487a(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.ISubscribeListener");
            obtain.writeInt(i);
            if (hiHealthClient != null) {
                obtain.writeInt(1);
                hiHealthClient.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (hiHealthData != null) {
                obtain.writeInt(1);
                hiHealthData.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeLong(j);
            this.f16765a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
