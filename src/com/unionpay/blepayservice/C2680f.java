package com.unionpay.blepayservice;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBLETransCMDService */
class C2680f implements C2678d {
    private IBinder f9091a;

    C2680f(IBinder iBinder) {
        this.f9091a = iBinder;
    }

    public IBinder asBinder() {
        return this.f9091a;
    }

    public int mo2921a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.blepayservice.IBLETransCMDService");
            this.f9091a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo2923b() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.blepayservice.IBLETransCMDService");
            this.f9091a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] mo2922a(byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.blepayservice.IBLETransCMDService");
            obtain.writeByteArray(bArr);
            this.f9091a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
