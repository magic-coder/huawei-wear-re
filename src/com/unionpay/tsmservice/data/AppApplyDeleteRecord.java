package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppApplyDeleteRecord implements Parcelable {
    public static final Creator<AppApplyDeleteRecord> CREATOR = new C65551();
    private AppID mAppID;
    private String mResult;

    final class C65551 implements Creator<AppApplyDeleteRecord> {
        C65551() {
        }

        public AppApplyDeleteRecord createFromParcel(Parcel parcel) {
            return new AppApplyDeleteRecord(parcel);
        }

        public AppApplyDeleteRecord[] newArray(int i) {
            return new AppApplyDeleteRecord[i];
        }
    }

    public AppApplyDeleteRecord(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mResult = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mResult);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getResult() {
        return this.mResult;
    }

    public void setResult(String str) {
        this.mResult = str;
    }
}
