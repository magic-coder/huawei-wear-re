package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISmartcardServiceCallback */
public abstract class C6653f extends Binder implements C6652e {
    public C6653f() {
        attachInterface(this, "org.simalliance.openmobileapi.service.ISmartcardServiceCallback");
    }

    public static C6652e m29956a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("org.simalliance.openmobileapi.service.ISmartcardServiceCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C6652e)) {
            return new C6661g(iBinder);
        }
        return (C6652e) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1598968902:
                parcel2.writeString("org.simalliance.openmobileapi.service.ISmartcardServiceCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
