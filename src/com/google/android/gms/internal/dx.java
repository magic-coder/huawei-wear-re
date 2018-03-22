package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class dx implements Creator<zzbar> {
    static void m1249a(zzbar com_google_android_gms_internal_zzbar, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzbar.zzaiI);
        C0438c.m738a(parcel, 2, com_google_android_gms_internal_zzbar.getAccount(), i, false);
        C0438c.m744a(parcel, 3, com_google_android_gms_internal_zzbar.zzPR(), i, false);
        C0438c.m740a(parcel, 4, com_google_android_gms_internal_zzbar.getServerClientId(), false);
        C0438c.m729a(parcel, a);
    }

    public zzbar m1250a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int e;
            String str2;
            int a = C0436a.m695a(parcel);
            String str3;
            switch (C0436a.m694a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = C0436a.m706e(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    e = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C0436a.m697a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    e = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C0436a.m702b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0436a.m713l(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = i;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    e = i;
                    break;
            }
            i = e;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zzbar(i, account, scopeArr, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbar[] m1251a(int i) {
        return new zzbar[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1250a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1251a(i);
    }
}
