package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.PhysicalCardInfo;

public class AppDownloadApplyResult implements Parcelable {
    public static final Creator<AppDownloadApplyResult> CREATOR = new C66081();
    private PhysicalCardInfo mPhysicalCardInfo;

    final class C66081 implements Creator<AppDownloadApplyResult> {
        C66081() {
        }

        public AppDownloadApplyResult createFromParcel(Parcel parcel) {
            return new AppDownloadApplyResult(parcel);
        }

        public AppDownloadApplyResult[] newArray(int i) {
            return new AppDownloadApplyResult[i];
        }
    }

    public AppDownloadApplyResult(Parcel parcel) {
        this.mPhysicalCardInfo = (PhysicalCardInfo) parcel.readParcelable(PhysicalCardInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPhysicalCardInfo, i);
    }

    public PhysicalCardInfo getPhysicalCardInfo() {
        return this.mPhysicalCardInfo;
    }

    public void setPhysicalCardInfo(PhysicalCardInfo physicalCardInfo) {
        this.mPhysicalCardInfo = physicalCardInfo;
    }
}
