package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class al implements aj {
    private IBinder f952a;

    al(IBinder iBinder) {
        this.f952a = iBinder;
    }

    public void mo1952a(int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f952a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f952a;
    }
}
