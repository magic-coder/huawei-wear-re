package org.simalliance.openmobileapi.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardService */
class C6660d implements C6658b {
    private IBinder f22903a;

    C6660d(IBinder iBinder) {
        this.f22903a = iBinder;
    }

    public IBinder asBinder() {
        return this.f22903a;
    }

    public String[] mo5535a(SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardService");
            this.f22903a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String[] createStringArray = obtain2.createStringArray();
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return createStringArray;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C6665k mo5534a(String str, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardService");
            obtain.writeString(str);
            this.f22903a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            C6665k a = C6666l.m29993a(obtain2.readStrongBinder());
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

    public boolean[] mo5536a(String str, byte[] bArr, String[] strArr, C6652e c6652e, SmartcardError smartcardError) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.simalliance.openmobileapi.service.ISmartcardService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            obtain.writeStringArray(strArr);
            obtain.writeStrongBinder(c6652e != null ? c6652e.asBinder() : null);
            this.f22903a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            boolean[] createBooleanArray = obtain2.createBooleanArray();
            if (obtain2.readInt() != 0) {
                smartcardError.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return createBooleanArray;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
