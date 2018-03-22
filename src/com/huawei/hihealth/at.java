package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISubscribeListener */
public abstract class at extends Binder implements as {
    public at() {
        attachInterface(this, "com.huawei.hihealth.ISubscribeListener");
    }

    public static as m21590a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.ISubscribeListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof as)) {
            return new au(iBinder);
        }
        return (as) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hihealth.ISubscribeListener");
                ClassLoader classLoader = getClass().getClassLoader();
                mo4488a(parcel.readArrayList(classLoader), parcel.readArrayList(classLoader));
                parcel2.writeNoException();
                return true;
            case 2:
                HiHealthClient hiHealthClient;
                HiHealthData hiHealthData;
                parcel.enforceInterface("com.huawei.hihealth.ISubscribeListener");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    hiHealthClient = (HiHealthClient) HiHealthClient.CREATOR.createFromParcel(parcel);
                } else {
                    hiHealthClient = null;
                }
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    hiHealthData = (HiHealthData) HiHealthData.CREATOR.createFromParcel(parcel);
                } else {
                    hiHealthData = null;
                }
                mo4487a(readInt, hiHealthClient, readString, hiHealthData, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.ISubscribeListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
