package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.p014a.C0340a;

class db implements cz {
    private IBinder f683a;

    db(IBinder iBinder) {
        this.f683a = iBinder;
    }

    public IBinder asBinder() {
        return this.f683a;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(i);
            this.f683a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f683a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeLong(j);
            obtain.writeInt(i);
            this.f683a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            this.f683a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void init(C0340a c0340a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeStrongBinder(c0340a != null ? c0340a.asBinder() : null);
            this.f683a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
