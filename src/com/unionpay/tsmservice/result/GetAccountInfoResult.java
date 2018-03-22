package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AssociatedCardInfo;

public class GetAccountInfoResult implements Parcelable {
    public static final Creator<GetAccountInfoResult> CREATOR = new C66151();
    private AssociatedCardInfo mAssociatedCardInfo;

    final class C66151 implements Creator<GetAccountInfoResult> {
        C66151() {
        }

        public GetAccountInfoResult createFromParcel(Parcel parcel) {
            return new GetAccountInfoResult(parcel);
        }

        public GetAccountInfoResult[] newArray(int i) {
            return new GetAccountInfoResult[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public GetAccountInfoResult(Parcel parcel) {
        this.mAssociatedCardInfo = (AssociatedCardInfo) parcel.readParcelable(AssociatedCardInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAssociatedCardInfo, i);
    }

    public AssociatedCardInfo getAssociatedCardInfo() {
        return this.mAssociatedCardInfo;
    }

    public void setAssociatedCardInfo(AssociatedCardInfo associatedCardInfo) {
        this.mAssociatedCardInfo = associatedCardInfo;
    }
}
