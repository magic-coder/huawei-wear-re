package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppStatus implements Parcelable {
    public static final String APPLY = "06";
    public static final String APPROVED = "00";
    public static final String APPROVING = "02";
    public static final Creator<AppStatus> CREATOR = new C65571();
    public static final String NOT_APPROVED = "01";
    public static final String OPEN = "05";
    public static final String VIEW = "07";
    private String mStatus = "";

    final class C65571 implements Creator<AppStatus> {
        C65571() {
        }

        public AppStatus createFromParcel(Parcel parcel) {
            return new AppStatus(parcel);
        }

        public AppStatus[] newArray(int i) {
            return new AppStatus[i];
        }
    }

    public AppStatus(String str) {
        this.mStatus = str;
    }

    public AppStatus(Parcel parcel) {
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
