package com.huawei.p032e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.c;

/* compiled from: IBaseCommonCallback */
public abstract class C0803b extends Binder implements C0802a {
    public C0803b() {
        attachInterface(this, "com.huawei.health.IBaseCommonCallback");
    }

    public static C0802a m2687a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.health.IBaseCommonCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C0802a)) {
            return new c(iBinder);
        }
        return (C0802a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.health.IBaseCommonCallback");
                m2686a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.health.IBaseCommonCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
