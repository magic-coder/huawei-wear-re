package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.common.zzc;

public class ad implements Creator<zzj> {
    static void m524a(zzj com_google_android_gms_common_internal_zzj, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzj.version);
        C0438c.m733a(parcel, 2, com_google_android_gms_common_internal_zzj.zzaFK);
        C0438c.m733a(parcel, 3, com_google_android_gms_common_internal_zzj.zzaFL);
        C0438c.m740a(parcel, 4, com_google_android_gms_common_internal_zzj.zzaFM, false);
        C0438c.m736a(parcel, 5, com_google_android_gms_common_internal_zzj.zzaFN, false);
        C0438c.m744a(parcel, 6, com_google_android_gms_common_internal_zzj.zzaFO, i, false);
        C0438c.m735a(parcel, 7, com_google_android_gms_common_internal_zzj.zzaFP, false);
        C0438c.m738a(parcel, 8, com_google_android_gms_common_internal_zzj.zzaFQ, i, false);
        C0438c.m744a(parcel, 10, com_google_android_gms_common_internal_zzj.zzaFR, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzj m525a(Parcel parcel) {
        int i = 0;
        zzc[] com_google_android_gms_common_zzcArr = null;
        int b = C0436a.m700b(parcel);
        Account account = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i3 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 4:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 5:
                    iBinder = C0436a.m714m(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C0436a.m702b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C0436a.m715n(parcel, a);
                    break;
                case 8:
                    account = (Account) C0436a.m697a(parcel, a, Account.CREATOR);
                    break;
                case 10:
                    com_google_android_gms_common_zzcArr = (zzc[]) C0436a.m702b(parcel, a, zzc.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzj(i3, i2, i, str, iBinder, scopeArr, bundle, account, com_google_android_gms_common_zzcArr);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzj[] m526a(int i) {
        return new zzj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m525a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m526a(i);
    }
}
