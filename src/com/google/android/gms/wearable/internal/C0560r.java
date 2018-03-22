package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0560r implements Creator<zzao> {
    static void m2201a(zzao com_google_android_gms_wearable_internal_zzao, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m738a(parcel, 2, com_google_android_gms_wearable_internal_zzao.getUri(), i, false);
        C0438c.m735a(parcel, 4, com_google_android_gms_wearable_internal_zzao.zzUg(), false);
        C0438c.m743a(parcel, 5, com_google_android_gms_wearable_internal_zzao.getData(), false);
        C0438c.m729a(parcel, a);
    }

    public zzao m2202a(Parcel parcel) {
        byte[] bArr = null;
        int b = C0436a.m700b(parcel);
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < b) {
            Bundle bundle2;
            Uri uri2;
            byte[] bArr2;
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    byte[] bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = (Uri) C0436a.m697a(parcel, a, Uri.CREATOR);
                    bArr2 = bArr3;
                    break;
                case 4:
                    uri2 = uri;
                    Bundle n = C0436a.m715n(parcel, a);
                    bArr2 = bArr;
                    bundle2 = n;
                    break;
                case 5:
                    bArr2 = C0436a.m716o(parcel, a);
                    bundle2 = bundle;
                    uri2 = uri;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    break;
            }
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == b) {
            return new zzao(uri, bundle, bArr);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzao[] m2203a(int i) {
        return new zzao[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2202a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2203a(i);
    }
}
