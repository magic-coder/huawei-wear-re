package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0425g implements Creator<zzad> {
    static void m660a(zzad com_google_android_gms_common_internal_zzad, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzad.zzaiI);
        C0438c.m738a(parcel, 2, com_google_android_gms_common_internal_zzad.getAccount(), i, false);
        C0438c.m733a(parcel, 3, com_google_android_gms_common_internal_zzad.getSessionId());
        C0438c.m738a(parcel, 4, com_google_android_gms_common_internal_zzad.zzyf(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzad m661a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C0436a.m700b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int e;
            GoogleSignInAccount googleSignInAccount2;
            int a = C0436a.m695a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C0436a.m694a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    e = C0436a.m706e(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    e = i2;
                    int i4 = i;
                    account2 = (Account) C0436a.m697a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    e = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C0436a.m706e(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) C0436a.m697a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    e = i2;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    e = i2;
                    break;
            }
            i2 = e;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new zzad(i2, account, i, googleSignInAccount);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzad[] m662a(int i) {
        return new zzad[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m661a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m662a(i);
    }
}
