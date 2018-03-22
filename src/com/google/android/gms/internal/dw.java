package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.ba;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;

class dw implements du {
    private IBinder f703a;

    dw(IBinder iBinder) {
        this.f703a = iBinder;
    }

    public void mo1855a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeInt(i);
            this.f703a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1856a(int i, Account account, dr drVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeInt(i);
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(drVar != null ? drVar.asBinder() : null);
            this.f703a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1857a(ao aoVar, int i, boolean z) throws RemoteException {
        int i2 = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeStrongBinder(aoVar != null ? aoVar.asBinder() : null);
            obtain.writeInt(i);
            if (z) {
                i2 = 1;
            }
            obtain.writeInt(i2);
            this.f703a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1858a(zzad com_google_android_gms_common_internal_zzad, ba baVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (com_google_android_gms_common_internal_zzad != null) {
                obtain.writeInt(1);
                com_google_android_gms_common_internal_zzad.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(baVar != null ? baVar.asBinder() : null);
            this.f703a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1859a(zzd com_google_android_gms_common_internal_zzd, dr drVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (com_google_android_gms_common_internal_zzd != null) {
                obtain.writeInt(1);
                com_google_android_gms_common_internal_zzd.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(drVar != null ? drVar.asBinder() : null);
            this.f703a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1860a(dr drVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            obtain.writeStrongBinder(drVar != null ? drVar.asBinder() : null);
            this.f703a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1861a(zzban com_google_android_gms_internal_zzban) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (com_google_android_gms_internal_zzban != null) {
                obtain.writeInt(1);
                com_google_android_gms_internal_zzban.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f703a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1862a(zzbar com_google_android_gms_internal_zzbar, dr drVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (com_google_android_gms_internal_zzbar != null) {
                obtain.writeInt(1);
                com_google_android_gms_internal_zzbar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(drVar != null ? drVar.asBinder() : null);
            this.f703a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1863a(zzbau com_google_android_gms_internal_zzbau, dr drVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (com_google_android_gms_internal_zzbau != null) {
                obtain.writeInt(1);
                com_google_android_gms_internal_zzbau.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(drVar != null ? drVar.asBinder() : null);
            this.f703a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo1864a(boolean z) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f703a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f703a;
    }

    public void mo1865b(boolean z) throws RemoteException {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f703a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
