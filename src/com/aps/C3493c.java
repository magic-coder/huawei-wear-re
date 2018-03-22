package com.aps;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILocationProviderService */
class C3493c implements C3491a {
    private IBinder f13142a;

    C3493c(IBinder iBinder) {
        this.f13142a = iBinder;
    }

    public IBinder asBinder() {
        return this.f13142a;
    }

    public int mo4151a(Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.amap.api.service.locationprovider.ILocationProviderService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f13142a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            if (obtain2.readInt() != 0) {
                bundle.readFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
            return readInt;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
