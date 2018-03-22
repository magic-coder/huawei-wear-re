package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

class au implements as {
    private IBinder f955a;

    au(IBinder iBinder) {
        this.f955a = iBinder;
    }

    public void mo1953a(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1954a(am amVar, byte b) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeByte(b);
            this.f955a.transact(53, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1955a(am amVar, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeInt(i);
            this.f955a.transact(43, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1956a(am amVar, Uri uri) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1957a(am amVar, Uri uri, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            this.f955a.transact(40, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1958a(am amVar, Asset asset) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (asset != null) {
                obtain.writeInt(1);
                asset.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1959a(am amVar, ConnectionConfiguration connectionConfiguration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (connectionConfiguration != null) {
                obtain.writeInt(1);
                connectionConfiguration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1960a(am amVar, PutDataRequest putDataRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (putDataRequest != null) {
                obtain.writeInt(1);
                putDataRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1961a(am amVar, aj ajVar, String str) throws RemoteException {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (ajVar != null) {
                iBinder = ajVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            this.f955a.transact(34, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1962a(am amVar, zzc com_google_android_gms_wearable_internal_zzc) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (com_google_android_gms_wearable_internal_zzc != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzc.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1963a(am amVar, zzck com_google_android_gms_wearable_internal_zzck) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (com_google_android_gms_wearable_internal_zzck != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzck.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1964a(am amVar, zzk com_google_android_gms_wearable_internal_zzk) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (com_google_android_gms_wearable_internal_zzk != null) {
                obtain.writeInt(1);
                com_google_android_gms_wearable_internal_zzk.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(27, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1965a(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(21, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1966a(am amVar, String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f955a.transact(42, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1967a(am amVar, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            if (parcelFileDescriptor != null) {
                obtain.writeInt(1);
                parcelFileDescriptor.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(38, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1968a(am amVar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            if (parcelFileDescriptor != null) {
                obtain.writeInt(1);
                parcelFileDescriptor.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeLong(j);
            obtain.writeLong(j2);
            this.f955a.transact(39, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1969a(am amVar, String str, String str2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f955a.transact(31, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1970a(am amVar, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeByteArray(bArr);
            this.f955a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1971a(am amVar, boolean z) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f955a.transact(48, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f955a;
    }

    public void mo1972b(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1973b(am amVar, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeInt(i);
            this.f955a.transact(28, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1974b(am amVar, Uri uri) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1975b(am amVar, Uri uri, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            this.f955a.transact(41, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1976b(am amVar, ConnectionConfiguration connectionConfiguration) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (connectionConfiguration != null) {
                obtain.writeInt(1);
                connectionConfiguration.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1977b(am amVar, aj ajVar, String str) throws RemoteException {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (ajVar != null) {
                iBinder = ajVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            this.f955a.transact(35, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1978b(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(23, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1979b(am amVar, String str, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f955a.transact(33, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1980b(am amVar, boolean z) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f955a.transact(50, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1981c(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1982c(am amVar, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeInt(i);
            this.f955a.transact(29, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1983c(am amVar, Uri uri) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f955a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1984c(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(24, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1985d(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1986d(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1987e(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1988e(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(47, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1989f(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1990f(am amVar, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            obtain.writeString(str);
            this.f955a.transact(32, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1991g(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(25, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1992h(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(26, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1993i(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(30, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1994j(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(37, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1995k(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(49, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1996l(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(51, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1997m(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(52, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1998n(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1999o(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo2000p(am amVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
            obtain.writeStrongBinder(amVar != null ? amVar.asBinder() : null);
            this.f955a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
