package com.huawei.ae;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IWearConnectService */
public abstract class C3989b extends Binder implements C3988a {
    public static C3988a m19743a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.iconnect.IWearConnectService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C3988a)) {
            return new C3990c(iBinder);
        }
        return (C3988a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.iconnect.IWearConnectService");
                String a = mo4333a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.iconnect.IWearConnectService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
