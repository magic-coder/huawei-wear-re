package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITransferSleepAndDFXFileCallback */
public abstract class C1059s extends Binder implements C1057r {
    private static final String DESCRIPTOR = "com.huawei.hwservicesmgr.ITransferSleepAndDFXFileCallback";
    static final int TRANSACTION_onFailure = 2;
    static final int TRANSACTION_onSuccess = 1;

    public C1059s() {
        attachInterface(this, DESCRIPTOR);
    }

    public static C1057r asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1057r)) {
            return new t(iBinder);
        }
        return (C1057r) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                onFailure(parcel.readInt(), parcel.readString());
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
