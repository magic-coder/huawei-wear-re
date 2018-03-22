package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class an extends Binder implements am {
    public an() {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    public static am m1751a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof am)) ? new ao(iBinder) : (am) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcm com_google_android_gms_wearable_internal_zzcm = null;
        zzae com_google_android_gms_wearable_internal_zzae;
        switch (i) {
            case 2:
                zzbh com_google_android_gms_wearable_internal_zzbh;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbh = (zzbh) zzbh.CREATOR.createFromParcel(parcel);
                }
                mo1938a(com_google_android_gms_wearable_internal_zzbh);
                parcel2.writeNoException();
                return true;
            case 3:
                zzci com_google_android_gms_wearable_internal_zzci;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzci = (zzci) zzci.CREATOR.createFromParcel(parcel);
                }
                mo1945a(com_google_android_gms_wearable_internal_zzci);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbn com_google_android_gms_wearable_internal_zzbn;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbn = (zzbn) zzbn.CREATOR.createFromParcel(parcel);
                }
                mo1941a(com_google_android_gms_wearable_internal_zzbn);
                parcel2.writeNoException();
                return true;
            case 5:
                DataHolder dataHolder;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                }
                mo1927a(dataHolder);
                parcel2.writeNoException();
                return true;
            case 6:
                zzar com_google_android_gms_wearable_internal_zzar;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzar = (zzar) zzar.CREATOR.createFromParcel(parcel);
                }
                mo1930a(com_google_android_gms_wearable_internal_zzar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzco com_google_android_gms_wearable_internal_zzco;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzco = (zzco) zzco.CREATOR.createFromParcel(parcel);
                }
                mo1947a(com_google_android_gms_wearable_internal_zzco);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbp com_google_android_gms_wearable_internal_zzbp;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbp = (zzbp) zzbp.CREATOR.createFromParcel(parcel);
                }
                mo1942a(com_google_android_gms_wearable_internal_zzbp);
                parcel2.writeNoException();
                return true;
            case 9:
                zzbr com_google_android_gms_wearable_internal_zzbr;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbr = (zzbr) zzbr.CREATOR.createFromParcel(parcel);
                }
                mo1943a(com_google_android_gms_wearable_internal_zzbr);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbl com_google_android_gms_wearable_internal_zzbl;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbl = (zzbl) zzbl.CREATOR.createFromParcel(parcel);
                }
                mo1940a(com_google_android_gms_wearable_internal_zzbl);
                parcel2.writeNoException();
                return true;
            case 11:
                Status status;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    status = (Status) Status.CREATOR.createFromParcel(parcel);
                }
                mo1926a(status);
                parcel2.writeNoException();
                return true;
            case 12:
                zzcs com_google_android_gms_wearable_internal_zzcs;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzcs = (zzcs) zzcs.CREATOR.createFromParcel(parcel);
                }
                mo1948a(com_google_android_gms_wearable_internal_zzcs);
                parcel2.writeNoException();
                return true;
            case 13:
                zzbj com_google_android_gms_wearable_internal_zzbj;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbj = (zzbj) zzbj.CREATOR.createFromParcel(parcel);
                }
                mo1939a(com_google_android_gms_wearable_internal_zzbj);
                parcel2.writeNoException();
                return true;
            case 14:
                zzce com_google_android_gms_wearable_internal_zzce;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzce = (zzce) zzce.CREATOR.createFromParcel(parcel);
                }
                mo1944a(com_google_android_gms_wearable_internal_zzce);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzae = (zzae) zzae.CREATOR.createFromParcel(parcel);
                }
                mo1929a(com_google_android_gms_wearable_internal_zzae);
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzae = (zzae) zzae.CREATOR.createFromParcel(parcel);
                }
                mo1951b(com_google_android_gms_wearable_internal_zzae);
                parcel2.writeNoException();
                return true;
            case 17:
                zzax com_google_android_gms_wearable_internal_zzax;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzax = (zzax) zzax.CREATOR.createFromParcel(parcel);
                }
                mo1933a(com_google_android_gms_wearable_internal_zzax);
                parcel2.writeNoException();
                return true;
            case 18:
                zzaz com_google_android_gms_wearable_internal_zzaz;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzaz = (zzaz) zzaz.CREATOR.createFromParcel(parcel);
                }
                mo1934a(com_google_android_gms_wearable_internal_zzaz);
                parcel2.writeNoException();
                return true;
            case 19:
                zzy com_google_android_gms_wearable_internal_zzy;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzy = (zzy) zzy.CREATOR.createFromParcel(parcel);
                }
                mo1950a(com_google_android_gms_wearable_internal_zzy);
                parcel2.writeNoException();
                return true;
            case 20:
                zzaa com_google_android_gms_wearable_internal_zzaa;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzaa = (zzaa) zzaa.CREATOR.createFromParcel(parcel);
                }
                mo1928a(com_google_android_gms_wearable_internal_zzaa);
                parcel2.writeNoException();
                return true;
            case 22:
                zzav com_google_android_gms_wearable_internal_zzav;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzav = (zzav) zzav.CREATOR.createFromParcel(parcel);
                }
                mo1932a(com_google_android_gms_wearable_internal_zzav);
                parcel2.writeNoException();
                return true;
            case 23:
                zzat com_google_android_gms_wearable_internal_zzat;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzat = (zzat) zzat.CREATOR.createFromParcel(parcel);
                }
                mo1931a(com_google_android_gms_wearable_internal_zzat);
                parcel2.writeNoException();
                return true;
            case 26:
                zze com_google_android_gms_wearable_internal_zze;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                }
                mo1949a(com_google_android_gms_wearable_internal_zze);
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzcm = (zzcm) zzcm.CREATOR.createFromParcel(parcel);
                }
                mo1946a(com_google_android_gms_wearable_internal_zzcm);
                parcel2.writeNoException();
                return true;
            case 28:
                zzbc com_google_android_gms_wearable_internal_zzbc;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbc = (zzbc) zzbc.CREATOR.createFromParcel(parcel);
                }
                mo1935a(com_google_android_gms_wearable_internal_zzbc);
                parcel2.writeNoException();
                return true;
            case 29:
                zzbg com_google_android_gms_wearable_internal_zzbg;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbg = (zzbg) zzbg.CREATOR.createFromParcel(parcel);
                }
                mo1937a(com_google_android_gms_wearable_internal_zzbg);
                parcel2.writeNoException();
                return true;
            case 30:
                zzbe com_google_android_gms_wearable_internal_zzbe;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbe = (zzbe) zzbe.CREATOR.createFromParcel(parcel);
                }
                mo1936a(com_google_android_gms_wearable_internal_zzbe);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
