package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceReader */
public abstract class C6666l extends Binder implements C6665k {
    public static C6665k m29993a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6665k)) {
            return new C6667m(iBinder);
        }
        return (C6665k) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        SmartcardError smartcardError;
        SmartcardError smartcardError2;
        switch (i) {
            case 1:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
                smartcardError = new SmartcardError();
                String a = mo5544a(smartcardError);
                parcel2.writeNoException();
                parcel2.writeString(a);
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                int i3;
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
                smartcardError2 = new SmartcardError();
                boolean b = mo5545b(smartcardError2);
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                parcel2.writeInt(i3);
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 3:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
                smartcardError2 = new SmartcardError();
                C6668n c = mo5546c(smartcardError2);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(c != null ? c.asBinder() : null);
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 4:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
                smartcardError = new SmartcardError();
                mo5547d(smartcardError);
                parcel2.writeNoException();
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("org.simalliance.openmobileapi.service.ISmartcardServiceReader");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
