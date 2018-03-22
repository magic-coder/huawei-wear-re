package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class AppUniteApplyRecord implements Parcelable {
    public static final Creator<AppUniteApplyRecord> CREATOR = new C65581();
    private String mAppIcon;
    private String mAppId;
    private IDVMethod[] mIdvMethods;
    private String mMPan;
    private String mMPanId;
    private String mResult;
    private String mSPan;

    final class C65581 implements Creator<AppUniteApplyRecord> {
        C65581() {
        }

        public AppUniteApplyRecord createFromParcel(Parcel parcel) {
            return new AppUniteApplyRecord(parcel);
        }

        public AppUniteApplyRecord[] newArray(int i) {
            return new AppUniteApplyRecord[i];
        }
    }

    public AppUniteApplyRecord(Parcel parcel) {
        this.mMPanId = parcel.readString();
        this.mAppId = parcel.readString();
        this.mAppIcon = parcel.readString();
        this.mMPan = parcel.readString();
        this.mSPan = parcel.readString();
        this.mResult = parcel.readString();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(IDVMethod.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mIdvMethods = (IDVMethod[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, IDVMethod[].class);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMPanId);
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mAppIcon);
        parcel.writeString(this.mMPan);
        parcel.writeString(this.mSPan);
        parcel.writeString(this.mResult);
        parcel.writeParcelableArray(this.mIdvMethods, i);
    }

    public String getMPanId() {
        return this.mMPanId;
    }

    public void setMPanId(String str) {
        this.mMPanId = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public String getAppIcon() {
        return this.mAppIcon;
    }

    public void setAppIcon(String str) {
        this.mAppIcon = str;
    }

    public String getMPan() {
        return this.mMPan;
    }

    public void setMPan(String str) {
        this.mMPan = str;
    }

    public String getSPan() {
        return this.mSPan;
    }

    public void setSPan(String str) {
        this.mSPan = str;
    }

    public String getResult() {
        return this.mResult;
    }

    public void setResult(String str) {
        this.mResult = str;
    }

    public IDVMethod[] getIDVMethod() {
        return this.mIdvMethods;
    }

    public void setIDVMethod(IDVMethod[] iDVMethodArr) {
        this.mIdvMethods = iDVMethodArr;
    }
}
