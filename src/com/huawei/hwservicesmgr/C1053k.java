package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IOTAResultAIDLCallback */
public abstract class C1053k extends Binder implements C1052j {
    public C1053k() {
        attachInterface(this, "com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
    }

    public static C1052j m4425a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1052j)) {
            return new l(iBinder);
        }
        return (C1052j) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
                mo2630a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
                mo2631a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
                mo2632b(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.IOTAResultAIDLCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
