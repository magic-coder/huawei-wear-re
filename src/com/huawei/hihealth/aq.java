package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IRegisterClientListener */
public abstract class aq extends Binder implements ap {
    public aq() {
        attachInterface(this, "com.huawei.hihealth.IRegisterClientListener");
    }

    public static ap m21632a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IRegisterClientListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ap)) {
            return new ar(iBinder);
        }
        return (ap) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                HiHealthClient hiHealthClient;
                parcel.enforceInterface("com.huawei.hihealth.IRegisterClientListener");
                if (parcel.readInt() != 0) {
                    hiHealthClient = (HiHealthClient) HiHealthClient.CREATOR.createFromParcel(parcel);
                } else {
                    hiHealthClient = null;
                }
                mo4493a(hiHealthClient);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IRegisterClientListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
