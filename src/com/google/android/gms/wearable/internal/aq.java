package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public abstract class aq extends Binder implements ap {
    public aq() {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public static ap m1702a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ap)) ? new ar(iBinder) : (ap) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzh com_google_android_gms_wearable_internal_zzh = null;
        zzcc com_google_android_gms_wearable_internal_zzcc;
        switch (i) {
            case 1:
                DataHolder dataHolder;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    dataHolder = (DataHolder) DataHolder.CREATOR.createFromParcel(parcel);
                }
                mo1914a(dataHolder);
                return true;
            case 2:
                zzbz com_google_android_gms_wearable_internal_zzbz;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzbz = (zzbz) zzbz.CREATOR.createFromParcel(parcel);
                }
                mo1915a(com_google_android_gms_wearable_internal_zzbz);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzcc = (zzcc) zzcc.CREATOR.createFromParcel(parcel);
                }
                mo1916a(com_google_android_gms_wearable_internal_zzcc);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzcc = (zzcc) zzcc.CREATOR.createFromParcel(parcel);
                }
                mo1922b(com_google_android_gms_wearable_internal_zzcc);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                mo1921a(parcel.createTypedArrayList(zzcc.CREATOR));
                return true;
            case 6:
                zzk com_google_android_gms_wearable_internal_zzk;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzk = (zzk) zzk.CREATOR.createFromParcel(parcel);
                }
                mo1918a(com_google_android_gms_wearable_internal_zzk);
                return true;
            case 7:
                zzs com_google_android_gms_wearable_internal_zzs;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzs = (zzs) zzs.CREATOR.createFromParcel(parcel);
                }
                mo1920a(com_google_android_gms_wearable_internal_zzs);
                return true;
            case 8:
                zzo com_google_android_gms_wearable_internal_zzo;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzo = (zzo) zzo.CREATOR.createFromParcel(parcel);
                }
                mo1919a(com_google_android_gms_wearable_internal_zzo);
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzh = (zzh) zzh.CREATOR.createFromParcel(parcel);
                }
                mo1917a(com_google_android_gms_wearable_internal_zzh);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
