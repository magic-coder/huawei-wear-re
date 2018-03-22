package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardService */
public abstract class C6659c extends Binder implements C6658b {
    public static C6658b m29970a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.simalliance.openmobileapi.service.ISmartcardService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6658b)) {
            return new C6660d(iBinder);
        }
        return (C6658b) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardService");
                SmartcardError smartcardError = new SmartcardError();
                String[] a = mo5535a(smartcardError);
                parcel2.writeNoException();
                parcel2.writeStringArray(a);
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 2:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardService");
                String readString = parcel.readString();
                SmartcardError smartcardError2 = new SmartcardError();
                C6665k a2 = mo5534a(readString, smartcardError2);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardService");
                String readString2 = parcel.readString();
                byte[] createByteArray = parcel.createByteArray();
                String[] createStringArray = parcel.createStringArray();
                C6652e a3 = C6653f.m29956a(parcel.readStrongBinder());
                SmartcardError smartcardError3 = new SmartcardError();
                boolean[] a4 = mo5536a(readString2, createByteArray, createStringArray, a3, smartcardError3);
                parcel2.writeNoException();
                parcel2.writeBooleanArray(a4);
                if (smartcardError3 != null) {
                    parcel2.writeInt(1);
                    smartcardError3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("org.simalliance.openmobileapi.service.ISmartcardService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
