package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetAssociatedAppRequestParams extends RequestParams {
    public static final Creator<GetAssociatedAppRequestParams> CREATOR = new C65931();
    private String mEncryptPan;

    final class C65931 implements Creator<GetAssociatedAppRequestParams> {
        C65931() {
        }

        public GetAssociatedAppRequestParams createFromParcel(Parcel parcel) {
            return new GetAssociatedAppRequestParams(parcel);
        }

        public GetAssociatedAppRequestParams[] newArray(int i) {
            return new GetAssociatedAppRequestParams[i];
        }
    }

    public GetAssociatedAppRequestParams(Parcel parcel) {
        this.mEncryptPan = parcel.readString();
    }

    public GetAssociatedAppRequestParams(String str) {
        this.mEncryptPan = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mEncryptPan);
    }

    public String getEncryptPan() {
        return this.mEncryptPan;
    }

    public void setEncryptPan(String str) {
        this.mEncryptPan = str;
    }
}
