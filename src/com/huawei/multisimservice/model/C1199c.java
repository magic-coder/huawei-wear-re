package com.huawei.multisimservice.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IAttachedDeviceMultiSimCallback */
class C1199c implements C1120a {
    private IBinder f2618a;

    C1199c(IBinder iBinder) {
        this.f2618a = iBinder;
    }

    public IBinder asBinder() {
        return this.f2618a;
    }

    public void mo2359a(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
            if (multiSimDeviceInfo != null) {
                obtain.writeInt(1);
                multiSimDeviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2618a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2358a(int i, List<SimInfo> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
            obtain.writeInt(i);
            obtain.writeTypedList(list);
            this.f2618a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2357a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.multisimservice.model.IAttachedDeviceMultiSimCallback");
            obtain.writeInt(i);
            this.f2618a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
