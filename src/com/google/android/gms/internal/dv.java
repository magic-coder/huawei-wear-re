package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.bb;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;

public abstract class dv extends Binder implements du {
    public static du m1237a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof du)) ? new dw(iBinder) : (du) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        zzbau com_google_android_gms_internal_zzbau = null;
        switch (i) {
            case 2:
                zzd com_google_android_gms_common_internal_zzd;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_common_internal_zzd = (zzd) zzd.CREATOR.createFromParcel(parcel);
                }
                mo1859a(com_google_android_gms_common_internal_zzd, ds.m975a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                zzban com_google_android_gms_internal_zzban;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_internal_zzban = (zzban) zzban.CREATOR.createFromParcel(parcel);
                }
                mo1861a(com_google_android_gms_internal_zzban);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                mo1864a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 5:
                zzad com_google_android_gms_common_internal_zzad;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_common_internal_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                }
                mo1858a(com_google_android_gms_common_internal_zzad, bb.m641a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                mo1855a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 8:
                Account account;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    account = (Account) Account.CREATOR.createFromParcel(parcel);
                }
                mo1856a(readInt, account, ds.m975a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                ao a = ap.m623a(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo1857a(a, readInt2, z);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbar com_google_android_gms_internal_zzbar;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_internal_zzbar = (zzbar) zzbar.CREATOR.createFromParcel(parcel);
                }
                mo1862a(com_google_android_gms_internal_zzbar, ds.m975a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                mo1860a(ds.m975a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_internal_zzbau = (zzbau) zzbau.CREATOR.createFromParcel(parcel);
                }
                mo1863a(com_google_android_gms_internal_zzbau, ds.m975a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo1865b(z);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
