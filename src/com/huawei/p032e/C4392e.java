package com.huawei.p032e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBinderInterceptor */
public abstract class C4392e extends Binder implements C4391d {
    public static C4391d m21069a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.health.IBinderInterceptor");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4391d)) {
            return new C4393f(iBinder);
        }
        return (C4391d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.health.IBinderInterceptor");
                IBinder a = mo4445a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.health.IBinderInterceptor");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
