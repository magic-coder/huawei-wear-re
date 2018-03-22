package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class C0352e implements Creator<GoogleSignInAccount> {
    static void m285a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, googleSignInAccount.versionCode);
        C0438c.m740a(parcel, 2, googleSignInAccount.getId(), false);
        C0438c.m740a(parcel, 3, googleSignInAccount.getIdToken(), false);
        C0438c.m740a(parcel, 4, googleSignInAccount.getEmail(), false);
        C0438c.m740a(parcel, 5, googleSignInAccount.getDisplayName(), false);
        C0438c.m738a(parcel, 6, googleSignInAccount.getPhotoUrl(), i, false);
        C0438c.m740a(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        C0438c.m734a(parcel, 8, googleSignInAccount.zzre());
        C0438c.m740a(parcel, 9, googleSignInAccount.zzrf(), false);
        C0438c.m749b(parcel, 10, googleSignInAccount.zzaiN, false);
        C0438c.m740a(parcel, 11, googleSignInAccount.getGivenName(), false);
        C0438c.m740a(parcel, 12, googleSignInAccount.getFamilyName(), false);
        C0438c.m729a(parcel, a);
    }

    public GoogleSignInAccount m286a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 5:
                    str4 = C0436a.m713l(parcel, a);
                    break;
                case 6:
                    uri = (Uri) C0436a.m697a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C0436a.m713l(parcel, a);
                    break;
                case 8:
                    j = C0436a.m708g(parcel, a);
                    break;
                case 9:
                    str6 = C0436a.m713l(parcel, a);
                    break;
                case 10:
                    list = C0436a.m703c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C0436a.m713l(parcel, a);
                    break;
                case 12:
                    str8 = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m287a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m286a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m287a(i);
    }
}
