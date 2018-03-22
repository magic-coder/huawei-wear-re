package com.unionpay.p109a.p110a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IVendorTsmService */
public abstract class C1207e extends Binder implements C1206d {
    private static final String DESCRIPTOR = "com.unionpay.tsm.vendorservice.IVendorTsmService";
    static final int TRANSACTION_createSSD = 4;
    static final int TRANSACTION_getCPLC = 1;
    static final int TRANSACTION_getDefaultCard = 2;
    static final int TRANSACTION_setDefaultCard = 3;

    public C1207e() {
        attachInterface(this, DESCRIPTOR);
    }

    public static C1206d asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1206d)) {
            return new C2675f(iBinder);
        }
        return (C1206d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                getCPLC(C2674b.m12779a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                getDefaultCard(C2674b.m12779a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                Bundle bundle;
                parcel.enforceInterface(DESCRIPTOR);
                C2673a a = C2674b.m12779a(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                setDefaultCard(a, readString, bundle);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                createSSD(C2674b.m12779a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
