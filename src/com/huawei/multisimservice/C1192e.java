package com.huawei.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.multisimservice.model.C1201e;

/* compiled from: IOpenMultiSim */
public abstract class C1192e extends Binder implements C1191d {
    public C1192e() {
        attachInterface(this, "com.huawei.multisimservice.IOpenMultiSim");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.multisimservice.IOpenMultiSim");
                mo2371a(C1201e.m5345a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.multisimservice.IOpenMultiSim");
                mo2373b(C1201e.m5345a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.multisimservice.IOpenMultiSim");
                mo2370a();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.multisimservice.IOpenMultiSim");
                mo2372a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.multisimservice.IOpenMultiSim");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
