package com.huawei.hwcommonservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwcommonservice.model.C0989b;
import com.huawei.hwcommonservice.model.C0991e;

/* compiled from: IHWCoreSleepAPI */
public abstract class C0985e extends Binder implements C0984d {
    public C0985e() {
        attachInterface(this, "com.huawei.hwcommonservice.IHWCoreSleepAPI");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwcommonservice.IHWCoreSleepAPI");
                mo2309a(C0991e.m3603a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hwcommonservice.IHWCoreSleepAPI");
                mo2307a(parcel.readLong(), parcel.readLong(), C0989b.m3601a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.hwcommonservice.IHWCoreSleepAPI");
                mo2308a(parcel.readLong(), parcel.readLong(), C0991e.m3603a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.hwcommonservice.IHWCoreSleepAPI");
                mo2310b(parcel.readLong(), parcel.readLong(), C0989b.m3601a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwcommonservice.IHWCoreSleepAPI");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
