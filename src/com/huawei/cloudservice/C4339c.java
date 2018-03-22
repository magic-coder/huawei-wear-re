package com.huawei.cloudservice;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHwIDCallback */
public interface C4339c extends IInterface {

    /* compiled from: IHwIDCallback */
    public abstract class C4341a extends Binder implements C4339c {

        /* compiled from: IHwIDCallback */
        class C4340a implements C4339c {
            private IBinder f16134a;

            C4340a(IBinder iBinder) {
                this.f16134a = iBinder;
            }

            public IBinder asBinder() {
                return this.f16134a;
            }

            public void mo4422a(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.IHwIDCallback");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16134a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4421a(int i, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.IHwIDCallback");
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16134a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4420a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.IHwIDCallback");
                    obtain.writeInt(i);
                    this.f16134a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4423b(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.IHwIDCallback");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16134a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C4341a() {
            attachInterface(this, "com.huawei.cloudservice.IHwIDCallback");
        }

        public static C4339c m20882a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.cloudservice.IHwIDCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C4339c)) {
                return new C4340a(iBinder);
            }
            return (C4339c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            int readInt;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.cloudservice.IHwIDCallback");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo4422a(readInt, bundle);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    Intent intent;
                    parcel.enforceInterface("com.huawei.cloudservice.IHwIDCallback");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    mo4421a(readInt, intent);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.cloudservice.IHwIDCallback");
                    mo4420a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.cloudservice.IHwIDCallback");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo4423b(readInt, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.cloudservice.IHwIDCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo4420a(int i) throws RemoteException;

    void mo4421a(int i, Intent intent) throws RemoteException;

    void mo4422a(int i, Bundle bundle) throws RemoteException;

    void mo4423b(int i, Bundle bundle) throws RemoteException;
}
