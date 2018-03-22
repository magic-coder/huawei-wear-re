package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppApplyDeleteRecord;

public class GetActivityApplyDeleteResult implements Parcelable {
    public static final Creator<GetActivityApplyDeleteResult> CREATOR = new C66161();
    private AppApplyDeleteRecord mAppApplyDeleteRecord;

    final class C66161 implements Creator<GetActivityApplyDeleteResult> {
        C66161() {
        }

        public GetActivityApplyDeleteResult createFromParcel(Parcel parcel) {
            return new GetActivityApplyDeleteResult(parcel);
        }

        public GetActivityApplyDeleteResult[] newArray(int i) {
            return new GetActivityApplyDeleteResult[i];
        }
    }

    public GetActivityApplyDeleteResult(Parcel parcel) {
        this.mAppApplyDeleteRecord = (AppApplyDeleteRecord) parcel.readParcelable(AppApplyDeleteRecord.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppApplyDeleteRecord, i);
    }

    public AppApplyDeleteRecord getApplyDeleteResult() {
        return this.mAppApplyDeleteRecord;
    }

    public void setApplyDeleteResult(AppApplyDeleteRecord appApplyDeleteRecord) {
        this.mAppApplyDeleteRecord = appApplyDeleteRecord;
    }
}
