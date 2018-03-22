package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransElement implements Parcelable {
    public static final Creator<TransElement> CREATOR = new C65691();
    private boolean isMustShow = true;
    private String mHint = "";
    private String mLabel = "";
    private String mName = "";
    private String mType = "";
    private String mVerfyRule = "";

    final class C65691 implements Creator<TransElement> {
        C65691() {
        }

        public TransElement createFromParcel(Parcel parcel) {
            return new TransElement(parcel);
        }

        public TransElement[] newArray(int i) {
            return new TransElement[i];
        }
    }

    public TransElement(Parcel parcel) {
        boolean z = true;
        if (1 != parcel.readInt()) {
            z = false;
        }
        this.isMustShow = z;
        this.mLabel = parcel.readString();
        this.mName = parcel.readString();
        this.mHint = parcel.readString();
        this.mVerfyRule = parcel.readString();
        this.mType = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.isMustShow ? 1 : 0);
        parcel.writeString(this.mLabel);
        parcel.writeString(this.mName);
        parcel.writeString(this.mHint);
        parcel.writeString(this.mVerfyRule);
        parcel.writeString(this.mType);
    }

    public boolean isMustShow() {
        return this.isMustShow;
    }

    public void setMustShow(boolean z) {
        this.isMustShow = z;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getHint() {
        return this.mHint;
    }

    public void setHint(String str) {
        this.mHint = str;
    }

    public String getVerfyRule() {
        return this.mVerfyRule;
    }

    public void setVerfyRule(String str) {
        this.mVerfyRule = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
