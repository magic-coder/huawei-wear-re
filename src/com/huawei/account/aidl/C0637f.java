package com.huawei.account.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAccountAidlInterface */
public abstract class C0637f extends Binder implements C0636e {
    public C0637f() {
        attachInterface(this, "com.huawei.account.aidl.IAccountAidlInterface");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.account.aidl.IAccountAidlInterface");
                AccountAidlInfo a = mo2111a();
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.account.aidl.IAccountAidlInterface");
                mo2112b();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.account.aidl.IAccountAidlInterface");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
