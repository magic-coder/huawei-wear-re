package com.huawei.p032e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.l;

/* compiled from: IGetbindDeviceCommonCallback */
public abstract class C0805k extends Binder implements C0804j {
    public C0805k() {
        attachInterface(this, "com.huawei.health.IGetbindDeviceCommonCallback");
    }

    public static C0804j m2689a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.health.IGetbindDeviceCommonCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C0804j)) {
            return new l(iBinder);
        }
        return (C0804j) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.health.IGetbindDeviceCommonCallback");
                m2688a(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.health.IGetbindDeviceCommonCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
