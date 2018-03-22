package com.unionpay.blepayservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBLEService */
public abstract class C2677c extends Binder implements C2676b {
    public C2677c() {
        attachInterface(this, "com.unionpay.blepayservice.IBLEService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int a;
        String b;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                a = mo2924a();
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 2:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                Channel a2 = mo2926a(parcel.createByteArray());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 3:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                a = mo2925a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 4:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                b = mo2927b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 5:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                b = mo2928c();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 6:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLEService");
                b = mo2929d();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 1598968902:
                parcel2.writeString("com.unionpay.blepayservice.IBLEService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
