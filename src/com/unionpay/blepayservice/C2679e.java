package com.unionpay.blepayservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IBLETransCMDService */
public abstract class C2679e extends Binder implements C2678d {
    public C2679e() {
        attachInterface(this, "com.unionpay.blepayservice.IBLETransCMDService");
    }

    public static C2678d m12793a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.blepayservice.IBLETransCMDService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C2678d)) {
            return new C2680f(iBinder);
        }
        return (C2678d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLETransCMDService");
                int a = mo2921a();
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 2:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLETransCMDService");
                boolean b = mo2923b();
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("com.unionpay.blepayservice.IBLETransCMDService");
                byte[] a2 = mo2922a(parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeByteArray(a2);
                return true;
            case 1598968902:
                parcel2.writeString("com.unionpay.blepayservice.IBLETransCMDService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
