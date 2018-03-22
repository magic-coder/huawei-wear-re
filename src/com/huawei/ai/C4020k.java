package com.huawei.ai;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAuthenticationService */
public abstract class C4020k extends Binder implements C4019j {
    public static C4019j m19802a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4019j)) {
            return new C4021l(iBinder);
        }
        return (C4019j) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        boolean a;
        int[] c;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = mo4338a(C4013h.m19785a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = mo4335a(C4013h.m19785a(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                mo4336a(C4013h.m19785a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                mo4344b(C4013h.m19785a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = mo4345c(C4013h.m19785a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = mo4341a();
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = mo4337a(parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = mo4342b(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 9:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = mo4340a(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                String b = mo4343b(C4013h.m19785a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 11:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = mo4346c(C4013h.m19785a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 12:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = mo4347d(C4013h.m19785a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 13:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                C4012g a2 = C4013h.m19785a(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    a = true;
                } else {
                    a = false;
                }
                a = mo4339a(a2, readInt, a);
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 14:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                long d = mo4348d(C4013h.m19785a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeLong(d);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
