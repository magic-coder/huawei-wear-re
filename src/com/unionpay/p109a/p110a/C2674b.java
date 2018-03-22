package com.unionpay.p109a.p110a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.a.a.c;

/* compiled from: IVendorTsmCallback */
public abstract class C2674b extends Binder implements C2673a {
    public static C2673a m12779a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C2673a)) {
            return new c(iBinder);
        }
        return (C2673a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Bundle bundle;
                parcel.enforceInterface("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                m12777a(bundle);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
                m12778a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
