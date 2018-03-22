package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceSession */
public abstract class C6669o extends Binder implements C6668n {
    public static C6668n m30006a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6668n)) {
            return new C6670p(iBinder);
        }
        return (C6668n) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IBinder iBinder = null;
        SmartcardError smartcardError;
        C6662h a;
        byte[] createByteArray;
        C6652e a2;
        SmartcardError smartcardError2;
        switch (i) {
            case 1:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                C6665k a3 = mo5550a();
                parcel2.writeNoException();
                if (a3 != null) {
                    iBinder = a3.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 2:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                byte[] b = mo5554b();
                parcel2.writeNoException();
                parcel2.writeByteArray(b);
                return true;
            case 3:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                smartcardError = new SmartcardError();
                mo5551a(smartcardError);
                parcel2.writeNoException();
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 4:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                smartcardError = new SmartcardError();
                mo5553b(smartcardError);
                parcel2.writeNoException();
                if (smartcardError != null) {
                    parcel2.writeInt(1);
                    smartcardError.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 5:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                boolean c = mo5555c();
                parcel2.writeNoException();
                parcel2.writeInt(c ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                C6652e a4 = C6653f.m29956a(parcel.readStrongBinder());
                SmartcardError smartcardError3 = new SmartcardError();
                a = mo5548a(a4, smartcardError3);
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                if (smartcardError3 != null) {
                    parcel2.writeInt(1);
                    smartcardError3.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                createByteArray = parcel.createByteArray();
                a2 = C6653f.m29956a(parcel.readStrongBinder());
                smartcardError2 = new SmartcardError();
                a = mo5549a(createByteArray, a2, smartcardError2);
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 8:
                parcel.enforceInterface("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                createByteArray = parcel.createByteArray();
                a2 = C6653f.m29956a(parcel.readStrongBinder());
                smartcardError2 = new SmartcardError();
                a = mo5552b(createByteArray, a2, smartcardError2);
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                if (smartcardError2 != null) {
                    parcel2.writeInt(1);
                    smartcardError2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("org.simalliance.openmobileapi.service.ISmartcardServiceSession");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
