package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class cz implements Creator<zzk> {
    static void m2105a(zzk com_google_android_gms_wearable_internal_zzk, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzk.getId());
        C0438c.m740a(parcel, 3, com_google_android_gms_wearable_internal_zzk.zzke(), false);
        C0438c.m740a(parcel, 4, com_google_android_gms_wearable_internal_zzk.zzUm(), false);
        C0438c.m740a(parcel, 5, com_google_android_gms_wearable_internal_zzk.zzUn(), false);
        C0438c.m740a(parcel, 6, com_google_android_gms_wearable_internal_zzk.getTitle(), false);
        C0438c.m740a(parcel, 7, com_google_android_gms_wearable_internal_zzk.zzEv(), false);
        C0438c.m740a(parcel, 8, com_google_android_gms_wearable_internal_zzk.getDisplayName(), false);
        C0438c.m730a(parcel, 9, com_google_android_gms_wearable_internal_zzk.zzUo());
        C0438c.m730a(parcel, 10, com_google_android_gms_wearable_internal_zzk.zzUp());
        C0438c.m730a(parcel, 11, com_google_android_gms_wearable_internal_zzk.zzUq());
        C0438c.m730a(parcel, 12, com_google_android_gms_wearable_internal_zzk.zzUr());
        C0438c.m740a(parcel, 13, com_google_android_gms_wearable_internal_zzk.getPackageName(), false);
        C0438c.m729a(parcel, a);
    }

    public zzk m2106a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 5:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 6:
                    str4 = C0436a.m713l(parcel, a);
                    break;
                case 7:
                    str5 = C0436a.m713l(parcel, a);
                    break;
                case 8:
                    str6 = C0436a.m713l(parcel, a);
                    break;
                case 9:
                    b2 = C0436a.m705d(parcel, a);
                    break;
                case 10:
                    b3 = C0436a.m705d(parcel, a);
                    break;
                case 11:
                    b4 = C0436a.m705d(parcel, a);
                    break;
                case 12:
                    b5 = C0436a.m705d(parcel, a);
                    break;
                case 13:
                    str7 = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzk(i, str, str2, str3, str4, str5, str6, b2, b3, b4, b5, str7);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzk[] m2107a(int i) {
        return new zzk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2106a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2107a(i);
    }
}
