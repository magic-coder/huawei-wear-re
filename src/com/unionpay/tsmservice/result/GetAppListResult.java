package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppDetail;

public class GetAppListResult implements Parcelable {
    public static final Creator<GetAppListResult> CREATOR = new C66191();
    private AppDetail[] mAppList;

    final class C66191 implements Creator<GetAppListResult> {
        C66191() {
        }

        public GetAppListResult createFromParcel(Parcel parcel) {
            return new GetAppListResult(parcel);
        }

        public GetAppListResult[] newArray(int i) {
            return new GetAppListResult[i];
        }
    }

    public GetAppListResult(Parcel parcel) {
        this.mAppList = (AppDetail[]) parcel.createTypedArray(AppDetail.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mAppList, i);
    }

    public AppDetail[] getAppList() {
        return this.mAppList;
    }

    public void setAppList(AppDetail[] appDetailArr) {
        this.mAppList = appDetailArr;
    }
}
