package com.cmcc.sso.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class C0335e extends Binder implements C0334d {
    public C0335e() {
        attachInterface(this, "com.cmcc.sso.service.ISsoService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.cmcc.sso.service.ISsoService");
                mo1732a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C0332b.m216a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.cmcc.sso.service.ISsoService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
