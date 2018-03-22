package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAnalyticsService */
public abstract class C3671c extends Binder implements C3670b {
    public static C3670b m18410a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C3670b)) {
            return new C3672d(iBinder);
        }
        return (C3670b) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                mo4269a(parcel.readHashMap(getClass().getClassLoader()), parcel.readLong(), parcel.readString(), parcel.createTypedArrayList(Command.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                mo4268a();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
