package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

class C0491d implements C0489b {
    private IBinder f506a;

    C0491d(IBinder iBinder) {
        this.f506a = iBinder;
    }

    public void mo1794a(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f506a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f506a;
    }
}
