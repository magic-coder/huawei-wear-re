package com.aps;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILocationProviderService */
public abstract class C3492b extends Binder implements C3491a {
    public static C3491a m17388a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C3491a)) {
            return new C3493c(iBinder);
        }
        return (C3491a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Bundle bundle;
                parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                int a = mo4151a(bundle);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
