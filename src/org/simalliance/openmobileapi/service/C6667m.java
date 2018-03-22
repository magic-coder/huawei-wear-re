package org.simalliance.openmobileapi.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceReader */
class C6667m implements C6665k {
    private IBinder f22906a;

    C6667m(IBinder iBinder) {
        this.f22906a = iBinder;
    }

    public IBinder asBinder() {
        return this.f22906a;
    }

    public String mo5544a(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
            this.f22906a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo5545b(SmartcardError smartcardError) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
            this.f22906a.transact(2, obtain, obtain2, 0);
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

    public C6668n mo5546c(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
            this.f22906a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            C6668n a = C6669o.m30006a(obtain2.readStrongBinder());
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return a;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo5547d(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
            this.f22906a.transact(4, obtain, obtain2, 0);
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
}
