package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

class ar implements ap {
    private IBinder f954a;

    ar(IBinder iBinder) {
        this.f954a = iBinder;
    }

    public void mo1914a(DataHolder dataHolder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (dataHolder != null) {
                obtain.writeInt(1);
                dataHolder.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1915a(zzbz com_google_android_gms_wearable_internal_zzbz) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzbz != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbz.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1916a(zzcc com_google_android_gms_wearable_internal_zzcc) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzcc != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzcc.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1917a(zzh com_google_android_gms_wearable_internal_zzh) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzh != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzh.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(9, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1918a(zzk com_google_android_gms_wearable_internal_zzk) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzk != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzk.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(6, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1919a(zzo com_google_android_gms_wearable_internal_zzo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzo != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(8, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1920a(zzs com_google_android_gms_wearable_internal_zzs) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzs != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzs.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(7, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void mo1921a(List<zzcc> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            obtain.writeTypedList(list);
            this.f954a.transact(5, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f954a;
    }

    public void mo1922b(zzcc com_google_android_gms_wearable_internal_zzcc) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (com_google_android_gms_wearable_internal_zzcc != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzcc.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f954a.transact(4, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
