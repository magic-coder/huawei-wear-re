package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppDetail;

public class GetAppDetailResult implements Parcelable {
    public static final Creator<GetAppDetailResult> CREATOR = new C66181();
    private AppDetail mAppDetail;

    final class C66181 implements Creator<GetAppDetailResult> {
        C66181() {
        }

        public GetAppDetailResult createFromParcel(Parcel parcel) {
            return new GetAppDetailResult(parcel);
        }

        public GetAppDetailResult[] newArray(int i) {
            return new GetAppDetailResult[i];
        }
    }

    public GetAppDetailResult(Parcel parcel) {
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
