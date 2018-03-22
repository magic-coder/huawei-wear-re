package com.unionpay.p109a.p110a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IVendorTsmService */
class C2675f implements C1206d {
    private IBinder f9086a;

    C2675f(IBinder iBinder) {
        this.f9086a = iBinder;
    }

    public IBinder asBinder() {
        return this.f9086a;
    }

    public void getCPLC(C2673a c2673a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmService");
            obtain.writeStrongBinder(c2673a != null ? c2673a.asBinder() : null);
            this.f9086a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void getDefaultCard(C2673a c2673a, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmService");
            obtain.writeStrongBinder(c2673a != null ? c2673a.asBinder() : null);
            obtain.writeString(str);
            this.f9086a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void setDefaultCard(C2673a c2673a, String str, Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmService");
            obtain.writeStrongBinder(c2673a != null ? c2673a.asBinder() : null);
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f9086a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void createSSD(C2673a c2673a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmService");
            obtain.writeStrongBinder(c2673a != null ? c2673a.asBinder() : null);
            this.f9086a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
