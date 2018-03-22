package com.huawei.p032e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IRemoteProxyCallback */
public abstract class C4399n extends Binder implements C4398m {
    private static final String DESCRIPTOR = "com.huawei.health.IRemoteProxyCallback";
    static final int TRANSACTION_requestWearTask = 1;

    public C4399n() {
        attachInterface(this, DESCRIPTOR);
    }

    public static C4398m asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4398m)) {
            return new C4400o(iBinder);
        }
        return (C4398m) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                requestWearTask(parcel.readHashMap(getClass().getClassLoader()));
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
