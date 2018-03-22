package org.simalliance.openmobileapi.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceSession */
class C6670p implements C6668n {
    private IBinder f22907a;

    C6670p(IBinder iBinder) {
        this.f22907a = iBinder;
    }

    public IBinder asBinder() {
        return this.f22907a;
    }

    public C6665k mo5550a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            this.f22907a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            C6665k a = C6666l.m29993a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public byte[] mo5554b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            this.f22907a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo5551a(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            this.f22907a.transact(3, obtain, obtain2, 0);
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

    public void mo5553b(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            this.f22907a.transact(4, obtain, obtain2, 0);
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

    public boolean mo5555c() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            this.f22907a.transact(5, obtain, obtain2, 0);
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

    public C6662h mo5548a(C6652e c6652e, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            obtain.writeStrongBinder(c6652e != null ? c6652e.asBinder() : null);
            this.f22907a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            C6662h a = C6663i.m29981a(obtain2.readStrongBinder());
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

    public C6662h mo5549a(byte[] bArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            obtain.writeByteArray(bArr);
            obtain.writeStrongBinder(c6652e != null ? c6652e.asBinder() : null);
            this.f22907a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            C6662h a = C6663i.m29981a(obtain2.readStrongBinder());
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

    public C6662h mo5552b(byte[] bArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
            obtain.writeByteArray(bArr);
            obtain.writeStrongBinder(c6652e != null ? c6652e.asBinder() : null);
            this.f22907a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            C6662h a = C6663i.m29981a(obtain2.readStrongBinder());
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
}
