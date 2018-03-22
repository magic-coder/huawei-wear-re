package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.ArrayList;

public class C0353f implements Creator<GoogleSignInOptions> {
    static void m288a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, googleSignInOptions.versionCode);
        C0438c.m749b(parcel, 2, googleSignInOptions.zzrj(), false);
        C0438c.m738a(parcel, 3, googleSignInOptions.getAccount(), i, false);
        C0438c.m742a(parcel, 4, googleSignInOptions.isIdTokenRequested());
        C0438c.m742a(parcel, 5, googleSignInOptions.zzrk());
        C0438c.m742a(parcel, 6, googleSignInOptions.zzrl());
        C0438c.m740a(parcel, 7, googleSignInOptions.getServerClientId(), false);
        C0438c.m740a(parcel, 8, googleSignInOptions.zzrm(), false);
        C0438c.m749b(parcel, 9, googleSignInOptions.zzrn(), false);
        C0438c.m729a(parcel, a);
    }

    public GoogleSignInOptions m289a(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = C0436a.m700b(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    arrayList2 = C0436a.m703c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) C0436a.m697a(parcel, a, Account.CREATOR);
                    break;
                case 4:
                    z3 = C0436a.m704c(parcel, a);
                    break;
                case 5:
                    z2 = C0436a.m704c(parcel, a);
                    break;
                case 6:
                    z = C0436a.m704c(parcel, a);
                    break;
                case 7:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 8:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 9:
                    arrayList = C0436a.m703c(parcel, a, zzg.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList2, account, z3, z2, z, str2, str, arrayList);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m290a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m289a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m290a(i);
    }
}
