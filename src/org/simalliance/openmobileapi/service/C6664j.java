package org.simalliance.openmobileapi.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceChannel */
class C6664j implements C6662h {
    private IBinder f22905a;

    C6664j(IBinder iBinder) {
        this.f22905a = iBinder;
    }

    public IBinder asBinder() {
        return this.f22905a;
    }

    public void mo5537a(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo5538a() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(2, obtain, obtain2, 0);
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

    public boolean mo5540b() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(3, obtain, obtain2, 0);
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

    public byte[] mo5542c() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C6668n mo5543d() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            C6668n a = C6669o.m30006a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] mo5539a(byte[] bArr, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            obtain.writeByteArray(bArr);
            this.f22905a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return createByteArray;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo5541b(SmartcardError smartcardError) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
            this.f22905a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
