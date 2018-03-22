package com.huawei.cloudservice;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.cloudservice.C4339c.C4341a;

/* compiled from: ICloudAccount */
public interface C4336b extends IInterface {

    /* compiled from: ICloudAccount */
    public abstract class C4338a extends Binder implements C4336b {

        /* compiled from: ICloudAccount */
        class C4337a implements C4336b {
            private IBinder f16133a;

            C4337a(IBinder iBinder) {
                this.f16133a = iBinder;
            }

            public IBinder asBinder() {
                return this.f16133a;
            }

            public void mo4416a(String str, Bundle bundle, C4339c c4339c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.ICloudAccount");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c4339c != null ? c4339c.asBinder() : null);
                    this.f16133a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int mo4415a(Intent intent, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.ICloudAccount");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f16133a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4418a(String str, String str2, String str3, C4339c c4339c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.ICloudAccount");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(c4339c != null ? c4339c.asBinder() : null);
                    this.f16133a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4417a(String str, String str2, Bundle bundle, C4339c c4339c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.ICloudAccount");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c4339c != null ? c4339c.asBinder() : null);
                    this.f16133a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo4419b(String str, String str2, Bundle bundle, C4339c c4339c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.cloudservice.ICloudAccount");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c4339c != null ? c4339c.asBinder() : null);
                    this.f16133a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C4336b m20873a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.cloudservice.ICloudAccount");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C4336b)) {
                return new C4337a(iBinder);
            }
            return (C4336b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            String readString;
            String readString2;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.cloudservice.ICloudAccount");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo4416a(readString, bundle, C4341a.m20882a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    Intent intent;
                    parcel.enforceInterface("com.huawei.cloudservice.ICloudAccount");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    int a = mo4415a(intent, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.cloudservice.ICloudAccount");
                    mo4418a(parcel.readString(), parcel.readString(), parcel.readString(), C4341a.m20882a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.cloudservice.ICloudAccount");
                    readString = parcel.readString();
                    readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo4417a(readString, readString2, bundle, C4341a.m20882a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.cloudservice.ICloudAccount");
                    readString = parcel.readString();
                    readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo4419b(readString, readString2, bundle, C4341a.m20882a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.cloudservice.ICloudAccount");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int mo4415a(Intent intent, int i) throws RemoteException;

    void mo4416a(String str, Bundle bundle, C4339c c4339c) throws RemoteException;

    void mo4417a(String str, String str2, Bundle bundle, C4339c c4339c) throws RemoteException;

    void mo4418a(String str, String str2, String str3, C4339c c4339c) throws RemoteException;

    void mo4419b(String str, String str2, Bundle bundle, C4339c c4339c) throws RemoteException;
}
