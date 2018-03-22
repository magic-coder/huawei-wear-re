package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceChannel */
public abstract class C6663i extends Binder implements C6662h {
    public static C6662h m29981a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6662h)) {
            return new C6664j(iBinder);
        }
        return (C6662h) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        boolean a;
        SmartcardError smartcardError;
        switch (i) {
            case 1:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                SmartcardError smartcardError2 = new SmartcardError();
                mo5537a(smartcardError2);
                parcel2.writeNoException();
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                a = mo5538a();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                a = mo5540b();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                byte[] c = mo5542c();
                parcel2.writeNoException();
                parcel2.writeByteArray(c);
                return true;
            case 5:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                C6668n d = mo5543d();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                return true;
            case 6:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                byte[] createByteArray = parcel.createByteArray();
                smartcardError = new SmartcardError();
                createByteArray = mo5539a(createByteArray, smartcardError);
                parcel2.writeNoException();
                parcel2.writeByteArray(createByteArray);
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                int i4;
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                smartcardError = new SmartcardError();
                a = mo5541b(smartcardError);
                parcel2.writeNoException();
                if (a) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                parcel2.writeInt(i4);
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("org.simalliance.openmobileapi.service.ISmartcardServiceChannel");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
