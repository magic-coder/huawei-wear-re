package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UpdateInfo implements Parcelable {
    public static final Creator<UpdateInfo> CREATOR = new C65731();
    public static final String TYPE_MUST = "02";
    public static final String TYPE_NONE = "00";
    public static final String TYPE_OPTION = "01";
    private String mClientDigest;
    private String[] mDesc;
    private String mDownloadUrl;
    private String mType;

    final class C65731 implements Creator<UpdateInfo> {
        C65731() {
        }

        public UpdateInfo createFromParcel(Parcel parcel) {
            return new UpdateInfo(parcel);
        }

        public UpdateInfo[] newArray(int i) {
            return new UpdateInfo[i];
        }
    }

    public UpdateInfo(Parcel parcel) {
        this.mType = parcel.readString();
        this.mDownloadUrl = parcel.readString();
        this.mClientDigest = parcel.readString();
        this.mDesc = parcel.createStringArray();
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public String getClientDigest() {
        return this.mClientDigest;
    }

    public void setClientDigest(String str) {
        this.mClientDigest = str;
    }

    public String[] getDesc() {
        return this.mDesc;
    }

    public void setDesc(String[] strArr) {
        this.mDesc = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mType);
        parcel.writeString(this.mDownloadUrl);
        parcel.writeString(this.mClientDigest);
        parcel.writeStringArray(this.mDesc);
    }
}
