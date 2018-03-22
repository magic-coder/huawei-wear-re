package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p032e.C0802a;
import com.huawei.p032e.C0804j;
import java.util.List;

/* compiled from: IPhoneServiceAIDL */
class C1056o implements C1054m {
    private IBinder f2074a;

    C1056o(IBinder iBinder) {
        this.f2074a = iBinder;
    }

    public IBinder asBinder() {
        return this.f2074a;
    }

    public void mo2321a(IBinder iBinder, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f2074a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public List<DeviceInfo> mo2317a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            this.f2074a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            List<DeviceInfo> createTypedArrayList = obtain2.createTypedArrayList(DeviceInfo.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public DeviceCapability mo2333b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            DeviceCapability deviceCapability;
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            this.f2074a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                deviceCapability = (DeviceCapability) DeviceCapability.CREATOR.createFromParcel(obtain2);
            } else {
                deviceCapability = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return deviceCapability;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2326a(C1048d c1048d) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(c1048d != null ? c1048d.asBinder() : null);
            this.f2074a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2336b(C1048d c1048d) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(c1048d != null ? c1048d.asBinder() : null);
            this.f2074a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2325a(DeviceCommand deviceCommand) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            if (deviceCommand != null) {
                obtain.writeInt(1);
                deviceCommand.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2074a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2320a(int i, String str, List<String> list, C1046a c1046a, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeStringList(list);
            obtain.writeStrongBinder(c1046a != null ? c1046a.asBinder() : null);
            obtain.writeString(str2);
            this.f2074a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2331a(List<DeviceInfo> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeTypedList(list);
            this.f2074a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2335b(DeviceCommand deviceCommand) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            if (deviceCommand != null) {
                obtain.writeInt(1);
                deviceCommand.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2074a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2329a(String str, String str2, String str3, int i, C1052j c1052j) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeInt(i);
            obtain.writeStrongBinder(c1052j != null ? c1052j.asBinder() : null);
            this.f2074a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2337c() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            this.f2074a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2327a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeString(str);
            this.f2074a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2324a(TransferFileInfo transferFileInfo, C1057r c1057r) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            if (transferFileInfo != null) {
                obtain.writeInt(1);
                transferFileInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(c1057r != null ? c1057r.asBinder() : null);
            this.f2074a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2332a(boolean z) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f2074a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo2338d() throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            this.f2074a.transact(15, obtain, obtain2, 0);
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

    public void mo2318a(int i, int i2, C1050g c1050g) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeStrongBinder(c1050g != null ? c1050g.asBinder() : null);
            this.f2074a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2323a(C0804j c0804j) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(c0804j != null ? c0804j.asBinder() : null);
            this.f2074a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2322a(C0802a c0802a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(c0802a != null ? c0802a.asBinder() : null);
            this.f2074a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2334b(C0802a c0802a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeStrongBinder(c0802a != null ? c0802a.asBinder() : null);
            this.f2074a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2328a(String str, C0802a c0802a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeString(str);
            obtain.writeStrongBinder(c0802a != null ? c0802a.asBinder() : null);
            this.f2074a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2319a(int i, C0802a c0802a) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeInt(i);
            obtain.writeStrongBinder(c0802a != null ? c0802a.asBinder() : null);
            this.f2074a.transact(21, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2330a(String str, boolean z, C0802a c0802a) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
            obtain.writeString(str);
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(c0802a != null ? c0802a.asBinder() : null);
            this.f2074a.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
