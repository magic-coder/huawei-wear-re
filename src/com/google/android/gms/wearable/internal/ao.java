package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

class ao implements am {
    private IBinder f953a;

    ao(IBinder iBinder) {
        this.f953a = iBinder;
    }

    public void mo1926a(Status status) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1927a(DataHolder dataHolder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (dataHolder != null) {
                obtain.writeInt(1);
                dataHolder.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1928a(zzaa com_google_android_gms_wearable_internal_zzaa) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzaa != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzaa.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1929a(zzae com_google_android_gms_wearable_internal_zzae) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzae != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzae.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1930a(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzar != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1931a(zzat com_google_android_gms_wearable_internal_zzat) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzat != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(23, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1932a(zzav com_google_android_gms_wearable_internal_zzav) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzav != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzav.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1933a(zzax com_google_android_gms_wearable_internal_zzax) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzax != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzax.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1934a(zzaz com_google_android_gms_wearable_internal_zzaz) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzaz != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzaz.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1935a(zzbc com_google_android_gms_wearable_internal_zzbc) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbc != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbc.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(28, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1936a(zzbe com_google_android_gms_wearable_internal_zzbe) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbe != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbe.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(30, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1937a(zzbg com_google_android_gms_wearable_internal_zzbg) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbg != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbg.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(29, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1938a(zzbh com_google_android_gms_wearable_internal_zzbh) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbh != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbh.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1939a(zzbj com_google_android_gms_wearable_internal_zzbj) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbj != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbj.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1940a(zzbl com_google_android_gms_wearable_internal_zzbl) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbl != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbl.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1941a(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbn != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbn.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1942a(zzbp com_google_android_gms_wearable_internal_zzbp) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbp != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbp.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1943a(zzbr com_google_android_gms_wearable_internal_zzbr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzbr != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzbr.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1944a(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzce != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzce.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1945a(zzci com_google_android_gms_wearable_internal_zzci) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzci != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzci.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1946a(zzcm com_google_android_gms_wearable_internal_zzcm) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzcm != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzcm.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(27, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1947a(zzco com_google_android_gms_wearable_internal_zzco) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzco != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzco.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1948a(zzcs com_google_android_gms_wearable_internal_zzcs) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzcs != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzcs.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1949a(zze com_google_android_gms_wearable_internal_zze) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zze != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zze.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(26, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1950a(zzy com_google_android_gms_wearable_internal_zzy) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzy != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzy.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f953a;
    }

    public void mo1951b(zzae com_google_android_gms_wearable_internal_zzae) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if (com_google_android_gms_wearable_internal_zzae != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzae.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f953a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
