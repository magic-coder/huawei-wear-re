package com.sina.p526a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: RemoteSSO */
public abstract class C6191b extends Binder implements C6190a {
    public static C6190a m28657a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6190a)) {
            return new C6192c(iBinder);
        }
        return (C6190a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = mo5213a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = mo5214b();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 3:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                a = mo5215c();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.sina.sso.RemoteSSO");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
