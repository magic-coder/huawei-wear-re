package com.huawei.p032e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.b;
import com.huawei.e.k;
import com.huawei.hwservicesmgr.datetype.DeviceInfo;
import java.util.Map;

/* compiled from: ICallbackInterface */
public abstract class C4395h extends Binder implements C4394g {
    public static C4394g m21084a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.health.ICallbackInterface");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4394g)) {
            return new C4396i(iBinder);
        }
        return (C4394g) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4451a(C4399n.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4458b(C4399n.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                boolean a = mo4455a(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4454a(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4452a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4448a(parcel.readStrongBinder(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                Map a2 = mo4446a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeMap(a2);
                return true;
            case 8:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4449a(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4450a(k.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4456b(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4453a(parcel.readString(), b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4457b(k.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.huawei.health.ICallbackInterface");
                mo4447a(parcel.readInt(), b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.health.ICallbackInterface");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
