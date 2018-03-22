package com.huawei.account.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: AccountAidlInfo */
final class C3983a implements Creator<AccountAidlInfo> {
    C3983a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m19718a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m19719a(i);
    }

    public AccountAidlInfo m19718a(Parcel parcel) {
        return new AccountAidlInfo(parcel);
    }

    public AccountAidlInfo[] m19719a(int i) {
        return new AccountAidlInfo[i];
    }
}
