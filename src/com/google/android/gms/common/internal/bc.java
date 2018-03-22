package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class bc implements ba {
    private IBinder f426a;

    bc(IBinder iBinder) {
        this.f426a = iBinder;
    }

    public void mo1771a(zzaf com_google_android_gms_common_internal_zzaf) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (com_google_android_gms_common_internal_zzaf != null) {
                obtain.writeInt(1);
                com_google_android_gms_common_internal_zzaf.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f426a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f426a;
    }
}
