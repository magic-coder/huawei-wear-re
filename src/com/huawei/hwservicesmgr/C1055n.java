package com.huawei.hwservicesmgr;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p032e.C0803b;
import com.huawei.p032e.C0805k;
import java.util.List;

/* compiled from: IPhoneServiceAIDL */
public abstract class C1055n extends Binder implements C1054m {
    public C1055n() {
        attachInterface(this, "com.huawei.hwservicesmgr.IPhoneServiceAIDL");
    }

    public static C1054m m4448a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1054m)) {
            return new C1056o(iBinder);
        }
        return (C1054m) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        TransferFileInfo transferFileInfo = null;
        boolean z = false;
        DeviceCommand deviceCommand;
        boolean z2;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2321a(parcel.readStrongBinder(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                List a = mo2317a();
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                DeviceCapability b = mo2333b();
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2326a(C1049e.m4419a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2336b(C1049e.m4419a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                if (parcel.readInt() != 0) {
                    deviceCommand = (DeviceCommand) DeviceCommand.CREATOR.createFromParcel(parcel);
                }
                mo2325a(deviceCommand);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2320a(parcel.readInt(), parcel.readString(), parcel.createStringArrayList(), C1047b.m4415a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2331a(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                if (parcel.readInt() != 0) {
                    deviceCommand = (DeviceCommand) DeviceCommand.CREATOR.createFromParcel(parcel);
                }
                mo2335b(deviceCommand);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2329a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), C1053k.m4425a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2337c();
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2327a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                if (parcel.readInt() != 0) {
                    transferFileInfo = (TransferFileInfo) TransferFileInfo.CREATOR.createFromParcel(parcel);
                }
                mo2324a(transferFileInfo, C1059s.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                if (parcel.readInt() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mo2332a(z2);
                parcel2.writeNoException();
                return true;
            case 15:
                int i3;
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                z2 = mo2338d();
                parcel2.writeNoException();
                if (z2) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 16:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2318a(parcel.readInt(), parcel.readInt(), C1051h.m4421a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2323a(C0805k.m2689a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2322a(C0803b.m2687a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2334b(C0803b.m2687a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2328a(parcel.readString(), C0803b.m2687a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                mo2319a(parcel.readInt(), C0803b.m2687a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo2330a(readString, z, C0803b.m2687a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hwservicesmgr.IPhoneServiceAIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
