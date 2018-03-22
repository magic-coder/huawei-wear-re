package com.huawei.account.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBinderInterceptor */
public abstract class C0634h extends Binder implements C0633g {
    public C0634h() {
        attachInterface(this, "com.huawei.account.aidl.IBinderInterceptor");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.account.aidl.IBinderInterceptor");
                IBinder a = mo2110a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.account.aidl.IBinderInterceptor");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
