package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAIDLCallback */
public interface C0832d extends IInterface {

    /* compiled from: IAIDLCallback */
    public abstract class C0833a extends Binder implements C0832d {

        /* compiled from: IAIDLCallback */
        class C0864a implements C0832d {
            private IBinder f1361a;

            C0864a(IBinder iBinder) {
                this.f1361a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1361a;
            }

            public void mo2230a(C0862b c0862b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLCallback");
                    if (c0862b != null) {
                        obtain.writeInt(1);
                        c0862b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1361a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0833a() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static C0832d m2946a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0832d)) {
                return new C0864a(iBinder);
            }
            return (C0832d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    C0862b c0862b;
                    parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
                    if (parcel.readInt() != 0) {
                        c0862b = (C0862b) C0862b.CREATOR.createFromParcel(parcel);
                    } else {
                        c0862b = null;
                    }
                    mo2230a(c0862b);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo2230a(C0862b c0862b) throws RemoteException;
}
