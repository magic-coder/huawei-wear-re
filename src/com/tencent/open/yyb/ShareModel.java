package com.tencent.open.yyb;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class ShareModel implements Parcelable {
    public static final Creator<ShareModel> CREATOR = new C6436l();
    public String f22304a;
    public String f22305b;
    public String f22306c;
    public String f22307d;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22304a);
        parcel.writeString(this.f22305b);
        parcel.writeString(this.f22306c);
        parcel.writeString(this.f22307d);
    }
}
