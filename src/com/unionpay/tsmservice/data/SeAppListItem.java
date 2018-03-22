package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SeAppListItem implements Parcelable {
    public static final Creator<SeAppListItem> CREATOR = new C65681();
    private AppDetail mAppDetail;
    private VirtualCardInfo mVirtualCardInfo;

    final class C65681 implements Creator<SeAppListItem> {
        C65681() {
        }

        public SeAppListItem createFromParcel(Parcel parcel) {
            return new SeAppListItem(parcel);
        }

        public SeAppListItem[] newArray(int i) {
            return new SeAppListItem[i];
        }
    }

    public SeAppListItem(Parcel parcel) {
        this.mAppDetail = (AppDetail) parcel.readParcelable(AppDetail.class.getClassLoader());
        this.mVirtualCardInfo = (VirtualCardInfo) parcel.readParcelable(VirtualCardInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppDetail, i);
        parcel.writeParcelable(this.mVirtualCardInfo, i);
    }

    public AppDetail getAppDetail() {
        return this.mAppDetail;
    }

    public void setAppDetail(AppDetail appDetail) {
        this.mAppDetail = appDetail;
    }

    public VirtualCardInfo getVirtualCardInfo() {
        return this.mVirtualCardInfo;
    }

    public void setVirtualCardInfo(VirtualCardInfo virtualCardInfo) {
        this.mVirtualCardInfo = virtualCardInfo;
    }
}
