package com.cmcc.sso.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C0332b extends Binder implements C0331a {
    public static C0331a m216a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cmcc.sso.service.IPCCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0331a)) ? new C0333c(iBinder) : (C0331a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.cmcc.sso.service.IPCCallback");
                mo1731a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.cmcc.sso.service.IPCCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
