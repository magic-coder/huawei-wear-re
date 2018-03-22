package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppUniteApplyRecord;

public class GetActivityUniteApplyResult implements Parcelable {
    public static final Creator<GetActivityUniteApplyResult> CREATOR = new C66171();
    private AppUniteApplyRecord mAppUniteApplyRecord;

    final class C66171 implements Creator<GetActivityUniteApplyResult> {
        C66171() {
        }

        public GetActivityUniteApplyResult createFromParcel(Parcel parcel) {
            return new GetActivityUniteApplyResult(parcel);
        }

        public GetActivityUniteApplyResult[] newArray(int i) {
            return new GetActivityUniteApplyResult[i];
        }
    }

    public GetActivityUniteApplyResult(Parcel parcel) {
        this.mAppUniteApplyRecord = (AppUniteApplyRecord) parcel.readParcelable(AppUniteApplyRecord.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppUniteApplyRecord, i);
    }

    public AppUniteApplyRecord getApplyResult() {
        return this.mAppUniteApplyRecord;
    }

    public void setApplyDeleteResult(AppUniteApplyRecord appUniteApplyRecord) {
        this.mAppUniteApplyRecord = appUniteApplyRecord;
    }
}
