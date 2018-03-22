package com.sina.p526a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: RemoteSSO */
class C6192c implements C6190a {
    private IBinder f21704a;

    C6192c(IBinder iBinder) {
        this.f21704a = iBinder;
    }

    public IBinder asBinder() {
        return this.f21704a;
    }

    public String mo5213a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f21704a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String mo5214b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f21704a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String mo5215c() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f21704a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
