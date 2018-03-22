package com.cmcc.sso.service;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class C0333c implements C0331a {
    private IBinder f190a;

    C0333c(IBinder iBinder) {
        this.f190a = iBinder;
    }

    public void mo1731a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.cmcc.sso.service.IPCCallback");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f190a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f190a;
    }
}
