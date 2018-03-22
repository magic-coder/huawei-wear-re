package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ct implements Creator<zzc> {
    static void m2096a(zzc com_google_android_gms_wearable_internal_zzc, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m736a(parcel, 2, com_google_android_gms_wearable_internal_zzc.zzAh(), false);
        C0438c.m744a(parcel, 3, com_google_android_gms_wearable_internal_zzc.zzbTy, i, false);
        C0438c.m740a(parcel, 4, com_google_android_gms_wearable_internal_zzc.zzbTz, false);
        C0438c.m740a(parcel, 5, com_google_android_gms_wearable_internal_zzc.zzbTA, false);
        C0438c.m729a(parcel, a);
    }

    public zzc m2097a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            IntentFilter[] intentFilterArr2;
            IBinder m;
            String str3;
            int a = C0436a.m695a(parcel);
            String str4;
            switch (C0436a.m694a(a)) {
                case 2:
                    str4 = str;
                    str = str2;
                    intentFilterArr2 = intentFilterArr;
                    m = C0436a.m714m(parcel, a);
                    str3 = str4;
                    break;
                case 3:
                    m = iBinder;
                    str4 = str2;
                    intentFilterArr2 = (IntentFilter[]) C0436a.m702b(parcel, a, IntentFilter.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case 4:
                    intentFilterArr2 = intentFilterArr;
                    m = iBinder;
                    str4 = str;
                    str = C0436a.m713l(parcel, a);
                    str3 = str4;
                    break;
                case 5:
                    str3 = C0436a.m713l(parcel, a);
                    str = str2;
                    intentFilterArr2 = intentFilterArr;
                    m = iBinder;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    str3 = str;
                    str = str2;
                    intentFilterArr2 = intentFilterArr;
                    m = iBinder;
                    break;
            }
            iBinder = m;
            intentFilterArr = intentFilterArr2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == b) {
            return new zzc(iBinder, intentFilterArr, str2, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzc[] m2098a(int i) {
        return new zzc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2097a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2098a(i);
    }
}
