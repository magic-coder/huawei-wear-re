package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISilenceOTAAIDLCallback */
public abstract class C5369q extends Binder implements C5368p {
    public C5369q() {
        attachInterface(this, "com.huawei.hwservicesmgr.ISilenceOTAAIDLCallback");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.ISilenceOTAAIDLCallback");
                m25849a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.ISilenceOTAAIDLCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
