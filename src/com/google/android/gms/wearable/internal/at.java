package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public abstract class at extends Binder implements as {
    public static as m1891a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof as)) ? new au(iBinder) : (as) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        ConnectionConfiguration connectionConfiguration = null;
        am a;
        Uri uri;
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                }
                mo1976b(a, connectionConfiguration);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1998n(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1999o(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo2000p(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                PutDataRequest putDataRequest;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(parcel);
                }
                mo1960a(a, putDataRequest);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                mo1956a(a, uri);
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1972b(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                mo1974b(a, uri);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                mo1983c(a, uri);
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1970a(an.m1751a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 13:
                Asset asset;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    asset = (Asset) Asset.CREATOR.createFromParcel(parcel);
                }
                mo1958a(a, asset);
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1981c(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1985d(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 16:
                zzc com_google_android_gms_wearable_internal_zzc;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzc = (zzc) zzc.CREATOR.createFromParcel(parcel);
                }
                mo1962a(a, com_google_android_gms_wearable_internal_zzc);
                parcel2.writeNoException();
                return true;
            case 17:
                zzck com_google_android_gms_wearable_internal_zzck;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzck = (zzck) zzck.CREATOR.createFromParcel(parcel);
                }
                mo1963a(a, com_google_android_gms_wearable_internal_zzck);
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1987e(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1989f(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                }
                mo1959a(a, connectionConfiguration);
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1965a(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1953a(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1978b(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 24:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1984c(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1991g(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1992h(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                zzk com_google_android_gms_wearable_internal_zzk;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    com_google_android_gms_wearable_internal_zzk = (zzk) zzk.CREATOR.createFromParcel(parcel);
                }
                mo1964a(a, com_google_android_gms_wearable_internal_zzk);
                parcel2.writeNoException();
                return true;
            case 28:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1973b(an.m1751a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 29:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1982c(an.m1751a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 30:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1993i(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1969a(an.m1751a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 32:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1990f(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1979b(an.m1751a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1961a(an.m1751a(parcel.readStrongBinder()), ak.m1806a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1977b(an.m1751a(parcel.readStrongBinder()), ak.m1806a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1994j(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 38:
                ParcelFileDescriptor parcelFileDescriptor;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                }
                mo1967a(a, readString, parcelFileDescriptor);
                parcel2.writeNoException();
                return true;
            case 39:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1968a(an.m1751a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 40:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                mo1957a(a, uri, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                mo1975b(a, uri, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 42:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1966a(an.m1751a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 43:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1955a(an.m1751a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 46:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1986d(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 47:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1988e(an.m1751a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 48:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1971a(an.m1751a(parcel.readStrongBinder()), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 49:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1995k(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 50:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                am a2 = an.m1751a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo1980b(a2, z);
                parcel2.writeNoException();
                return true;
            case 51:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1996l(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 52:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1997m(an.m1751a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 53:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                mo1954a(an.m1751a(parcel.readStrongBinder()), parcel.readByte());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
