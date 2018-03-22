package com.huawei.ai;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAuthenticationClient */
public abstract class C4013h extends Binder implements C4012g {
    public C4013h() {
        attachInterface(this, "com.huawei.securitymgr.IAuthenticationClient");
    }

    public static C4012g m19785a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationClient");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4012g)) {
            return new C4018i(iBinder);
        }
        return (C4012g) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationClient");
                mo4334a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.securitymgr.IAuthenticationClient");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
