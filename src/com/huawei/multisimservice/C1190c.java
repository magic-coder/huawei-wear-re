package com.huawei.multisimservice;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.multisimservice.model.C1120a;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* compiled from: IAttachedDeviceMultiSim */
class C1190c implements C1188a {
    private IBinder f2613a;

    C1190c(IBinder iBinder) {
        this.f2613a = iBinder;
    }

    public IBinder asBinder() {
        return this.f2613a;
    }

    public void mo2365a(C1120a c1120a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            obtain.writeStrongBinder(c1120a != null ? c1120a.asBinder() : null);
            this.f2613a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2368b(C1120a c1120a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            obtain.writeStrongBinder(c1120a != null ? c1120a.asBinder() : null);
            this.f2613a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2363a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            this.f2613a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2366a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            obtain.writeString(str);
            this.f2613a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2364a(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            obtain.writeInt(i);
            obtain.writeString(str);
            this.f2613a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2367a(List<SimInfo> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.IAttachedDeviceMultiSim");
            obtain.writeTypedList(list);
            this.f2613a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
