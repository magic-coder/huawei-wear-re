package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.UniteAppDetail;

public class GetUniteAppListResult implements Parcelable {
    public static final Creator<GetUniteAppListResult> CREATOR = new C66311();
    private UniteAppDetail[] mUniteAppList;

    final class C66311 implements Creator<GetUniteAppListResult> {
        C66311() {
        }

        public GetUniteAppListResult createFromParcel(Parcel parcel) {
            return new GetUniteAppListResult(parcel);
        }

        public GetUniteAppListResult[] newArray(int i) {
            return new GetUniteAppListResult[i];
        }
    }

    public GetUniteAppListResult(Parcel parcel) {
        this.mUniteAppList = (UniteAppDetail[]) parcel.createTypedArray(UniteAppDetail.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mUniteAppList, i);
    }

    public UniteAppDetail[] getAppList() {
        return this.mUniteAppList;
    }

    public void setAppList(UniteAppDetail[] uniteAppDetailArr) {
        this.mUniteAppList = uniteAppDetailArr;
    }
}
