package com.huawei.p032e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.e.a;
import com.huawei.e.j;
import com.huawei.hwservicesmgr.datetype.DeviceInfo;
import java.util.List;
import java.util.Map;

/* compiled from: ICallbackInterface */
class C4396i implements C4394g {
    private IBinder f16302a;

    C4396i(IBinder iBinder) {
        this.f16302a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16302a;
    }

    public void mo4451a(C4398m c4398m) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(c4398m != null ? c4398m.asBinder() : null);
            this.f16302a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4458b(C4398m c4398m) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(c4398m != null ? c4398m.asBinder() : null);
            this.f16302a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4455a(Map map) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeMap(map);
            this.f16302a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4454a(List<DeviceInfo> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeTypedList(list);
            this.f16302a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4452a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeString(str);
            this.f16302a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4448a(IBinder iBinder, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f16302a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Map mo4446a(String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f16302a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            Map readHashMap = obtain2.readHashMap(getClass().getClassLoader());
            return readHashMap;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4449a(a aVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f16302a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4450a(j jVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f16302a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4456b(a aVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f16302a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4453a(String str, a aVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeString(str);
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f16302a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4457b(j jVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f16302a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4447a(int i, a aVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.health.ICallbackInterface");
            obtain.writeInt(i);
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.f16302a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
