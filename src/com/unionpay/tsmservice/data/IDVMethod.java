package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IDVMethod implements Parcelable {
    public static final Creator<IDVMethod> CREATOR = new C65641();
    private String mIDVMethod = "";

    final class C65641 implements Creator<IDVMethod> {
        C65641() {
        }

        public IDVMethod createFromParcel(Parcel parcel) {
            return new IDVMethod(parcel);
        }

        public IDVMethod[] newArray(int i) {
            return new IDVMethod[i];
        }
    }

    public IDVMethod(Parcel parcel) {
        this.mIDVMethod = parcel.readString();
    }

    public IDVMethod(String str) {
        this.mIDVMethod = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIDVMethod);
    }

    public String getActiveType() {
        return this.mIDVMethod;
    }

    public void setActiveType(String str) {
        this.mIDVMethod = str;
    }
}
