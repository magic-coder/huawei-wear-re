package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UniteAppStatus implements Parcelable {
    public static final String ACTIVELESS = "02";
    public static final Creator<UniteAppStatus> CREATOR = new C65721();
    public static final String DELETED = "06";
    public static final String FINE = "01";
    public static final String ILLEGAL = "99";
    public static final String INSTALLLESS = "04";
    public static final String LOCKED = "05";
    public static final String NONE = "03";
    private String mStatus = "03";

    final class C65721 implements Creator<UniteAppStatus> {
        C65721() {
        }

        public UniteAppStatus createFromParcel(Parcel parcel) {
            return new UniteAppStatus(parcel);
        }

        public UniteAppStatus[] newArray(int i) {
            return new UniteAppStatus[i];
        }
    }

    public UniteAppStatus(String str) {
        this.mStatus = str;
    }

    public UniteAppStatus(Parcel parcel) {
        this.mStatus = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStatus);
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }
}
