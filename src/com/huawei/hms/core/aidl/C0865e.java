package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.core.aidl.C0832d.C0833a;

/* compiled from: IAIDLInvoke */
public interface C0865e extends IInterface {

    /* compiled from: IAIDLInvoke */
    public abstract class C0867a extends Binder implements C0865e {

        /* compiled from: IAIDLInvoke */
        class C0866a implements C0865e {
            private IBinder f1362a;

            C0866a(IBinder iBinder) {
                this.f1362a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1362a;
            }

            public void mo2244a(C0862b c0862b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (c0862b != null) {
                        obtain.writeInt(1);
                        c0862b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1362a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2245a(C0862b c0862b, C0832d c0832d) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (c0862b != null) {
                        obtain.writeInt(1);
                        c0862b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0832d != null) {
                        iBinder = c0832d.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f1362a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static C0865e m3044a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0865e)) {
                return new C0866a(iBinder);
            }
            return (C0865e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            C0862b c0862b = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (parcel.readInt() != 0) {
                        c0862b = (C0862b) C0862b.CREATOR.createFromParcel(parcel);
                    }
                    mo2244a(c0862b);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (parcel.readInt() != 0) {
                        c0862b = (C0862b) C0862b.CREATOR.createFromParcel(parcel);
                    }
                    mo2245a(c0862b, C0833a.m2946a(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo2244a(C0862b c0862b) throws RemoteException;

    void mo2245a(C0862b c0862b, C0832d c0832d) throws RemoteException;
}
