package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class TextAndMediaPath implements Parcelable {
    public static final Creator<TextAndMediaPath> CREATOR = new C6441a();
    private String f22330a;
    private String f22331b;

    public TextAndMediaPath(String str, String str2) {
        this.f22330a = str;
        this.f22331b = str2;
    }

    public String getText() {
        return this.f22330a;
    }

    public String getMediaPath() {
        return this.f22331b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22330a);
        parcel.writeString(this.f22331b);
    }

    private TextAndMediaPath(Parcel parcel) {
        this.f22330a = parcel.readString();
        this.f22331b = parcel.readString();
    }
}
