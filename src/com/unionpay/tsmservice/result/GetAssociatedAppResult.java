package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppDetail;

public class GetAssociatedAppResult implements Parcelable {
    public static final Creator<GetAssociatedAppResult> CREATOR = new C66201();
    private AppDetail mAppDetail;

    final class C66201 implements Creator<GetAssociatedAppResult> {
        C66201() {
        }

        public GetAssociatedAppResult createFromParcel(Parcel parcel) {
            return new GetAssociatedAppResult(parcel);
        }

        public GetAssociatedAppResult[] newArray(int i) {
            return new GetAssociatedAppResult[i];
        }
    }

    public GetAssociatedAppResult(Parcel parcel) {
        this.mAppDetail = (AppDetail) parcel.readParcelable(AppDetail.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppDetail, i);
    }

    public AppDetail getAppDetail() {
        return this.mAppDetail;
    }

    public void setAppDetail(AppDetail appDetail) {
        this.mAppDetail = appDetail;
    }
}
