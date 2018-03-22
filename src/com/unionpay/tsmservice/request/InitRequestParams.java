package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class InitRequestParams extends RequestParams {
    public static final Creator<InitRequestParams> CREATOR = new C65991();
    private int mType;

    final class C65991 implements Creator<InitRequestParams> {
        C65991() {
        }

        public InitRequestParams[] newArray(int i) {
            return new InitRequestParams[i];
        }

        public InitRequestParams createFromParcel(Parcel parcel) {
            return new InitRequestParams(parcel);
        }
    }

    public InitRequestParams(Parcel parcel) {
        this.mType = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mType);
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
