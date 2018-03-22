package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class az implements ax {
    private final IBinder f424a;

    az(IBinder iBinder) {
        this.f424a = iBinder;
    }

    public void mo1770a(au auVar, zzj com_google_android_gms_common_internal_zzj) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(auVar != null ? auVar.asBinder() : null);
            if (com_google_android_gms_common_internal_zzj != null) {
                obtain.writeInt(1);
                com_google_android_gms_common_internal_zzj.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f424a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f424a;
    }
}
