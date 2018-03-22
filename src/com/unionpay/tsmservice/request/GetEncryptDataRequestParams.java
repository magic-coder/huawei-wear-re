package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetEncryptDataRequestParams extends RequestParams {
    public static final Creator<GetEncryptDataRequestParams> CREATOR = new C65941();
    private String mPan;
    private int mType;

    final class C65941 implements Creator<GetEncryptDataRequestParams> {
        C65941() {
        }

        public GetEncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new GetEncryptDataRequestParams(parcel);
        }

        public GetEncryptDataRequestParams[] newArray(int i) {
            return new GetEncryptDataRequestParams[i];
        }
    }

    public GetEncryptDataRequestParams(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mPan = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mPan);
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getPan() {
        return this.mPan;
    }

    public void setPan(String str) {
        this.mPan = str;
    }
}
