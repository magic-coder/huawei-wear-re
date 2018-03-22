package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHeartRateStateAIDLCallback */
public abstract class C1051h extends Binder implements C1050g {
    public static C1050g m4421a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1050g)) {
            return new i(iBinder);
        }
        return (C1050g) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback");
                m4420a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.IHeartRateStateAIDLCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
