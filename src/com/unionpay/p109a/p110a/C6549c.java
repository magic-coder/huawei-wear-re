package com.unionpay.p109a.p110a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.a.a.a;

/* compiled from: IVendorTsmCallback */
class C6549c implements a {
    private IBinder f22874a;

    C6549c(IBinder iBinder) {
        this.f22874a = iBinder;
    }

    public IBinder asBinder() {
        return this.f22874a;
    }

    public void m29911a(Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f22874a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m29912a(String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.unionpay.tsm.vendorservice.IVendorTsmCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f22874a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
