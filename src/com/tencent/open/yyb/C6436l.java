package com.tencent.open.yyb;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class C6436l implements Creator<ShareModel> {
    C6436l() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29345a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29346a(i);
    }

    public ShareModel m29345a(Parcel parcel) {
        ShareModel shareModel = new ShareModel();
        shareModel.f22304a = parcel.readString();
        shareModel.f22305b = parcel.readString();
        shareModel.f22306c = parcel.readString();
        shareModel.f22307d = parcel.readString();
        return shareModel;
    }

    public ShareModel[] m29346a(int i) {
        return null;
    }
}
