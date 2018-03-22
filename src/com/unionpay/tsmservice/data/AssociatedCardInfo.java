package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AssociatedCardInfo implements Parcelable {
    public static final Creator<AssociatedCardInfo> CREATOR = new C65611();
    private String mCardNo;
    private String mCardType;

    final class C65611 implements Creator<AssociatedCardInfo> {
        C65611() {
        }

        public AssociatedCardInfo createFromParcel(Parcel parcel) {
            return new AssociatedCardInfo(parcel);
        }

        public AssociatedCardInfo[] newArray(int i) {
            return new AssociatedCardInfo[i];
        }
    }

    public AssociatedCardInfo(Parcel parcel) {
        this.mCardType = parcel.readString();
        this.mCardNo = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mCardNo);
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getCardNo() {
        return this.mCardNo;
    }

    public void setCardNo(String str) {
        this.mCardNo = str;
    }
}
