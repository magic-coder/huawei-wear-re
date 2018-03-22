package com.huawei.ai;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAuthenticationService */
class C4021l implements C4019j {
    private IBinder f15305a;

    C4021l(IBinder iBinder) {
        this.f15305a = iBinder;
    }

    public IBinder asBinder() {
        return this.f15305a;
    }

    public boolean mo4338a(C4012g c4012g, int i) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeInt(i);
            this.f15305a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo4335a(C4012g c4012g, int[] iArr, byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeIntArray(iArr);
            obtain.writeByteArray(bArr);
            this.f15305a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4336a(C4012g c4012g) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            this.f15305a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4344b(C4012g c4012g) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            this.f15305a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int[] mo4345c(C4012g c4012g) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            this.f15305a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int[] mo4341a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            this.f15305a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4337a(int i) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeInt(i);
            this.f15305a.transact(7, obtain, obtain2, 0);
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

    public int mo4342b(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeInt(i);
            this.f15305a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4340a(String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeString(str);
            this.f15305a.transact(9, obtain, obtain2, 0);
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

    public String mo4343b(C4012g c4012g, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeInt(i);
            this.f15305a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int[] mo4346c(C4012g c4012g, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeInt(i);
            this.f15305a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo4347d(C4012g c4012g, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeInt(i);
            this.f15305a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4339a(C4012g c4012g, int i, boolean z) throws RemoteException {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            int i2;
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            obtain.writeInt(i);
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            obtain.writeInt(i2);
            this.f15305a.transact(13, obtain, obtain2, 0);
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

    public long mo4348d(C4012g c4012g) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(c4012g != null ? c4012g.asBinder() : null);
            this.f15305a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
